package com.yonyou.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.dom4j.Document;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.appbase.filter.LoginFilter;
import com.yonyou.appbase.util.Logger;
import com.yonyou.component.encrypt.service.impl.AuthAppSuitesImp;
import com.yonyou.iuap.persistence.vo.pub.BusinessException;
import com.yonyou.metadata.mybatis.util.XMLUtil;

public class Testjson {
	private static final org.slf4j.Logger logger =  LoggerFactory.getLogger(Testjson.class);

	public Testjson() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		String json="{\"Body\":{\"GetBillDataHandler\":{\"billtype\":\"H541-Cxx-01\",\"taskid\":\"1001B210000000IMRHWP\",\"userid\":\"0001A110000000002TFO\",\"@encodingStyle\":\"http://schemas.xmlsoap.org/soap/encoding/\"}}}";
		JSONObject  jsonObj1 = JSONObject.parseObject(json);
//		boolean hasjtfy=jsonObj1.containsKey("Body");
		JSONObject  jsonObj2 = JSONObject.parseObject(jsonObj1.getString("Body"));
		//System.out.print(jsonObj2.toString());
		//executeTask();
	//	System.out.print(jsonObj2.g);
			/*String str = "{FYXID:4C4600835174411190C739805DE593BC,ZFY:0,FYXMC:保安保洁费}";
			JSONObject jsonObject = new JSONObject(str);*/
		/*	Iterator<String> it = (Iterator<String>) jsonObj2.entrySet();
			while(it.hasNext()){
			// 获得key
			String key = it.next(); 
			String value = jsonObj2.getString(key);    
			System.out.println("key: "+key+",value:"+value);
	}*/

		
		String name="勒孚风 提交单据, 单据号: H5412018121400000121, 请审批单据";//待办任务名称
		
		//String name="勒孚风提交单据,单据号:H5412018121400000121,请审批单据";//待办任务名称
		name=name.replaceAll("\\s*", "");
		System.out.print(name);
  }
	
	public static void executeTask() throws BusinessException
	{// 获取Servlet连接并设置请求的方法
		BufferedInputStream input = null;
		BufferedOutputStream out = null;
		String message="";
		try
		{
			String url = "http://localhost/servlet/MobileBillServlet";
			// String url =
			// "http://172.23.47.194:80/service/XChangeServlet?account=develop&groupcode=1";
			URL realURL;
			realURL = new URL(url);
			/*HttpURLConnection connection = (HttpURLConnection) realURL.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-type", "text/xml");
			//conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
			connection.setRequestMethod("POST");
			// 将Document对象写入连接的输出流中
			File file = new File("C:/Users/liu/Desktop/1.txt");
			out = new BufferedOutputStream(connection.getOutputStream());
			input = new BufferedInputStream(new FileInputStream(file));
			int length;
			byte[] buffer = new byte[1000];
			while ((length = input.read(buffer, 0, 1000)) != -1)
			{
				out.write(buffer, 0, length);
			}
			input.close();
			out.close();
			// 从连接的输入流中取得回执信息
			InputStream inputStream = connection.getInputStream();
			Document resDoc = (Document) XMLUtil.getDocumentBuilder().parse(inputStream); // 解析为Doc对象
*/			// 对回执结果的后续处理…
			HttpURLConnection connection= (HttpURLConnection) realURL.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            connection.setRequestProperty("Content-type","application/x-javascript->json");
            connection.connect();
            OutputStream outputStream=connection.getOutputStream();
            JSONObject jsonObject = new JSONObject(); 
            jsonObject.put("method", "getBillData");
            jsonObject.put("userid", "1001A110000000012UKU");
            jsonObject.put("taskid", "1001B410000000IMKUZO");
            jsonObject.put("billtype", "H541-Cxx-01");
            jsonObject.put("billname", "测试");
           /* StringBuffer sb=new StringBuffer();
            sb.append("method=");
            sb.append("getBillData&");
            sb.append("userid=");
            sb.append("1001A110000000012UKU&");
            sb.append("taskid=");
            sb.append("1001B410000000IMKUZO&");
            sb.append("billtype=");
            sb.append("H541-Cxx-01&");
            sb.append("billname=");
            sb.append("测试");*/
            String param=jsonObject.toString();
            outputStream.write(param.getBytes());
            outputStream.flush();
            outputStream.close();
        	((org.slf4j.Logger) logger).info("日志开始，responseCode为：" + connection.getResponseCode());
        	int code = connection.getResponseCode();
        	if (code == 200) {
        		 InputStream inputStream=connection.getInputStream();
                 byte[] data=new byte[10240000];
                 StringBuffer sb1=new StringBuffer();
                 int length=0;
                 while ((length=inputStream.read(data))!=-1){
                     String s=new String(data);
                     sb1.append(s);
                 }
                 message=new String(sb1.toString().getBytes("ISO-8859-1"),"UTF-8");
                 inputStream.close();
        	}
            System.out.print(message);
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
