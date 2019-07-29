package com.yonyou.appbase.util;

/**
 * @author: lugl9
 * @description:
 * @date: Created in 下午3:57 2018/3/6
 * @modified by:
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 * Create by galen on 2017/8/4
 */
public final class PropsUtil {

	/**
	 * 加载配置文件
	 * @param fileName
	 * @return
	 */
	public static Properties loadProps(String fileName){
		Properties properties = null;
		InputStream is = null;
		try {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			if (is == null) throw new FileNotFoundException(fileName + " file is not found");
			properties = new Properties();
			properties.load(is);
		}catch (IOException e){
			e.printStackTrace();
		}finally {
			if (is != null){
				try {
					is.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		return properties;
	}

	/**
	 * 获取String型属性
	 * 默认为空字符串
	 */

	public static String getString(Properties properties, String key){
		return getString(properties, key, "");
	}

	/**
	 * 获取String型属性，可指定默认值
	 */

	public static String getString(Properties properties, String key, String defaultValue){
		return properties.containsKey(key) ? properties.getProperty(key) : defaultValue;
	}

}
