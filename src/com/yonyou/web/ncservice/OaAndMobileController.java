package com.yonyou.web.ncservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Decoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yonyou.appbase.util.OaAndMobileProxy;
import com.yonyou.appbase.util.PropertiesUtil;
import com.yonyou.appbase.util.StrUtil;
import com.yonyou.appbase.web.BaseController;
import com.yonyou.component.ncservice.service.ZnmobileService;
import com.yonyou.component.ncservice.vo.UnApprovalVO;
import com.yonyou.iuap.cache.CacheManager;
import com.yonyou.util.FileUtils;
import com.yonyou.util.PathUtil;

@Controller
@RequestMapping(value = "/front/oaandmobile")
public class OaAndMobileController extends BaseController {
	@Autowired
	private CacheManager cache;
	@Autowired
	private ZnmobileService znmobileService;

	/**
	 * 我的待办查询-yangyt
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/getMyToDoList", method = RequestMethod.GET)
	public @ResponseBody Object getMyToDoList(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		String usercode = request.getParameter("code");
		String searchname = URLDecoder.decode(
				request.getParameter("searchname"), "utf-8");
		JSONObject result1 = new JSONObject();
		String result = "{\"message\":\"call failed!\"}";
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
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result = (String) call
					.invoke(new Object[] { usercode, searchname });// 远程调用
		} catch (Exception e) {
			result = "{\"message\":\"调用审批流接口异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
		}
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject
				.fromObject(result);
		net.sf.json.JSONArray jsonObj1 = net.sf.json.JSONArray
				.fromObject(jsonObj.getString("msg"));
		// List<UnApprovalVO> listproject=new ArrayList<UnApprovalVO>();
		JSONObject data = new JSONObject();
		if (jsonObj1.size() > 0) {
			for (int i = 0; i < jsonObj1.size(); i++) {
				HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
				net.sf.json.JSONObject job = jsonObj1.getJSONObject(i);
				ArrayList<String> array1 = new ArrayList<String>();
				array1.add("单据类型");
				array1.add(job.getString("pk_billtype"));
				ArrayList<String> array2 = new ArrayList<String>();
				array2.add("单据类型名称");
				array2.add(job.getString("billtypename"));
				ArrayList<String> array3 = new ArrayList<String>();
				array3.add("移动单据类型");
				if (job.has("mobilebilltype")) {
					array3.add(job.getString("mobilebilltype"));
				} else {
					array3.add("type00");
				}
				ArrayList<String> array4 = new ArrayList<String>();
				array4.add("单据id");
				array4.add(job.getString("billid"));
				ArrayList<String> array5 = new ArrayList<String>();
				array5.add("单据号");
				array5.add(job.getString("billno"));
				ArrayList<String> array6 = new ArrayList<String>();
				array6.add("发送人姓名");
				array6.add(job.getString("sender_name"));
				ArrayList<String> array7 = new ArrayList<String>();
				array7.add("发送人姓");
				if (!"".equals(job.getString("sender_name"))) {
					array7.add(job.getString("sender_name").substring(1));
				} else {
					array7.add("");
				}
				ArrayList<String> array8 = new ArrayList<String>();
				array8.add("发送人");
				array8.add(job.getString("senderman"));
				ArrayList<String> array9 = new ArrayList<String>();
				array9.add("发送日期");
				array9.add(job.getString("senddate"));
				ArrayList<String> array10 = new ArrayList<String>();
				array10.add("主题");
				array10.add(job.getString("subject"));
				ArrayList<String> array11 = new ArrayList<String>();
				array11.add("审批人");
				array11.add(job.getString("checkman"));
				ArrayList<String> array12 = new ArrayList<String>();
				array12.add("ID");
				array12.add(job.getString("taskid"));
				ArrayList<String> array13 = new ArrayList<String>();
				array13.add("流程类型");
				array13.add(job.getString("workflow_type"));
				ArrayList<String> array14 = new ArrayList<String>();
				array14.add("合计金额");
				array14.add("0");
				map.put("pk_billtype", array1);
				map.put("billtypename", array2);
				map.put("mobilebilltype", array3);
				map.put("billid", array4);
				map.put("billno", array5);
				map.put("sender_name", array6);
				map.put("shortname", array7);
				map.put("senderman", array8);
				map.put("senddate", array9);
				map.put("subject", array10);
				map.put("checkman", array11);
				map.put("taskid", array12);
				map.put("workflow_type", array13);
				map.put("total", array14);
				data.put("data" + i + "", map);

			}
		}
		result1.put("flag", "success");
		result1.put("msg", "查询成功");
		result1.put("data", data);
		return result1;
	}

	/**
	 * 初始化判断是否可以登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getTokenInfo", method = RequestMethod.GET)
	public @ResponseBody Object getTokenInfo(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject result = cache.get("app_result");
		return result;
	}

	@RequestMapping(value = "/getunapproval", method = RequestMethod.GET)
	public @ResponseBody Object getUnApproval(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		JSONObject result = new JSONObject();
		// 获取用户id
		//String userpk = AppCurrentUserUtil.getCurrentUserId(request);
		List<UnApprovalVO> listproject = new ArrayList<UnApprovalVO>();
		UnApprovalVO unApprovalVO = null;
		String usercode = request.getParameter("code");
		String searchname = URLDecoder.decode(
				request.getParameter("searchname"), "utf-8");
		// OaAndMobileProxy sc = new OaAndMobileProxy();
		// String result1=sc.getMyToDoList(usercode,searchname);
		String result2 = "{\"message\":\"call failed!\"}";
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
			// 设置返回值类型
			call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
			result2 = (String) call
					.invoke(new Object[] { usercode, searchname });// 远程调用
		} catch (Exception e) {
			result2 = "{\"message\":\"调用审批流接口异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
		}
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject
				.fromObject(result2);
		if ("".equals(jsonObj.getString("msg"))) {
			result.put("flag", "success");
			result.put("msg", "当前人没有审批单据");
			result.put("data", listproject);
			return result;
		}
		net.sf.json.JSONArray jsonObj1 = net.sf.json.JSONArray
				.fromObject(jsonObj.getString("msg"));// jsonObj1.get("Description")
		if (jsonObj1.size() > 0) {
			for (int i = 0; i < jsonObj1.size(); i++) {
				net.sf.json.JSONObject job = jsonObj1.getJSONObject(i);
				if (!"264".equals(job.getString("pk_billtype").substring(0, 3))
						&& !"263".equals(job.getString("pk_billtype")
								.substring(0, 3))
						&& !"261".equals(job.getString("pk_billtype")
								.substring(0, 3))) {
					continue;
				}
				unApprovalVO = new UnApprovalVO();
				unApprovalVO.setPkBilltype(job.getString("pk_billtype"));
				unApprovalVO.setBilltypename(job.getString("billtypename"));
				if (job.has("mobilebilltype")) {
					unApprovalVO.setMobilebilltype(job
							.getString("mobilebilltype"));
				} else {
					unApprovalVO.setMobilebilltype("type00");
				}
				unApprovalVO.setBillid(job.getString("billid"));
				unApprovalVO.setBillno(job.getString("billno"));
				unApprovalVO.setSenderName(job.getString("sender_name"));
				if (!"".equals(job.getString("sender_name"))) {
					unApprovalVO.setShortName(job.getString("sender_name")
							.substring(1));
				}
				unApprovalVO.setSenderman(job.getString("senderman"));
				unApprovalVO.setSenddate(job.getString("senddate"));
				unApprovalVO.setSubject(job.getString("subject"));
				unApprovalVO.setCheckman(job.getString("checkman"));
				unApprovalVO.setTaskid(job.getString("taskid"));
				unApprovalVO.setWorkflow_type(job.getString("workflow_type"));
				unApprovalVO.setTotal("0");
				listproject.add(unApprovalVO);
			}
		}
		result.put("flag", "success");
		result.put("msg", "查询成功");
		result.put("data", listproject);
		return result;

	}
	
	@RequestMapping(value = "/downFile/{pk_file}", method = RequestMethod.POST)
	public void downFile(HttpServletResponse response, HttpServletRequest  request,@PathVariable String pk_file){
		
		/*String pk_file = request.getParameter("filename");
		pk_file = "1001B210000000LPHDBW";*/
		OaAndMobileProxy sc = new OaAndMobileProxy();
		String fileJson = sc.getFileContent(pk_file);
		if(!fileJson.contains("message")) {
			JSONObject fileObj1 = JSONObject.parseObject(fileJson);
			JSONObject fileObj2 = JSONObject.parseObject(fileObj1.get("msg").toString());
			
			
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] content = null;
			try {
				content = decoder.decodeBuffer(fileObj2.getString("attachment"));
				String allName = fileObj2.getString("filename");// 文件全名
				int nindex = allName.lastIndexOf(".");
				String suffix = "";// 扩展名
				if (nindex > -1) {
					suffix = allName.substring(nindex);
				}
				String fileName = pk_file+ suffix;
				
				String path = PathUtil.getRealPath("")
						+ "/fileupload/oa/billfile/";
				File file = FileUtils.writeFile(content, path, fileName);

				//response.setContentType("application/octet-stream");
				response.setContentType("multipart/form-data");   
				response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(allName, "UTF-8"));
				response.setContentLength((int) file.length());
				response.setCharacterEncoding("UTF-8");
		        FileInputStream in = new FileInputStream(file);
		        // 创建输出流
		        OutputStream out = response.getOutputStream();
		        // 创建缓冲区
		        byte buffer[] = new byte[1024];
		        int len = 0;
		        // 循环将输入流中的内容读取到缓冲区当中
		        while ((len = in.read(buffer)) > 0) {
		            // 输出缓冲区的内容到浏览器，实现文件下载
		            out.write(buffer, 0, len);
		        }
		        // 关闭文件输入流
		        in.close();
		        // 关闭输出流
		        out.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 审批接口-yangyt
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/approval", method = RequestMethod.GET)
	public @ResponseBody Object approval(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result=new JSONObject();
		String billtype=request.getParameter("billtype");
		String billid=request.getParameter("billid");
		String checkResult=request.getParameter("checkResult");
		String checkman=request.getParameter("checkman");
		String checkNote=request.getParameter("checkNote");
//		try {
//			checkNote = new String(checkNote.getBytes("ISO-8859-1"), "UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
		String pk_flow=request.getParameter("pk_flow");
		String workflowtype=request.getParameter("workflowtype");
		String result2 = "{\"message\":\"call failed!\"}";
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
			result2 = (String) call.invoke(new Object[] { billtype,billid,checkResult,checkman,checkNote,pk_flow,workflowtype});// 远程调用
		} catch (Exception e) {
			result2 = "{\"message\":\"调用审批流接口异常！\",\"success_flag\":\"否\"}";
			e.printStackTrace();
		}
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(result2);
		String msg="";
		String status="";
		net.sf.json.JSONObject  jsonObj1 =null;
		if(StrUtil.nullToString(jsonObj.getString("msg")).contains("{")){
			 jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));//jsonObj1.get("Description")	
			 status=jsonObj1.getString("status");
			 boolean hasmsg=jsonObj1.has("msg");
			 if(hasmsg){
				 msg=jsonObj1.getString("msg"); 
			 }
		}else{
			msg=jsonObj.getString("msg");
		}
		if(!"1".equals(status)){
			result.put("msg", msg);
			result.put("flag", "fail");
		}else{
			if("Y".equals(checkResult)){
				result.put("msg", "审批成功");
			}else{
				result.put("msg", "驳回成功");
			}
			//clearTask(pk_flow);//办理完成后调用oa服务,从待办消除任务
			result.put("flag", "success");
		}
		return result;
		
	}
	private void clearTask(String pk_flow) {
		String uri=getOaTaskUrl();
		try {
        URL url = new URL(uri + "?id="+pk_flow+"");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoOutput(true); // 设置该连接是可以输出的
        connection.setRequestMethod("GET"); // 设置请求方式
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        connection.setConnectTimeout(30000);//30秒
        connection.setReadTimeout(30000);//30秒
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String line = null;
        StringBuilder result = new StringBuilder();
        while ((line = br.readLine()) != null) { // 读取数据
            result.append(line + "\n");
        }
        connection.disconnect();

        System.out.println(result.toString());
	 } catch (Exception e) {
         e.printStackTrace();
     }
	}
	
	
	/*@RequestMapping(value = "/getFileList", method = RequestMethod.GET)
	public @ResponseBody Object getFileList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		
		
		return null;
	}*/ 

	/**
	 * 查询单据明细-yangyt
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/getBillDetail", method = RequestMethod.GET)
	public @ResponseBody Object getBillDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		
		String billid=request.getParameter("billid");
		String billtype=request.getParameter("billtype");
		String checkman=request.getParameter("checkman");
		String pk_flow=request.getParameter("pk_flow");
		String pk_sender=request.getParameter("pk_sender");
		
		OaAndMobileProxy sc = new OaAndMobileProxy();
		String billDetailJson = sc.getBillDetail(checkman,pk_flow,billtype,billid);
		String billtypenamejson = sc.getBillTypeName(billtype);
		String sendermanjson = sc.getSender(pk_sender);
		String senddatejsonstr = sc.getSenderdate(pk_flow);
		String approvehisinfojsonstr = sc.getApproveHistoryInfo(billid, billtype);
		String ncFileList = sc.getFileList(billid, billtype);
		
		if(billDetailJson.contains("message")) {
			result.put("flag", "fail");
			result.put("msg", billDetailJson);
		}else {
			JSONObject senddatejson = JSONObject.parseObject(senddatejsonstr);
			if(!senddatejsonstr.contains("message") && "1".equals(senddatejson.get("status").toString())) {
				JSONObject jsonObj = JSONObject.parseObject(billDetailJson);
				jsonObj.put("senderdate", senddatejson.get("msg").toString());
				if(!billtypenamejson.contains("message")) {
					jsonObj.put("ebilltypename", JSONObject.parseObject(billtypenamejson).get("msg").toString());
				}
				if(!sendermanjson.contains("message")) {
					jsonObj.put("sendername", JSONObject.parseObject(sendermanjson).get("msg").toString());
				}
				
				JSONObject approvehisinfojson = JSONObject.parseObject(approvehisinfojsonstr);
				if(!approvehisinfojsonstr.contains("message") && "1".equals(approvehisinfojson.get("status").toString())) {
					if(approvehisinfojson.get("msg") != null) {
						JSONArray msgjsonarr = JSONArray.parseArray(approvehisinfojson.get("msg").toString());
						jsonObj.put("approhisinfo", msgjsonarr);
					}
				}
				
				JSONObject fileListJson = JSONObject.parseObject(ncFileList);
				if(!approvehisinfojsonstr.contains("message") && "1".equals(approvehisinfojson.get("status").toString())) {
					if(approvehisinfojson.get("msg") != null) {
						JSONArray msgjsonarr = JSONArray.parseArray(fileListJson.get("msg").toString());
						jsonObj.put("ncfilelist", msgjsonarr);
					}
				}
				result.put("data", jsonObj);
				result.put("flag", "success");
				result.put("msg", "查询成功");
			}else {
				result.put("flag", "fail");
				result.put("msg", "查询失败！");
			}
		}
		return result;
	}
	
	 private String getOaTaskUrl(){
    	Properties properties=PropertiesUtil.getProperties();
    	String ncWsUrl = properties.getProperty("OaTaskUrl");
    	return ncWsUrl;
    }
	 private String getncWsUrl(){
	    	Properties properties=PropertiesUtil.getProperties();
	    	String ncWsUrl = properties.getProperty("ncWsUrl");
	    	return ncWsUrl;
	    }
}
