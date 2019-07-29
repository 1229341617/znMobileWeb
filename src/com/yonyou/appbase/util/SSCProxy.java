package com.yonyou.appbase.util;

import java.util.Properties;

import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class SSCProxy {
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
	public String getBillDetail(String billtype,String billid) {
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("getBillDetail");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
			/*call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("string2", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] { isnew, json, project_code });// 远程调用*/
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] {billid,billtype});// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"调用单据详细信息接口异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
	}

	public String getUnApprovalDetails(String billno){
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("getUnApprovalDetails");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			//call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] {billno});// 远程调用
			System.out.println("--------------------" + result);
		} catch (Exception e) {
			result = "{\"message\":\"调用hello world接口异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
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
					/*call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string2", XMLType.XSD_STRING, ParameterMode.IN);
					// 设置返回值类型
					call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
					result = (String) call.invoke(new Object[] { isnew, json, project_code });// 远程调用*/
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
	public String getfilelist(String billid) {
		// 远程调用路径
		String result = "call failed!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(getncWsUrl());
			// 调用的方法名
			call.setOperationName("doQueryFile");
			// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			//call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call.invoke(new Object[] { billid });// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"调用查询文件接口异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
			return result;
		} 
		return result;
	}

	public String getimagelist(String billid, String pk_billtype,
			String checkman) {
		// 远程调用路径
				String result = "call failed!";
				Service service = new Service();
				Call call;
				try {
					call = (Call) service.createCall();
					call.setTargetEndpointAddress(getncWsUrl());
					// 调用的方法名
					call.setOperationName("showImage");
					// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
					call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
					call.addParameter("string2", XMLType.XSD_STRING, ParameterMode.IN);
					// 设置返回值类型
					call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
					result = (String) call.invoke(new Object[] { billid,pk_billtype,checkman });// 远程调用
				} catch (Exception e) {
					result = "{\"message\":\"调用查询文件接口异常！\",\"success_flag\":\"否\"}";
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
}
