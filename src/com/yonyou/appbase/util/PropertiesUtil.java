package com.yonyou.appbase.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取配置文件的工具
 * @author luochp3
 *
 */
public class PropertiesUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	
	private static Properties properties=null;
	
	/**
	 * 获取properties对象
	 * @return
	 */
	public static Properties getProperties(){
		properties=new Properties();
		//没有则去读取
		InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("conf.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			logger.error("LoginFilter加载conf.properties失败", e);
		}
		return properties;
	}
	
	/**
	 * 
	 * @param filePath
	 * @param pKey
	 * @param pValue
	 * @throws IOException
	 * 
	 */
	public static void WriteProperties(String pKey, String pValue) throws IOException {
         if(properties==null){
        	 properties=getProperties();
         }
         URL filePath=PropertiesUtil.class.getClassLoader().getResource("application.properties");
         //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
         OutputStream out = new FileOutputStream(filePath.getPath());
         properties.setProperty(pKey, pValue);
        //以适合使用 load 方法加载到 Properties 表中的格式，  
         //将此 Properties 表中的属性列表（键和元素对）写入输出流  
         properties.store(out, "Update name");
     }

}
