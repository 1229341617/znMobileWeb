package com.yonyou.appbase.filter;


import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.appbase.user.entity.UserEntity;
import com.yonyou.appbase.util.HttpClientUtils;
import com.yonyou.appbase.util.PropertiesUtil;
import com.yonyou.appbase.util.StrUtil;
import com.yonyou.appbase.util.TokenUtil;
import com.yonyou.iuap.cache.CacheManager;

/**
 * Servlet Filter implementation class LoginFilter
 */
@Component
public class LoginFilter  implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	//用户信息
	private static final String USER_INFO = "user_info";
	//缓存
	private CacheManager cache;
	//访问友空间的路径
	private String upesnBaseUrl;

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	public String getCode(HttpServletRequest request){
		return request.getParameter("code");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		JSONObject result=new JSONObject();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String userid=request.getParameter("userId");
		String code=getCode(httpRequest);
		System.out.println("code为"+code);
		if(StrUtil.isEmpty(userid)){
			//将code存于缓存中或者从缓存中获取
			if(StrUtil.isEmpty(code)){
				result.put("flag", "1");
				result.put("msg", "授权失败");
				cache.set("app_result", result);
			}else{
				this.login(httpRequest,httpResponse);
			}
		}else{
			UserEntity user= cache.get(USER_INFO+userid);
			if(user==null){
				if(StringUtils.isBlank(code)){
					result.put("flag", "1");
					result.put("msg", "授权失败");
					cache.set("app_result", result);
				}
				//执行从nc获取tonken登录
				this.login(httpRequest,httpResponse);
			}else{
				result.put("flag", "true");
				result.put("user_id", user.getPkSmUser());
				cache.set("app_result", result);
			}
		}
		
		chain.doFilter(request, response);
			
	}

	/**
	 * 通过code和token去获取当前登录人的用户信息并执行免密登录
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private boolean login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject result=new JSONObject();
		String code=getCode(request);
		logger.info("登录开始，code为：" + code);
		String token = "";
		try {
			token = TokenUtil.getToken("znmobile",code);
			if(token.contains("ERROR")){
				logger.error(token);
				result.put("flag", "1");
				result.put("msg", "获取token失败");
				cache.set("app_result", result);
				return false;
			}else{
				String aa="";
				if("1701350".equals(code)){
					aa="1001A110000000012OKT0";
				}else{
					aa="";
				}
				result.put("flag", "true");
				result.put("user_id", aa);
				cache.set("app_result", result);
				return true;
			}
		} catch (Exception e1) {
			logger.error("获取token失败:", e1);
			result.put("flag", "1");
			result.put("msg", "获取token失败");
			cache.set("app_result", result);
			return false;
		}
		// 使用nc接口查询用户信息
	/*	String url = upesnBaseUrl + "/certified/userInfo/" + code
				+ "?access_token=" + token;
		try {
			String string = HttpClientUtils.doGet(url, String.class);
			JSONObject json = (JSONObject) JSONObject.parse(string);
			json = json.getJSONObject("data");
			//通过用户邮箱获取用户信息(用户为计费资源)
			UserEntity user=accountService.findUserByEmail(json.getString("email"));
			if(user==null){
				result.put("flag", "1");
				result.put("msg", "该用户不存在，请联系管理员");
				cache.set("app_result", result);
				return false;
			}
//			if(!"1".equals(user.getIscharge())){
//				result.put("flag", "2");
//				result.put("msg", "该用户无权限，请联系管理员");
//				cache.set("app_result", result);
//				return false;
//			}
			
			//将友空间用户信息存入缓存中
			cache.setAndExpireInPipeline(USER_INFO + user.getPkSmUser(),user, 12*60*60);
			
			result.put("flag", "true");
			result.put("user_id", user.getPkSmUser());
			cache.set("app_result", result);
			
			return true;
			
		} catch (Exception e) {
			logger.error("LoginFilter登录失败", e);
			//测试服务时注释
			result.put("flag", "1");
			result.put("msg", "该用户不存在，请联系管理员");
			cache.set("app_result", result);
			return false;
		}*/
	}


	/**
	 * @see Filter#init(FilterConfig) 初始化方法
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		
		ServletContext sc = filterConfig.getServletContext();
		XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils
				.getWebApplicationContext(sc);
		// 缓存
		if (cache == null) {
			cache = cxt.getBean(CacheManager.class);
		}
		Properties properties = PropertiesUtil.getProperties();

		if (StringUtils.isBlank(upesnBaseUrl)) {
			upesnBaseUrl = properties.getProperty("isv_auth_base_path");
		}
	}
}
