package com.yonyou.appbase.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.test.Testjson;

public class OaAndMobileProxy {
	private static final org.slf4j.Logger logger =  LoggerFactory.getLogger(Testjson.class);
   
	
	public String getMyToDoList(String userCode,String searchname) {
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("getMyToDoList");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
			//call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] { userCode,searchname });// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"调用待办接口异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
	}
	
	public String getBillDetail(String userid,String taskid, String billtype, String billid) {
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		InputStream inputStream = null;
		String message="{\"message\":\"查询单据明细异常！\"}";
		StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
		try
		{
			String url = getncMobileWsUrl();
			URL realURL;
			realURL = new URL(url);
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
            jsonObject.put("userid", userid);
            jsonObject.put("taskid", billid);
            jsonObject.put("billtype", billtype);
            String param=jsonObject.toString();
            outputStream.write(param.getBytes());
            outputStream.flush();
            outputStream.close();
        	int code = connection.getResponseCode();
        	if (code == 200) {
        		inputStreamReader = new InputStreamReader(connection.getInputStream(), "UTF-8");
        		reader = new BufferedReader(inputStreamReader);
        		while ((tempLine = reader.readLine()) != null) {
                    resultBuffer.append(tempLine);
                }
        		message = new String(resultBuffer.toString().getBytes("ISO-8859-1"), "UTF-8");
        		connection.getInputStream().close();
        	}
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            return message;
        }finally {
            if (reader != null) {
                try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            if (inputStreamReader != null) {
                try {
					inputStreamReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            if (inputStream != null) {
                try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
		return message;
	}
	
	public String approval(String billtype, String billid, String checkResult,
			String checkman, String checkNote, String pk_flow,String workflowtype) {
		// 远程调用路径
				String result = "call failed!";
				Service service = new Service();
				Call call;
				try {
					call = (Call) service.createCall();
					call.setTargetEndpointAddress(getncWsUrl());
					// 调用的方法名
					call.setOperationName("processApprove");
					// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
					call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string2", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string3", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string4", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string5", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string6", XMLType.XSD_STRING, ParameterMode.IN);
					// 设置返回值类型
					call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
					result = (String) call.invoke(new Object[] {billtype,billid,checkResult,checkman,checkNote,pk_flow,workflowtype});// 远程调用
				} catch (Exception e) {
					result = "{\"message\":\"调用办理接口异常！\",\"success_flag\":\"否\"}";
					e.printStackTrace();
					return result;
				} 
				return result;
	}
	
	public String getBillTypeName(String billtype) {
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("getBillTypeNameByBillType");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] { billtype });// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"查询单据类型名称异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
	}
	
	public String getSender(String pk_user) {
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("getSender");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] { pk_user });// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"查询发送人异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
	}
	
	public String getSenderdate(String pk_taskid) {
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("getSenderdate");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] { pk_taskid });// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"查询发送日期异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
	}
	
	public String getApproveHistoryInfo(String billid, String billtype) {
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("getApproveHistoryInfo");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] { billid, billtype });// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"查询审批信息异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
	}
	
	public String getFileList(String billid,String billtype) {
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("getFileList");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] { billid, billtype });// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"查询审批信息异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
	}
	
	public String getFileContent(String pk_attachment) {
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("getFileContent");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			//call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] { pk_attachment });// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"查询审批信息异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
	}

	 private String getncWsUrl(){
    	Properties properties=PropertiesUtil.getProperties();
    	String ncWsUrl = properties.getProperty("ncWsUrl");
    	return ncWsUrl;
	 }
	 
	 private String getncMobileWsUrl(){
    	Properties properties=PropertiesUtil.getProperties();
    	String ncWsUrl = properties.getProperty("ncMobileWsUrl");
    	return ncWsUrl;
    }
}
