package com.yonyou.test;

import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class TestMdm {

	public TestMdm() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		  String result = "{\"message\":\"call failed!\"}";
		  Service service = new Service();
		  String jsondata="[{\"ts\":\"2018-03-20 13:53:50\",\"orgtype10\":\"Y\",\"orgtype11\":\"N\",\"tel\":\"\",\"orgtype12\":\"N\",\"vname\":\"初始版本\",\"description\":\"\",\"isorg\":\"\",\"pk_fathercorporg\":\"\",\"orgtype35\":\"N\",\"orgtype36\":\"Y\",\"pk_fatheradminorg\":\"\",\"def5\":\"\",\"def6\":\"1001A11000000001HMZS\",\"def9\":\"1001B2100000001UDJ0Q\",\"code\":\"1004005\",\"vno\":\"201701\",\"orgtype8\":\"Y\",\"orgtype9\":\"Y\",\"orgtype6\":\"N\",\"orgtype7\":\"Y\",\"orgtype4\":\"N\",\"orgtype5\":\"Y\",\"enablestate\":\"2\",\"pk_group\":\"0001A110000000000AUG\",\"orgtype2\":\"Y\",\"orgtype3\":\"N\",\"def4\":\"\",\"def3\":\"\",\"orgtype1\":\"N\",\"def2\":\"\",\"def1\":\"0001A110000000002D8J\",\"orgtype31\":\"N\",\"def12\":\"\",\"orgtype32\":\"N\",\"def13\":\"\",\"orgtype33\":\"N\",\"def10\":\"\",\"orgtype34\":\"N\",\"def11\":\"\",\"organizationcode\":\"\",\"isbusinessunit\":\"Y\",\"glbdef2\":\"\",\"glbdef3\":\"\",\"def14\":\"\",\"def15\":\"\",\"id\":\"0001A110000000002D8J\",\"pk_vid\":\"0001A110000000002D8I\",\"pk_org\":\"\",\"name\":\"南通灵源电力设备有限公司\",\"pk_fatherorg\":\"\",\"orgtype29\":\"N\",\"shortname\":\"\",\"dr\":\"0\",\"creationtime\":\"2017-10-10 21:49:24\",\"vstartdate\":\"2017-10-10 21:49:24\",\"pk_ownorg\":\"\",\"pk_fatherhrorg\":\"\",\"islastversion\":\"Y\",\"orgtype16\":\"N\",\"orgtype15\":\"N\",\"orgtype14\":\"N\",\"orgtype13\":\"Y\"}]";
	        Call call;
			try {
				call = (Call) service.createCall();
				call.setTargetEndpointAddress("http://172.10.13.25:8800/uapws/service/com.yonyou.itf.mdm07.sharing.IMdSharingCenterService");
				// 调用的方法名
				call.setOperationName("insertMd");
				// 设置参数名 参数名 参数类型:String 参数模式：'IN' or 'OUT'
				call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
				call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
				call.addParameter("string2", XMLType.XSD_STRING, ParameterMode.IN);
				// 设置返回值类型
				call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
				result = (String) call.invoke(new Object[] { "mdmsystem_nc","znmdm_orgs",jsondata });// 远程调用
			} catch (Exception e) {
				result = "{\"message\":\"调用审批流接口异常！\",\"success_flag\":\"否\"}";
				e.printStackTrace();
			}

	}

}
