package com.yonyou.util;

import org.springframework.web.context.ContextLoaderListener;


/**
 * 路径获取工具类
 * @author 37908
 *
 */
public class PathUtil {
	
	public static String getRealPath(String resource) {
		return ContextLoaderListener.getCurrentWebApplicationContext().getServletContext().getRealPath(resource);
	}

}
