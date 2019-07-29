package com.yonyou.appbase.util;

import java.util.Properties;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.appbase.user.entity.Token;
import com.yonyou.iuap.cache.CacheManager;

/**
 * 获取调用Token的工具
 * @author luochp3
 *
 */
public class TokenUtil {
	
	//将获取到的upesn,token存在缓存中
	private static final String UPESN_TOKEN_PREFIX = "upesn_token";
	//友空间获取的token
	private static final String APP_TOKEN_PREFIX = "app_token";
	//缓存
	private static CacheManager cache;
	//openapi路径
	private static String znmobileBaseUrl;
	//友空间路径
	private static String AppBaseUrl;
	//APPID
	private static String upesn_appid;
	//秘钥
	private static String upesn_secret;
	//友空间APPID
	private static String app_appid;
	//友空间秘钥
	private static String app_secret;
	
	public static String getToken(String app,String code){
		String accessToken=null;
		// 缓存
		if (cache == null) {
			cache = SpringUtils.getBean(CacheManager.class);
		}
		if("znmobile".equals(app)){
			accessToken=cache.get(APP_TOKEN_PREFIX+code);
		}else{
			accessToken=cache.get(UPESN_TOKEN_PREFIX+code);
		}
		//判断缓存中是否存在token
		if(!StrUtil.isEmpty(accessToken)){
			return accessToken;
		}
		
		//不存在则去获取
		Properties properties=PropertiesUtil.getProperties();
		if (StrUtil.isEmpty(app_appid)) {
			app_appid = properties.getProperty("app_appid");
		}
		if (StrUtil.isEmpty(app_secret)) {
			app_secret = properties.getProperty("app_secret");
		}
		if (StrUtil.isEmpty(AppBaseUrl)) {
			AppBaseUrl = properties.getProperty("task_base_path");
		}
		
		if (StrUtil.isEmpty(znmobileBaseUrl)) {
			znmobileBaseUrl = properties.getProperty("isv_auth_base_path");
		}

		if (StrUtil.isEmpty(upesn_appid)) {
			upesn_appid = properties.getProperty("upesn.appid");
		}

		if (StrUtil.isEmpty(upesn_secret)) {
			upesn_secret = properties.getProperty("upesn.secret");
		}
		
		if("znmobile".equals(app)){
			String tokenUrl = znmobileBaseUrl + "/service/portalTaskSSORegServlet?userCode=" + code
					+ "&cz=0";
			String myToken = HttpClientUtils.doGetToken(tokenUrl);
			accessToken = myToken;
			cache.setAndExpireInPipeline(APP_TOKEN_PREFIX+code, accessToken,1);
		}else{
			String tokenUrl = znmobileBaseUrl + "/token/?appid=" + upesn_appid
					+ "&secret=" + upesn_secret;
			JSONObject rep = HttpClientUtils.doGet(tokenUrl, JSONObject.class);
			Token token = JSONObject.parseObject(rep.getString("data"),Token.class);
			accessToken = token.getAccess_token();
			cache.setAndExpireInPipeline(UPESN_TOKEN_PREFIX+code, accessToken,token.getExpiresIn() / 2);
		}
		return accessToken;
		
	}

}
