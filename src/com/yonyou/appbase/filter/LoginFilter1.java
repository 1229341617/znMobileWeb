package com.yonyou.appbase.filter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.appbase.user.entity.ThreadUserInfo;
import com.yonyou.appbase.user.entity.Token;
import com.yonyou.appbase.user.entity.UserInfo;
import com.yonyou.appbase.user.entity.UserVO;
import com.yonyou.appbase.user.service.UserService;
import com.yonyou.appbase.util.HttpClientUtils;
import com.yonyou.component.encrypt.service.IAuthAppSuites;
import com.yonyou.component.encrypt.service.impl.AuthAppSuitesImp;
import com.yonyou.iuap.cache.CacheManager;

/**
 * Servlet Filter implementation class LoginFilter
 */
@Component
public class LoginFilter1 implements Filter {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginFilter1.class);

	private static final String ACCESS_TOKEN = "exam_access_token";

	private static final String CODE_PREFIX = "user_code_prefix";

	private CacheManager cache;

	private List<String> excludeUrlsList;

	private IAuthAppSuites authAppSuites;

	private static final String EXCLUDEURLS = "excludeUrls";

	private String znmobileBaseUrl;

	private String suiteKey;

	private String znmobile_appid;

	private String znmobile_secret;



	/**
	 * Default constructor.
	 */
	public LoginFilter1() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		//假如配置路径可以放过,就不进行过滤验证
		if(canIgnore(httpRequest)){
			chain.doFilter(request, response);
			return;
		}
		String code = request.getParameter("code");//获取用户编号
		Cookie[] cookies = null; //初始化Cookie
		if(StringUtils.isBlank(code)){//如果code为空,去前端缓存里面尝试读取
			try {
				cookies = httpRequest.getCookies();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(cookies!=null&&cookies.length>-1){
				for (Cookie cookie : cookies) {
					//设置cookie
					if("code".equals(cookie.getName())){
						code = cookie.getValue();
						break;
					}
				}	
			}
		}
		if(StringUtils.isNotBlank(code)){//如果code不为空,设置到缓存并添加到httpResponse
			//设置cookie
			Cookie cookie = new Cookie("code", code);
			cookie.setPath("/");
			cookie.setMaxAge(-1);
			httpResponse.addCookie(cookie);
		}
		String userInfoString = cache.get(CODE_PREFIX+code);////从缓存里面读取这个用户的唯一10分钟内有效的缓存值,
		 //在后面的登陆接口处set,如果之前登陆过则能取到key为CODE_PREFIX+code的值
		if(StringUtils.isBlank(userInfoString)){//10分钟之内没有登陆过,前台又没有传入code,需要到前台钉钉入口登陆
			if(StringUtils.isBlank(code)){
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().println("请从钉钉进入");
				return;
			}
			this.login(httpRequest,httpResponse);//如果最近10分钟没有登陆过,但前台传入了code,通过后端nc登录接口验证
		}else{
			JSONObject json = (JSONObject) JSONObject.parse(userInfoString);
			String str=URLEncoder.encode(json.getString("name"),"UTF-8");
			Cookie name = new Cookie("name",str);
			name.setPath("/");
			name.setMaxAge(-1);
			Cookie pic = new Cookie("pic", json.getString("avatar"));
			pic.setPath("/");
			pic.setMaxAge(-1);
			Cookie userid = new Cookie("userid", json.getString("memberId"));
			userid.setPath("/");
			userid.setMaxAge(-1);
			httpResponse.addCookie(name);
			httpResponse.addCookie(pic);
			httpResponse.addCookie(userid);
			ThreadUserInfo.setCurrentUserInfo(JSONObject.parseObject(userInfoString,UserInfo.class));//把当前用户信息放到后台缓存
			//this.saveUserInfo(JSONObject.parseObject(userInfoString,UserInfo.class));//需要保存用户到本地的时候使用
		}
		chain.doFilter(request, response); //执行过滤器
			
	}

	/**
	 * 判断路径是否可放过
	 * @param request
	 * @return
	 */
	private boolean canIgnore(HttpServletRequest request) {
		String url = request.getServletPath();
		for (String ignore : excludeUrlsList) {
			if (url.startsWith(ignore) || url.endsWith(ignore)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 如果最近10分钟没有登陆过,但前台传入了code,通过后端nc登录接口验证
	 * @param request
	 * @return
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		logger.info("登录开始，code为：" + code);
		String token = "";
		try {
			token = this.getToken(code);
		} catch (Exception e1) {
			logger.error("获取token失败:", e1);
			return;
		}
		logger.info("token为" + token);
		// 使用免登接口获得用户信息
		String url = znmobileBaseUrl + "/certified/userInfo/" + code
				+ "?access_token=" + token;
		try {
			String string = HttpClientUtils.doGet(url, String.class);
			logger.info("certified userInfo response：" + string);
			JSONObject json = (JSONObject) JSONObject.parse(string);
			json = json.getJSONObject("data");
			UserInfo userInfo = new UserInfo();
			userInfo.setMemberId(json.getString("member_id"));
			userInfo.setAvatar(json.getString("avatar"));
			userInfo.setName(json.getString("name"));
			userInfo.setEmail(json.getString("email"));
			userInfo.setDeptName(json.getString("dept_name"));
			ThreadUserInfo.setCurrentUserInfo(userInfo);
			this.saveUserInfo(userInfo);
			cache.setAndExpireInPipeline(CODE_PREFIX + code,
					JSONObject.toJSONString(userInfo), 24 * 60 * 60);
			Cookie usercode = new Cookie("code", code);
			usercode.setPath("/");
			usercode.setMaxAge(-1);
			String str = URLEncoder.encode(json.getString("name"), "UTF-8");
			Cookie name = new Cookie("name", str);
			name.setPath("/");
			name.setMaxAge(-1);
			Cookie pic = new Cookie("pic", json.getString("avatar"));
			pic.setPath("/");
			pic.setMaxAge(-1);
			Cookie userid = new Cookie("userid", json.getString("member_id"));
			userid.setPath("/");
			userid.setMaxAge(-1);

			response.addCookie(name);
			response.addCookie(pic);
			response.addCookie(userid);
			response.addCookie(usercode);

		} catch (Exception e) {
			logger.error("LoginFilter登录失败", e);
		}
	}

	private void saveUserInfo(UserInfo userInfo) {
		UserService userservice =(UserService) SpringInit.getApplicationContext().getBean("userService");
		
		userservice.save(new UserVO(userInfo));
	}

	/**
	 * @see Filter#init(FilterConfig) 初始化方法
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// 处理不需要拦截的路径
		String excludeUrls = filterConfig.getInitParameter(EXCLUDEURLS);
		this.excludeUrlsList = Arrays.asList(excludeUrls.split(","));

		ServletContext sc = filterConfig.getServletContext();
		XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils
				.getWebApplicationContext(sc);
		// 缓存
		if (cache == null) {
			cache = cxt.getBean(CacheManager.class);
		}

		if (authAppSuites == null) {
			authAppSuites = cxt.getBean(AuthAppSuitesImp.class);
		}
		
//		if (webTokenProcessor == null) {
//			SpringInit.setApplicationContext(cxt);
//			webTokenProcessor = cxt.getBean(DefaultTokenPorcessor.class);
//		}

		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("conf.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			logger.error("LoginFilter加载conf.properties失败", e);
		}

		if (StringUtils.isBlank(znmobileBaseUrl)) {
			znmobileBaseUrl = properties.getProperty("isv_auth_base_path");
		}

		if (StringUtils.isBlank(suiteKey)) {
			suiteKey = properties.getProperty("isv_auth_suite_key");
		}

		if (StringUtils.isBlank(znmobile_appid)) {
			znmobile_appid = properties.getProperty("znmobile.appid");
		}

		if (StringUtils.isBlank(znmobile_secret)) {
			znmobile_secret = properties.getProperty("znmobile.secret");
		}

	}

	/**
	 * 获取ACCESS_TOKEN
	 * 
	 * @return
	 */
	private String getToken(String code) {
		String access_token = cache.get(ACCESS_TOKEN);
		if (StringUtils.isBlank(access_token)) {
			String tokenUrl = znmobileBaseUrl + "/service/portalTaskSSORegServlet?userCode=" + code
					+ "&cz=0";
			logger.info("get tokenUrl is :" + tokenUrl);
			JSONObject rep = HttpClientUtils.doGet(tokenUrl, JSONObject.class);
			logger.info("获取token返回响应体为：" + rep);
			Token token = JSONObject.parseObject(rep.getString("data"),
					Token.class);
			access_token = token.getAccess_token();
			cache.setAndExpireInPipeline(ACCESS_TOKEN, token.getAccess_token(),
					token.getExpiresIn() / 2);
		}
		return access_token;
	}

}
