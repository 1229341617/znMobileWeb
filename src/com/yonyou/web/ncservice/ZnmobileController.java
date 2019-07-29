package com.yonyou.web.ncservice;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.appbase.util.AppCurrentUserUtil;
import com.yonyou.appbase.util.DateTimeUtil;
import com.yonyou.appbase.util.OaAndMobileProxy;
import com.yonyou.appbase.util.PropertiesUtil;
import com.yonyou.appbase.util.SSCProxy;
import com.yonyou.appbase.util.StrUtil;
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

@Controller
@RequestMapping(value = "/front/Znmobile")
public class ZnmobileController extends BaseController {
	@Autowired
	private CacheManager cache;
	@Autowired
	private ZnmobileService znmobileService;

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
	public @ResponseBody Object getUnApprovalDetails(String billid, String billtype){
		JSONObject result = new JSONObject();
		
		String approvehisinfojsonstr = new OaAndMobileProxy().getApproveHistoryInfo(billid, billtype);
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(approvehisinfojsonstr);
		String status = jsonObj.getString("status");
		if("1".equals(status)){
			result.put("flag", "success");
			result.put("msg", "查询成功!");
			
			result.put("data", JSONObject.parseArray(jsonObj.get("msg").toString()));
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
		SSCProxy sc = new SSCProxy();
		String result1=sc.getMyToDoList(usercode,searchname);
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
			if(!"264".equals(job.getString("pk_billtype").substring(0, 3)) && !"263".equals(job.getString("pk_billtype").substring(0, 3)) 
					&& !"261".equals(job.getString("pk_billtype").substring(0, 3)) ){
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
		SSCProxy sc = new SSCProxy();
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
	@RequestMapping(value = "/getBillDetail", method = RequestMethod.GET)
	public @ResponseBody Object getBillDetail(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();		
		String billtype=request.getParameter("billtype");
		String checkman=request.getParameter("checkman");
		String billid=request.getParameter("billid");
		String mobilebilltype=request.getParameter("mobilebilltype");
		SSCProxy sc = new SSCProxy();
		String result1=sc.getBillDetail(billtype,billid);
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(result1);
		if(mobilebilltype.equals("type01")){
			TravelMainVO travelMainVO = new TravelMainVO();
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			net.sf.json.JSONObject  jsonObj2 = net.sf.json.JSONObject.fromObject(jsonObj1.getString("h"));
			boolean hasjtfy=jsonObj1.has("jtfy");
			boolean haszsfy=jsonObj1.has("zsfy");
			boolean hasccbt=jsonObj1.has("ccbt");
			boolean hascxmx=jsonObj1.has("cxmx");
			travelMainVO.setDjbh(jsonObj2.getString("djbh"));
			travelMainVO.setDjrq(jsonObj2.getString("djrq"));
			travelMainVO.setJkbxr(jsonObj2.getString("jkbxr"));
			travelMainVO.setBbje(jsonObj2.getString("bbje"));
			travelMainVO.setPk_org(jsonObj2.getString("pk_org"));
			travelMainVO.setDeptid(jsonObj2.getString("deptid"));
			travelMainVO.setFydw(jsonObj2.getString("fydwbm"));
			travelMainVO.setFydwbm(jsonObj2.getString("fydwbm"));
			travelMainVO.setZyx5(jsonObj2.getString("zyx5"));
			TravelsubItem billsubItem=new TravelsubItem();
			List<TrafficItemVO> trafficItemList=new  ArrayList<TrafficItemVO>();// 交通
			TrafficItemVO trafficItemVO=null;
			List<HotelItemVO> hotelItemList=new  ArrayList<HotelItemVO>();// 住宿
			HotelItemVO hotelItem=null;
			List<AllowanceItemVO> allowanceItemVOList=new  ArrayList<AllowanceItemVO>();// 补贴
			AllowanceItemVO allowanceItemVO=null;
			List<WriteoffVO> writeoffList=new  ArrayList<WriteoffVO>();// 冲销
			WriteoffVO writeoffVO=null;
			if(hasjtfy){
				net.sf.json.JSONArray jsonObjjtfy = net.sf.json.JSONArray.fromObject(jsonObj1.getString("jtfy"));// 车船费
				if(jsonObjjtfy.size()>0){  
				    for(int i=0;i<jsonObjjtfy.size();i++){  
						  net.sf.json.JSONObject job = jsonObjjtfy.getJSONObject(i);  
						  trafficItemVO =new TrafficItemVO();
						  trafficItemVO.setTrafficitem(job.getString("item"));
						  trafficItemVO.setTrafficamount(job.getString("vat_amount"));
						  trafficItemVO.setStartdate(job.getString("defitem1"));
						  trafficItemVO.setStartplace(job.getString("defitem3"));
						  trafficItemVO.setArrivedate(job.getString("defitem2"));
						  trafficItemVO.setArriveplace(job.getString("defitem4"));
						  trafficItemList.add(trafficItemVO);
					}  
				}
			}
			if(haszsfy){
				net.sf.json.JSONArray  jsonObjzsfy = net.sf.json.JSONArray.fromObject(jsonObj1.getString("zsfy"));// 住宿费
				if(jsonObjzsfy.size()>0){  
					for(int i=0;i<jsonObjzsfy.size();i++){  
						  net.sf.json.JSONObject job = jsonObjzsfy.getJSONObject(i);  
						  hotelItem = new HotelItemVO();
						  hotelItem.setHotelitem(job.getString("item"));
						  hotelItem.setHotelamount(job.getString("vat_amount"));
						  hotelItem.setArrivedate(job.getString("defitem1"));
						  hotelItem.setArriveplace("");
						  hotelItem.setLeavedate(job.getString("defitem2"));
						  hotelItem.setNdays(job.getString("defitem9"));
						  hotelItemList.add(hotelItem);
					  }  
				} 
			}
			if(hasccbt){
				net.sf.json.JSONArray jsonObjccbt = net.sf.json.JSONArray.fromObject(jsonObj1.getString("ccbt"));// 出差补贴
				if(jsonObjccbt.size()>0){  
					for(int i=0;i<jsonObjccbt.size();i++){  
						net.sf.json.JSONObject job = jsonObjccbt.getJSONObject(i);  
						allowanceItemVO =new AllowanceItemVO();
					    allowanceItemVO.setAllowanceitem(job.getString("item"));
					    allowanceItemVO.setAllowanceamount(job.getString("vat_amount"));
					    allowanceItemVO.setAllowancedays(job.getString("defitem9"));
					    allowanceItemVO.setAllowancerule(job.getString("defitem11"));// 补贴标准
					    allowanceItemVOList.add(allowanceItemVO);
					  }  
				} 
			}
				
			if(hascxmx){
				net.sf.json.JSONArray jsonObjccbt = net.sf.json.JSONArray.fromObject(jsonObj1.getString("cxmx"));// 冲销明细
				if(jsonObjccbt.size()>0){  
					for(int i=0;i<jsonObjccbt.size();i++){  
						net.sf.json.JSONObject job = jsonObjccbt.getJSONObject(i);  
						writeoffVO =new WriteoffVO();
						writeoffVO.setJkdjbh(job.getString("jkdjbh"));
						writeoffVO.setPsnname(job.getString("psnname"));
						writeoffVO.setDeptname(job.getString("deptname"));
						writeoffVO.setCjkybje(job.getString("cjkybje"));
						writeoffVO.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
						writeoffVO.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
						writeoffVO.setSxbz(job.getString("sxbz"));
						writeoffList.add(writeoffVO);
					  }  
				} 
			}
				billsubItem.setTrafficItemList(trafficItemList);
				billsubItem.setHotelItemList(hotelItemList);
				billsubItem.setAllowanceItemVOList(allowanceItemVOList);
				billsubItem.setWriteoffList(writeoffList);
				billsubItem.setAttachmentList(this.getfileVOlist(billid));
				billsubItem.setImgURL(this.getimageVOlist(billid, billtype, checkman));
			travelMainVO.setBillsubItemVO(billsubItem);
			result.put("billdata",travelMainVO);
		}else if(mobilebilltype.equals("type02")){
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));//jsonObj1.get("Description")
			net.sf.json.JSONObject  jsonObj2 = net.sf.json.JSONObject.fromObject(jsonObj1.getString("h"));//jsonObj1.get("Description")
			boolean haszdf1=jsonObj1.has("zdf1");
			boolean haszdf2=jsonObj1.has("zdf2");
			boolean hascxmx=jsonObj1.has("cxmx");
			EntertainmentMainVO entertainmentMainVO=new EntertainmentMainVO();
			entertainmentMainVO.setDjbh(jsonObj2.getString("djbh"));
			entertainmentMainVO.setDjrq(jsonObj2.getString("djrq"));
			entertainmentMainVO.setTotal(jsonObj2.getString("total"));
			entertainmentMainVO.setJkbxr(jsonObj2.getString("jkbxr"));
			entertainmentMainVO.setMobile(jsonObj2.getString("mobile"));
			entertainmentMainVO.setBankcode(jsonObj2.getString("bankcode"));
			entertainmentMainVO.setDwbm(jsonObj2.getString("dwbm"));
			entertainmentMainVO.setDeptid(jsonObj2.getString("deptid"));
			entertainmentMainVO.setFydwbm(jsonObj2.getString("fydwbm"));
			entertainmentMainVO.setFydeptid(jsonObj2.getString("fydeptid"));
			entertainmentMainVO.setJsfs(jsonObj2.getString("jsfs"));
			entertainmentMainVO.setFkyhzh(jsonObj2.getString("fkyhzh"));
			entertainmentMainVO.setPk_payorg(jsonObj2.getString("pk_payorg"));
			entertainmentMainVO.setProject_name(jsonObj2.getString("project_name"));
			entertainmentMainVO.setPaytarget(jsonObj2.getString("paytarget"));
			entertainmentMainVO.setHbbm(jsonObj2.getString("hbbm"));
			entertainmentMainVO.setZyx29(jsonObj2.getString("zyx29"));
			entertainmentMainVO.setCustacccount(jsonObj2.getString("custacccount"));
			entertainmentMainVO.setZyx19(jsonObj2.getString("zyx19"));
			EntertainmentSub entertainmentSub=new EntertainmentSub();
			List<DetailoneVO> detailoneList=new  ArrayList<DetailoneVO>();// 招待费页签一
			DetailoneVO detailoneVO=null;
			List<DetailtwoVO> detailtwoList=new  ArrayList<DetailtwoVO>();// 招待费页签二
			DetailtwoVO detailtwoVO=null;
			List<EntertainmentWriteoffVO> entertainmentWriteoffVOList=new  ArrayList<EntertainmentWriteoffVO>();// 冲销
			EntertainmentWriteoffVO entertainmentWriteoffVO=null;
			List<AttachmentVO> attachmentList=new  ArrayList<AttachmentVO>();// 附件
			AttachmentVO attachmentVO=null;
			if(haszdf1){
				net.sf.json.JSONArray  jsonObjjtfy = net.sf.json.JSONArray.fromObject(jsonObj1.getString("zdf1"));// 页签一
				if(jsonObjjtfy.size()>0){  
				    for(int i=0;i<jsonObjjtfy.size();i++){  
						  net.sf.json.JSONObject job = jsonObjjtfy.getJSONObject(i);  
						  detailoneVO =new DetailoneVO();
						  detailoneVO.setSzxmid(job.getString("szxmid"));
						  detailoneVO.setDefitem1(job.getString("defitem1"));
						  detailoneVO.setVat_amount(job.getString("vat_amount"));
						  detailoneVO.setDefitem20(job.getString("defitem20"));
						  detailoneList.add(detailoneVO);
					}  
				}
			}
			if(haszdf2){
				net.sf.json.JSONArray  jsonObjzsfy = net.sf.json.JSONArray.fromObject(jsonObj1.getString("zdf2"));//页签二
				if(jsonObjzsfy.size()>0){  
					for(int i=0;i<jsonObjzsfy.size();i++){  
						  net.sf.json.JSONObject job = jsonObjzsfy.getJSONObject(i);  
						  detailtwoVO = new DetailtwoVO();
						  detailtwoVO.setDefitem10(job.getString("defitem10"));
						  detailtwoVO.setDefitem11(job.getString("defitem11"));
						  detailtwoVO.setDefitem12(job.getString("defitem12"));
						  detailtwoList.add(detailtwoVO);
					  }  
				} 
			}
			if(hascxmx){
				net.sf.json.JSONArray  jsonObjccbt = net.sf.json.JSONArray.fromObject(jsonObj1.getString("cxmx"));//冲销明细
				if(jsonObjccbt.size()>0){  
					for(int i=0;i<jsonObjccbt.size();i++){  
						net.sf.json.JSONObject job = jsonObjccbt.getJSONObject(i);  
						entertainmentWriteoffVO =new EntertainmentWriteoffVO();
						entertainmentWriteoffVO.setJkdjbh(job.getString("jkdjbh"));
						entertainmentWriteoffVO.setPsnname(job.getString("psnname"));
						entertainmentWriteoffVO.setDeptname(job.getString("deptname"));
						entertainmentWriteoffVO.setCjkybje(job.getString("cjkybje"));
						entertainmentWriteoffVO.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
						entertainmentWriteoffVO.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
						entertainmentWriteoffVO.setSxbz(job.getString("sxbz"));
						entertainmentWriteoffVOList.add(entertainmentWriteoffVO);
					  }  
				} 
			}
					/*  if("冲销费".equals(job.getString("item"))){
						  writeoffVO =new WriteoffVO();
						  writeoffVO.setLoanbillno(job.getString("item"));
						  writeoffVO.setWriteoffamount(job.getString("vat_amount"));
						  writeoffList.add(writeoffVO);
					  }
					  if("附件".equals(job.getString("item"))){
						  attachmentVO =new AttachmentVO();
						  attachmentVO.setAttachmentname(job.getString("item"));
						  attachmentList.add(attachmentVO);
					  }*/
				 
			entertainmentSub.setDetailoneList(detailoneList);
			entertainmentSub.setDetailtwoList(detailtwoList);
			entertainmentSub.setWriteoffList(entertainmentWriteoffVOList);
			entertainmentSub.setAttachmentList(this.getfileVOlist(billid));
			entertainmentSub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
			entertainmentMainVO.setEntertainmentSub(entertainmentSub);
			result.put("billdata",entertainmentMainVO);
		}else if(mobilebilltype.equals("type03")){
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			net.sf.json.JSONObject  jsonObj2 = net.sf.json.JSONObject.fromObject(jsonObj1.getString("h"));
			boolean hasqty=jsonObj1.has("qty");
			boolean hascxmx=jsonObj1.has("cxmx");
			CommonMainVO commonMainVO=new CommonMainVO();
			CommonSub commonSub=new CommonSub();
			commonMainVO.setDjbh(jsonObj2.getString("djbh"));
			commonMainVO.setDjrq(jsonObj2.getString("djrq"));
			commonMainVO.setTotal(jsonObj2.getString("total"));
			commonMainVO.setJkbxr(jsonObj2.getString("jkbxr"));
			commonMainVO.setMobile(jsonObj2.getString("mobile"));
			commonMainVO.setDwbm(jsonObj2.getString("dwbm"));
			commonMainVO.setDeptid(jsonObj2.getString("deptid"));
			commonMainVO.setFydwbm(jsonObj2.getString("fydwbm"));
			commonMainVO.setFydeptid(jsonObj2.getString("fydeptid"));
			commonMainVO.setJsfs(jsonObj2.getString("jsfs"));
			commonMainVO.setPk_cashaccount(jsonObj2.getString("pk_cashaccount"));
			commonMainVO.setFkyhzh(jsonObj2.getString("fkyhzh"));
			commonMainVO.setPk_payorg(jsonObj2.getString("pk_payorg"));
			commonMainVO.setProject_name(jsonObj2.getString("project_name"));
			commonMainVO.setPaytarget(jsonObj2.getString("paytarget"));
			commonMainVO.setHbbm(jsonObj2.getString("hbbm"));
			commonMainVO.setCustacccount(jsonObj2.getString("custacccount"));
			commonMainVO.setZyx19(jsonObj2.getString("zyx19"));
			List<OtherCostVO> otherCostVOList=new  ArrayList<OtherCostVO>();// 其他费用
			OtherCostVO otherCostVO=null;
			List<CommonWriteoffVO> commonWriteoffVOList=new  ArrayList<CommonWriteoffVO>();// 冲销
			CommonWriteoffVO commonWriteoffVO=null;
			List<AttachmentVO> attachmentList=new  ArrayList<AttachmentVO>();// 附件
			AttachmentVO attachmentVO=null;
			if(hasqty){
				net.sf.json.JSONArray  jsonObjjtfy = net.sf.json.JSONArray.fromObject(jsonObj1.getString("qty"));// 页签一
				if(jsonObjjtfy.size()>0){  
				    for(int i=0;i<jsonObjjtfy.size();i++){  
						  net.sf.json.JSONObject job = jsonObjjtfy.getJSONObject(i);  
						  otherCostVO =new OtherCostVO();
						  otherCostVO.setSzxmid(job.getString("szxmid"));
						  otherCostVO.setDefitem1(job.getString("defitem1"));
						  otherCostVO.setVat_amount(job.getString("vat_amount"));
						  otherCostVO.setDefitem20(job.getString("defitem20"));
						  otherCostVOList.add(otherCostVO);
					}  
				}
			}
			if(hascxmx){
				net.sf.json.JSONArray  jsonObjccbt = net.sf.json.JSONArray.fromObject(jsonObj1.getString("cxmx"));// 冲销明细
				if(jsonObjccbt.size()>0){  
					for(int i=0;i<jsonObjccbt.size();i++){  
						net.sf.json.JSONObject job = jsonObjccbt.getJSONObject(i);  
						commonWriteoffVO =new CommonWriteoffVO();
						commonWriteoffVO.setJkdjbh(job.getString("jkdjbh"));
						commonWriteoffVO.setPsnname(job.getString("psnname"));
						commonWriteoffVO.setDeptname(job.getString("deptname"));
						commonWriteoffVO.setCjkybje(job.getString("cjkybje"));
						commonWriteoffVO.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
						commonWriteoffVO.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
						commonWriteoffVO.setSxbz(job.getString("sxbz"));
						commonWriteoffVOList.add(commonWriteoffVO);
					  }  
				} 
			}
			commonSub.setOtherCostList(otherCostVOList);
			commonSub.setWriteoffList(commonWriteoffVOList);
			commonSub.setAttachmentList(this.getfileVOlist(billid));
			commonSub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
			commonMainVO.setCommonSub(commonSub);
			result.put("billdata",commonMainVO);
		}else if(mobilebilltype.equals("type04")){// 公司福利报销单
			BenefitMainVO benefitvo = new BenefitMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",benefitvo);
				return result;
			}
			net.sf.json.JSONObject jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",benefitvo);
				return result;
			}
			benefitvo = znmobileService.getBenefitData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", benefitvo);
		}else if(mobilebilltype.equals("type05")){// 发票入账单
			InvoiceInBillMainVO invoiceInBillvo = new InvoiceInBillMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",invoiceInBillvo);
				return result;
			}
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",invoiceInBillvo);
				return result;
			}
			 invoiceInBillvo = znmobileService.getInvoiceInBillData(jsonObj1,billid,billtype,checkman);
			 result.put("billdata", invoiceInBillvo);
		}else if(mobilebilltype.equals("type06")){// 招待费报销单-需申请
			ServeNeedApplyMainVO servevo = new ServeNeedApplyMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",servevo);
				return result;
			}
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",servevo);
				return result;
			}
			servevo = znmobileService.getServeNeedApplyData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", servevo);
		}else if(mobilebilltype.equals("type07")){// 费用报销单（个人）
			CostPsnMainVO costPsnvo = new CostPsnMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",costPsnvo);
				return result;
			}
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",costPsnvo);
				return result;
			}
			costPsnvo = znmobileService.getCostPsnData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", costPsnvo);
		}else if(mobilebilltype.equals("type08")){// 电脑补贴报销单
			ComputerMainVO  computervo = new ComputerMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",computervo);
				return result;
			}
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",computervo);
				return result;
			}
			computervo = znmobileService.getComputerData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", computervo);
		}else if(mobilebilltype.equals("type09")){// 成本类报销单
			CostClassMainVO costclassvo = new CostClassMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",costclassvo);
				return result;
			}
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",costclassvo);
				return result;
			}
			costclassvo = znmobileService.getCostClassData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", costclassvo);
		}else if(mobilebilltype.equals("type10")){// 销售宣传费用报销单
			SalesPropMainVO salespropvo = new SalesPropMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",salespropvo);
				return result;
			}
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",salespropvo);
				return result;
			}
			salespropvo = znmobileService.getSalesPropData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", salespropvo);
		}else if(mobilebilltype.equals("type11")){// 公车费用报销单
			PublicBusMainVO publicbusvo = new PublicBusMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",publicbusvo);
				return result;
			}
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",publicbusvo);
				return result;
			}
			publicbusvo = znmobileService.getPublicBusData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", publicbusvo);
		}else if(mobilebilltype.equals("type12")){// 还款单
			RepaymentMainVO repaymentvo = new RepaymentMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",repaymentvo);
				return result;
			}
			net.sf.json.JSONObject  jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",repaymentvo);
				return result;
			}
			repaymentvo = znmobileService.getRepaymentData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", repaymentvo);
		}else if(mobilebilltype.equals("type13")){// 借款单（个人）
			BorrowPsnMainVO brrowPsnvo = new BorrowPsnMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",brrowPsnvo);
				return result;
			}
			net.sf.json.JSONObject jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",brrowPsnvo);
				return result;
			}
			brrowPsnvo = znmobileService.getBorrPsnData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", brrowPsnvo);
		}else if(mobilebilltype.equals("type14")){// 借款单（对公）
			BorrowPubMainVO brrowPubvo = new BorrowPubMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",brrowPubvo);
				return result;
			}
			net.sf.json.JSONObject jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",brrowPubvo);
				return result;
			}
			brrowPubvo = znmobileService.getBorrPubData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", brrowPubvo);
		}else if(mobilebilltype.equals("type15")){// 招待费申请单
			ServePutMainVO servePutvo = new ServePutMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",servePutvo);
				return result;
			}
			net.sf.json.JSONObject jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",servePutvo);
				return result;
			}
			servePutvo = znmobileService.getservePutData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", servePutvo);
		}else if(mobilebilltype.equals("type16")){// 油卡充值申请单
			OilCardMainVO oilcardvo = new OilCardMainVO();
			boolean hasmsg=jsonObj.has("msg");
			if(!hasmsg){
				result.put("flag", "fail");
				result.put("msg", "msg,billid是： "+billid+";billtype是："+billtype+jsonObj.toString());
				result.put("data",oilcardvo);
				return result;
			}
			net.sf.json.JSONObject jsonObj1 = net.sf.json.JSONObject.fromObject(jsonObj.getString("msg"));
			boolean hash=jsonObj1.has("h");
			if(!hash){
				result.put("flag", "fail");
				result.put("msg", "h,billid是： "+billid+";billtype是："+billtype);
				result.put("data",oilcardvo);
				return result;
			}
			oilcardvo = znmobileService.getoilcardData(jsonObj1,billid,billtype,checkman);
			result.put("billdata", oilcardvo);
		}else{
			result.put("billdata", "");
		}
		result.put("flag", "success");
		result.put("msg", "查询成功");
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
					attachmentVO.setPk(job.getString("pk"));
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
