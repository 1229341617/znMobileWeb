package com.yonyou.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.context.request.WebRequest;

public class TestOAWebservice {

	public static void main(String[] args) {
		//String uri="http://172.16.43.91:8080/znservice/erpoa/inserterpoa";
		String uri="http://proxy.zhongnangroup.cn/znservice/erpoa/inserterpoa";
	//	http://proxy.zhongnangroup.cn/znservice/erpoa/inserterpoa?name=%E7%9E%BF%E6%9D%B0&
	//		createname=%E7%9E%BF%E6%9D%B0&sendusername=%E7%9E%BF%E6%9D%B0&
	//		createdate=2018-08-14%2017:34:01&empid=8700bb3e-b1f1-4df6-9073-8a60997a7ba8&type=ncsp&
	//		username=1700259&url=123456&company=%E5%8D%97%E9%80%9A%E5%85%AC%E5%8F%B8&staffcode=170025
	//	String url = "http://jiekou.56dxw.com/sms/HttpInterface.aspx?comid=123&username=test&userpwd=*****";  
		
		
		String name="勒孚风 提交单据, 单据号: H5412018121400000121, 请审批单据";//待办任务名称
		
		//String name="勒孚风提交单据,单据号:H5412018121400000121,请审批单据";//待办任务名称
		name=name.replaceAll("\\s*", "");
		System.out.print(name);
		String createname="勒孚凤";//创建人
		String sendusername="瞿杰";//当然接收人
		String createdate="2019-01-18";//创建时间
		String empid="0001A110000000002TFO";//当前接收人bd_psndoc主键
		String type="ncsp";
		String username="1700259";//当前人工号
		//String billurl="http://172.16.43.74:8080/znMobileWeb/#proDetail/proDetail?billtype=H541-Cxx-01&billid=1001B410000000IMKXB0&checkman=0001A110000000002TFO&pk_flow=0001B2100000002Y1KWB&mobilebilltype=type01&workflowtype=2&billtypename=外部施工总承包合同";
		String billurl="http://172.16.43.74:8080/znMobileWeb/#proDetail/proDetail?billtype=H543&billid=1001B210000000IMWBWL&checkman=1001A110000000012UKU&pk_flow=1001B210000000IMWBWX&mobilebilltype=type01&workflowtype=2&billtypename=收入合同变更";
		String company="中南集团测试";//当前人所在公司
		String staffcode="1700259";//当前人工号
		String billid="1001B210000000IMWBWX";//当前任务id
		
		
	/*	String name="测试";//待办任务名称
		String createname="11";//创建人
		String sendusername="111";//当然接收人
		String createdate="2018-08-14";//创建时间
		String empid="1001A110000000012S75";//当然接收人id
		String type="ncsp";
		String username="1003537";//当前人工号
		String billurl="http://172.10.13.24:8067/TravelDetail?billtype=2641&billid=0001B2100000002QAUFI&checkman=1001A110000000012NAO&pk_flow=0001B2100000002Y1KWB&mobilebilltype=type01&workflowtype=4&billtypename=%E5%B7%AE%E6%97%85%E8%B4%B9%E6%8A%A5%E9%94%80%E5%8D%95";
		String company="111";//当前人所在公司
		String staffcode="1003537";//当前人工号
		String billid="0001B2100000002Y1KWB";//当前任务id
*/		try {
		//	byte[] utf = name.getBytes("ISO-8859-1");
			billurl = URLEncoder.encode(billurl,"utf-8");
            URL url = new URL(uri + "?name="+name+"&createname="+createname+"&sendusername="+sendusername+"&createdate="+createdate+"&empid="+empid+
            		"&type="+type+"&username="+username+"&url="+billurl+"&company="+company+"&staffcode="+staffcode+"&billid="+billid+"");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

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

}
