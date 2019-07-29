package com.yonyou.web.ncservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Decoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yonyou.appbase.util.AppCurrentUserUtil;
import com.yonyou.appbase.util.DateTimeUtil;
import com.yonyou.appbase.util.OaAndMobileProxy;
import com.yonyou.appbase.util.PropertiesUtil;
import com.yonyou.appbase.util.SSCProxy;
import com.yonyou.appbase.util.StrUtil;
import com.yonyou.appbase.util.ZnErpMobileProxy;
import com.yonyou.appbase.web.BaseController;
import com.yonyou.component.ncservice.service.ZnmobileService;
import com.yonyou.component.ncservice.vo.UnApprovalVO;
import com.yonyou.component.ncservice.vo.main.BenefitMainVO;
import com.yonyou.component.ncservice.vo.main.BorrowPsnMainVO;
import com.yonyou.component.ncservice.vo.main.BorrowPubMainVO;
import com.yonyou.component.ncservice.vo.main.CommonMainVO;
import com.yonyou.component.ncservice.vo.main.ComputerMainVO;
import com.yonyou.component.ncservice.vo.main.CostClassMainVO;
import com.yonyou.component.ncservice.vo.main.CostPsnMainVO;
import com.yonyou.component.ncservice.vo.main.EntertainmentMainVO;
import com.yonyou.component.ncservice.vo.main.InvoiceInBillMainVO;
import com.yonyou.component.ncservice.vo.main.OilCardMainVO;
import com.yonyou.component.ncservice.vo.main.PublicBusMainVO;
import com.yonyou.component.ncservice.vo.main.RepaymentMainVO;
import com.yonyou.component.ncservice.vo.main.SalesPropMainVO;
import com.yonyou.component.ncservice.vo.main.ServeNeedApplyMainVO;
import com.yonyou.component.ncservice.vo.main.ServePutMainVO;
import com.yonyou.component.ncservice.vo.main.TravelMainVO;
import com.yonyou.component.ncservice.vo.sub.AttachmentVO;
import com.yonyou.component.ncservice.vo.sub.ImageVO;
import com.yonyou.component.ncservice.vo.sub.common.CommonSub;
import com.yonyou.component.ncservice.vo.sub.common.CommonWriteoffVO;
import com.yonyou.component.ncservice.vo.sub.common.OtherCostVO;
import com.yonyou.component.ncservice.vo.sub.entertainment.DetailoneVO;
import com.yonyou.component.ncservice.vo.sub.entertainment.DetailtwoVO;
import com.yonyou.component.ncservice.vo.sub.entertainment.EntertainmentSub;
import com.yonyou.component.ncservice.vo.sub.entertainment.EntertainmentWriteoffVO;
import com.yonyou.component.ncservice.vo.sub.travel.AllowanceItemVO;
import com.yonyou.component.ncservice.vo.sub.travel.HotelItemVO;
import com.yonyou.component.ncservice.vo.sub.travel.TrafficItemVO;
import com.yonyou.component.ncservice.vo.sub.travel.TravelsubItem;
import com.yonyou.component.ncservice.vo.sub.travel.WriteoffVO;
import com.yonyou.iuap.cache.CacheManager;
import com.yonyou.util.FileUtils;
import com.yonyou.util.PathUtil;

@Controller
@RequestMapping(value = "/front/znerpmobile")
public class ZnErpmobileController extends BaseController {
	@Autowired
	private CacheManager cache;
	@Autowired
	private ZnmobileService znmobileService;
	
	private static final Logger logger = LoggerFactory.getLogger(ZnErpmobileController.class);

