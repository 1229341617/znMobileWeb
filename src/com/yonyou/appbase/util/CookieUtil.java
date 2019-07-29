package com.yonyou.appbase.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 获取cookies 的工具类
 * @author luochp3
 *
 */
public class CookieUtil {
	
	/**
	 * 获取cookies
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String getCookise(HttpServletRequest request,String cookieName){
		String result="";
		Cookie[] cookies = request.getCookies();
		if(!StrUtil.isEmpty(cookieName)){
			if(cookies!=null&&cookies.length>-1){
				for (Cookie cookie : cookies) {
					//设置cookie
					if(cookieName.equals(cookie.getName())){
						result = cookie.getValue();
						break;
					}
				}	
			}
		}
		return result;
	} 
}
