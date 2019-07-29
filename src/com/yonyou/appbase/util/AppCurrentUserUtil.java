package com.yonyou.appbase.util;

import javax.servlet.http.HttpServletRequest;

import com.yonyou.iuap.cache.CacheManager;

public class AppCurrentUserUtil {
	
	private static CacheManager cache;
	
	private static final String USER_INFO = "user_info";
	
	/**
	 * 设置缓存对象
	 */
	private static CacheManager getCache(){
		if(cache==null){
			cache=SpringUtils.getBean(CacheManager.class);
		}
		return cache;
	} 
	
	
	/**
	 * 获取APP当前登录人邮箱
	 * @param request
	 * @return
	 */
	public static String getCurrentUserEmail(HttpServletRequest request){
		CacheManager cache=getCache();
		String userid=request.getParameter("userId");
		if(StrUtil.isEmpty(userid)){
			return null;
		}
		/*UserEntity user= cache.get(USER_INFO+userid);
		if(user==null){
			return null;
		}*/
		return "liuhuam@yonyou.com";
	}
	
	
	/**
	 * 获取APP当前登录人id
	 * @param request
	 * @return
	 */
	public static String getCurrentUserId(HttpServletRequest request){
		String userid=request.getParameter("userId");
//		if(StrUtil.isEmpty(userid)){
//			CacheManager cache=getCache();
//			String code=request.getParameter("code");
//			if(StrUtil.isEmpty(code)){
//				return null;
//			}
//			UserEntity user= cache.get(USER_INFO+code);
//			if(user==null){
//				return null;
//			}
//			userid=user.getPkSmUser();
//		}
		
		return userid;
	}


}