	/**
	 * 初始化判断是否可以登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getTokenInfo", method = RequestMethod.GET)
    public @ResponseBody Object getTokenInfo(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result =cache.get("app_result");
        return result;
    }
	@RequestMapping(value = "/getUnApprovalDetails", method = RequestMethod.GET)
	public @ResponseBody Object getUnApprovalDetails(String billno){
		JSONObject result = new JSONObject();
		
		SSCProxy sc = new SSCProxy();
		String message = sc.getUnApprovalDetails(billno);
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(message);
		String status = jsonObj.getString("status");
		if("1".equals(status)){
			result.put("flag", "success");
			result.put("msg", "查询成功!");
			result.put("data", net.sf.json.JSONObject.fromObject(jsonObj.get("msg")).get("data"));
		}else{
			result.put("flag", "fail");
			result.put("msg", "当前没有历史审批记录!");
		}
		
		return result;
	}
	@RequestMapping(value = "/getunapproval", method = RequestMethod.GET)
	public @ResponseBody Object getUnApproval(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		JSONObject result=new JSONObject();
		//获取用户id
		String userpk=AppCurrentUserUtil.getCurrentUserId(request);
		List<UnApprovalVO> listproject=new  ArrayList<UnApprovalVO>();
		UnApprovalVO unApprovalVO = null;
		String usercode=request.getParameter("code");
		String searchname=URLDecoder.decode(request.getParameter("searchname"),"utf-8");
		ZnErpMobileProxy sc = new ZnErpMobileProxy();
		String result1=sc.getMyErpToDoList(usercode,searchname);
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(result1);
		if("".equals(jsonObj.getString("msg"))){
			result.put("flag", "success");
			result.put("msg", "当前人没有审批单据");
			result.put("data",listproject);
			return result;
		}
		net.sf.json.JSONArray jsonObj1 = net.sf.json.JSONArray.fromObject(jsonObj.getString("msg"));//jsonObj1.get("Description")
		if(jsonObj1.size()>0){  
			for(int i=0;i<jsonObj1.size();i++){  
			net.sf.json.JSONObject job = jsonObj1.getJSONObject(i); 
			net.sf.json.JSONObject isOAMobileJson = net.sf.json.JSONObject.fromObject(sc.judgeIsOABill(job.getString("pk_billtype")));
			if(!"1".equals(isOAMobileJson.get("status").toString()) || !new Boolean(isOAMobileJson.get("msg").toString())){
				continue;
			}
			unApprovalVO=new UnApprovalVO();
			unApprovalVO.setPkBilltype(job.getString("pk_billtype"));
			unApprovalVO.setBilltypename(job.getString("billtypename"));
			if(job.has("mobilebilltype")){
				unApprovalVO.setMobilebilltype(job.getString("mobilebilltype"));
			}else{
				unApprovalVO.setMobilebilltype("type00");	
			}
			unApprovalVO.setBillid(job.getString("billid"));
			unApprovalVO.setBillno(job.getString("billno"));
			unApprovalVO.setSenderName(job.getString("sender_name"));
			if(!"".equals(job.getString("sender_name"))){
				unApprovalVO.setShortName(job.getString("sender_name").substring(1));	
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
		result.put("data",listproject);
		return result;
		
	}
	@RequestMapping(value = "/approval", method = RequestMethod.GET)
	public @ResponseBody Object approval(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result=new JSONObject();
		//获取用户id
		String userpk=AppCurrentUserUtil.getCurrentUserId(request);
		List<UnApprovalVO> listproject=new  ArrayList<UnApprovalVO>();
		UnApprovalVO unApprovalVO = null;
		String billtype=request.getParameter("billtype");
		String billid=request.getParameter("billid");
		String checkResult=request.getParameter("checkResult");
		String checkman=request.getParameter("checkman");
		String checkNote=request.getParameter("checkNote");
		
		String pk_flow=request.getParameter("pk_flow");
		String workflowtype=request.getParameter("workflowtype");
		ZnErpMobileProxy sc = new ZnErpMobileProxy();
		String result1=sc.approval(billtype,billid,checkResult,checkman,checkNote,pk_flow,workflowtype);
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(result1);
		net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));//jsonObj1.get("Description")
		String status=jsonObj1.getString("status");
		if("0".equals(status)){
			result.put("msg", jsonObj1.getString("msg"));
			result.put("flag", "fail");
		}else{
			if("Y".equals(checkResult)){
				result.put("msg", "审批成功");
			}else{
				result.put("msg", "驳回成功");
			}
			result.put("flag", "success");
			//net.sf.json.JSONArray jsonObj1 = net.sf.json.JSONArray.fromObject(jsonObj.getString("msg"));
		}
		return result;
		
	}
	
	@RequestMapping(value = "/downFile/{pk_file}", method = RequestMethod.GET)
	public @ResponseBody Object downFile(HttpServletResponse response, HttpServletRequest  request,@PathVariable String pk_file){
		JSONObject result = new JSONObject();	
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
				result.put("path", "/fileupload/oa/billfile/"+fileName);
				return result;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		result.put("path", "");
		return "";
	}
	
	@RequestMapping(value = "/getErpBillDetail", method = RequestMethod.GET)
	public @ResponseBody Object getErpBillDetail(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();		
		String billtype = request.getParameter("billtype");
		String checkman = request.getParameter("checkman");
		String billid = request.getParameter("billid");
		String pk_flow = request.getParameter("pk_flow");
		OaAndMobileProxy sc = new OaAndMobileProxy();
		String mobileJson = sc.getBillDetail(checkman, pk_flow, billtype, billid);
		JSONObject data = JSONObject.parseObject(mobileJson);
		
		if(mobileJson.contains("message")) {
			result.put("flag", "fail");
			result.put("msg", mobileJson);
		}else {
			String approvehisinfojsonstr = sc.getApproveHistoryInfo(billid, billtype);
			String ncFileList = sc.getFileList(billid, billtype);
			JSONObject approvehisinfojson = JSONObject.parseObject(approvehisinfojsonstr);
			if(!approvehisinfojsonstr.contains("message") && "1".equals(approvehisinfojson.get("status").toString())) {
				if(approvehisinfojson.get("msg") != null) {
					JSONArray msgjsonarr = JSONArray.parseArray(approvehisinfojson.get("msg").toString());
					data.put("approhisinfo", msgjsonarr);
				}
			}
			
			JSONObject fileListJson = JSONObject.parseObject(ncFileList);
			if(!approvehisinfojsonstr.contains("message") && "1".equals(approvehisinfojson.get("status").toString())) {
				if(approvehisinfojson.get("msg") != null) {
					JSONArray msgjsonarr = JSONArray.parseArray(fileListJson.get("msg").toString());
					data.put("ncfilelist", msgjsonarr);
				}
			}
			result.put("data", data);
			result.put("flag", "success");
			result.put("msg", "查询成功");
		}
		return result;
		
	}
	@RequestMapping(value = "/getfilelist", method = RequestMethod.GET)
	public @ResponseBody Object getfilelist(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result=new JSONObject();
		//获取用户id
		String userpk=AppCurrentUserUtil.getCurrentUserId(request);
		List<AttachmentVO> attachmentList=new  ArrayList<AttachmentVO>();
		AttachmentVO attachmentVO = null;
		String billid=request.getParameter("billid");
		SSCProxy sc = new SSCProxy();
		String result1=sc.getfilelist(billid);
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(result1);
		boolean hasmsg=jsonObj.has("msg");
		if(!hasmsg){
			result.put("flag", "fail");
			result.put("msg", "当前单据没有附件");
			result.put("data",attachmentList);
			return result;
		}
		net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
		boolean hasfile=jsonObj1.has("file");
		if(hasfile){
			net.sf.json.JSONArray  jsonObjfile = net.sf.json.JSONArray.fromObject(jsonObj1.getString("file"));// 附件
			if(jsonObjfile.size()>0){  
				for(int i=0;i<jsonObjfile.size();i++){  
					net.sf.json.JSONObject job = jsonObjfile.getJSONObject(i);  
					attachmentVO =new AttachmentVO();
					attachmentVO.setDisplayname(job.getString("displayname"));
					attachmentVO.setFilename(job.getString("filename"));
					attachmentVO.setFiletypo(job.getString("filetypo"));
					attachmentVO.setFilemgr(job.getString("filemgr"));
					attachmentVO.setPk_lfwfile(job.getString("pk_lfwfile"));
					attachmentList.add(attachmentVO);
				  }  
			}
		}
		result.put("flag", "success");
		result.put("msg", "查询成功");
		result.put("data",attachmentList);
		return result;
	}
	
	public List<AttachmentVO> getfileVOlist(String billid) {
		JSONObject result=new JSONObject();
		//获取用户id
		List<AttachmentVO> attachmentList=new  ArrayList<AttachmentVO>();
		AttachmentVO attachmentVO = null;
		SSCProxy sc = new SSCProxy();
		String result1=sc.getfilelist(billid);
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(result1);
		boolean hasmsg=jsonObj.has("msg");
		if(!hasmsg){
			return attachmentList;
		}
		net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
		boolean hasfile=jsonObj1.has("file");
		if(hasfile){
			net.sf.json.JSONArray  jsonObjfile = net.sf.json.JSONArray.fromObject(jsonObj1.getString("file"));// 附件
			if(jsonObjfile.size()>0){  
				for(int i=0;i<jsonObjfile.size();i++){  
					net.sf.json.JSONObject job = jsonObjfile.getJSONObject(i);  
					attachmentVO =new AttachmentVO();
					attachmentVO.setDisplayname(job.getString("displayname"));
					attachmentVO.setFilename(job.getString("filename"));
					attachmentVO.setFiletypo(job.getString("filetypo"));
					attachmentVO.setFilemgr(job.getString("filemgr"));
					attachmentVO.setPk_lfwfile(job.getString("pk_lfwfile"));
					attachmentList.add(attachmentVO);
				  }  
			}
		}
		return attachmentList;
	}
	public String getimageVOlist(String billid,String pk_billtype,String checkman) {
		String url="";
		SSCProxy sc = new SSCProxy();
		String result1=sc.getimagelist(billid,pk_billtype,checkman);
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(result1);
		net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
		String status=jsonObj1.getString("status");
		if("0".equals(status)){
			return url;
		}
		boolean hasfile=jsonObj1.has("url");
		if(hasfile){
			url = jsonObj1.getString("url");// 影像
			Properties properties=PropertiesUtil.getProperties();
			if(!"".equals(url)){
				url=url.substring(url.indexOf("8081")+4);
				String imagebaseurl="";
				if (StrUtil.isEmpty(imagebaseurl)) {
					imagebaseurl = properties.getProperty("imageurl");
				}
				url=imagebaseurl+url;
			}
		}
		return url;
	}
	@RequestMapping(value = "/getimagelist", method = RequestMethod.GET)
	public @ResponseBody Object getimagelist(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result=new JSONObject();
		//获取用户id
		String userpk=AppCurrentUserUtil.getCurrentUserId(request);
		List<ImageVO> imageList=new  ArrayList<ImageVO>();
		ImageVO imageVO = null;
		String url="";
		String billid=request.getParameter("billid");
		String pk_billtype=request.getParameter("pk_billtype");
		String checkman=request.getParameter("checkman");
		SSCProxy sc = new SSCProxy();
		String result1=sc.getimagelist(billid,pk_billtype,checkman);
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(result1);
		net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
		String status=jsonObj1.getString("status");
		if("0".equals(status)){
			result.put("flag", "fail");
			result.put("msg", "当前单据没有影像");
			result.put("data",url);
			return result;
		}
		boolean hasfile=jsonObj1.has("url");
		if(hasfile){
			url = jsonObj1.getString("url");// 影像
			Properties properties=PropertiesUtil.getProperties();
			if(!"".equals(url)){
				url=url.substring(url.indexOf("8081")+4);
				String imagebaseurl="";
				if (StrUtil.isEmpty(imagebaseurl)) {
					imagebaseurl = properties.getProperty("imageurl");
				}
				url=imagebaseurl+url;
			}
		}
		result.put("flag", "success");
		result.put("msg", "查询成功");
		result.put("data",url);
		return result;
	}
}
