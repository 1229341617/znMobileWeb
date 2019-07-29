package com.yonyou.component.ncservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.yonyou.appbase.util.DateTimeUtil;
import com.yonyou.appbase.util.PropertiesUtil;
import com.yonyou.appbase.util.SSCProxy;
import com.yonyou.appbase.util.StrUtil;
import com.yonyou.component.ncservice.service.ZnmobileService;
import com.yonyou.component.ncservice.vo.main.BenefitMainVO;
import com.yonyou.component.ncservice.vo.main.BorrowPsnMainVO;
import com.yonyou.component.ncservice.vo.main.BorrowPubMainVO;
import com.yonyou.component.ncservice.vo.main.ComputerMainVO;
import com.yonyou.component.ncservice.vo.main.CostClassMainVO;
import com.yonyou.component.ncservice.vo.main.CostPsnMainVO;
import com.yonyou.component.ncservice.vo.main.InvoiceInBillMainVO;
import com.yonyou.component.ncservice.vo.main.OilCardMainVO;
import com.yonyou.component.ncservice.vo.main.PublicBusMainVO;
import com.yonyou.component.ncservice.vo.main.RepaymentMainVO;
import com.yonyou.component.ncservice.vo.main.SalesPropMainVO;
import com.yonyou.component.ncservice.vo.main.ServeNeedApplyMainVO;
import com.yonyou.component.ncservice.vo.main.ServePutMainVO;
import com.yonyou.component.ncservice.vo.sub.AttachmentVO;
import com.yonyou.component.ncservice.vo.sub.benefit.BenefitItemVO;
import com.yonyou.component.ncservice.vo.sub.benefit.BenefitWriteoffVO;
import com.yonyou.component.ncservice.vo.sub.benefit.BenefitsubItem;
import com.yonyou.component.ncservice.vo.sub.borrowpsn.BorrowPsnItem;
import com.yonyou.component.ncservice.vo.sub.borrowpsn.BorrowPsnSubItem;
import com.yonyou.component.ncservice.vo.sub.borrowpub.BorrowPubItem;
import com.yonyou.component.ncservice.vo.sub.borrowpub.BorrowPubSubItem;
import com.yonyou.component.ncservice.vo.sub.computer.ComputerItemVO;
import com.yonyou.component.ncservice.vo.sub.computer.ComputerSubItem;
import com.yonyou.component.ncservice.vo.sub.computer.ComputerWriteoffVO;
import com.yonyou.component.ncservice.vo.sub.costclass.CostClassItem;
import com.yonyou.component.ncservice.vo.sub.costclass.CostClassSubItem;
import com.yonyou.component.ncservice.vo.sub.costclass.CostClassWriteoffVO;
import com.yonyou.component.ncservice.vo.sub.costpsn.CostPsnItemVO;
import com.yonyou.component.ncservice.vo.sub.costpsn.CostPsnSubItem;
import com.yonyou.component.ncservice.vo.sub.costpsn.CostPsnWriteoffVO;
import com.yonyou.component.ncservice.vo.sub.invoiceinbill.InvoiceItemVO;
import com.yonyou.component.ncservice.vo.sub.oilcard.OilCardItemVO;
import com.yonyou.component.ncservice.vo.sub.oilcard.OilCardSubItem;
import com.yonyou.component.ncservice.vo.sub.publicbus.PublicBusItem;
import com.yonyou.component.ncservice.vo.sub.publicbus.PublicBusSubItem;
import com.yonyou.component.ncservice.vo.sub.publicbus.PublicBusWriteoffVO;
import com.yonyou.component.ncservice.vo.sub.publicbus.PublicHotelItem;
import com.yonyou.component.ncservice.vo.sub.publicbus.PublicTravelItem;
import com.yonyou.component.ncservice.vo.sub.repayment.RepaymentItem;
import com.yonyou.component.ncservice.vo.sub.repayment.RepaymentSubItem;
import com.yonyou.component.ncservice.vo.sub.salesprop.SalesPropItem;
import com.yonyou.component.ncservice.vo.sub.salesprop.SalesPropSubItem;
import com.yonyou.component.ncservice.vo.sub.salesprop.SalesPropWriteoffVO;
import com.yonyou.component.ncservice.vo.sub.serve.ServeNeedApplyItem;
import com.yonyou.component.ncservice.vo.sub.serve.ServeNeedApplySubItem;
import com.yonyou.component.ncservice.vo.sub.serve.ServeWriteoffVO;
import com.yonyou.component.ncservice.vo.sub.serveput.ServePutItemVO;
import com.yonyou.component.ncservice.vo.sub.serveput.ServePutSubItem;

@Service
public class ZnmobileServiceImpl implements ZnmobileService{

	//发票入账单
	@Override
	public InvoiceInBillMainVO getInvoiceInBillData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		InvoiceInBillMainVO invoiceInBillvo = new InvoiceInBillMainVO();
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		invoiceInBillvo.setBankcode(jsonObj1.getString("bankcode"));
		invoiceInBillvo.setCustacccount(jsonObj1.getString("custacccount"));
		invoiceInBillvo.setDeptid(jsonObj1.getString("deptid"));
		invoiceInBillvo.setDjbh(jsonObj1.getString("djbh"));
		invoiceInBillvo.setDjrq(jsonObj1.getString("djrq"));
		invoiceInBillvo.setDwbm(jsonObj1.getString("dwbm"));
		invoiceInBillvo.setFkyhzh(jsonObj1.getString("fkyhzh"));
		invoiceInBillvo.setFydeptid(jsonObj1.getString("fydeptid"));
		invoiceInBillvo.setFydwbm(jsonObj1.getString("fydwbm"));
		invoiceInBillvo.setZyx19(jsonObj1.getString("zyx19"));
		invoiceInBillvo.setVat_amount(jsonObj1.getString("vat_amount"));
		invoiceInBillvo.setTotal(jsonObj1.getString("total"));
		invoiceInBillvo.setProject_name(jsonObj1.getString("project_name"));
		invoiceInBillvo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		invoiceInBillvo.setPaytarget(jsonObj1.getString("paytarget"));
		invoiceInBillvo.setMobile(jsonObj1.getString("mobile"));
		invoiceInBillvo.setJsfs(jsonObj1.getString("jsfs"));
		invoiceInBillvo.setJobid(jsonObj1.getString("jobid"));
		invoiceInBillvo.setJkbxr(jsonObj1.getString("jkbxr"));
		invoiceInBillvo.setHbbm(jsonObj1.getString("hbbm"));
		List<InvoiceItemVO> invoiceItemList = new ArrayList<InvoiceItemVO>();// 发票信息list
		boolean hasqty = jsonObj.has("qty");
		if(hasqty){
			JSONArray jsonObjqty = JSONArray.fromObject(jsonObj.getString("qty"));// 发票信息
			if(jsonObjqty.size()>0){
			    for(int i=0;i<jsonObjqty.size();i++){  
					  JSONObject job = jsonObjqty.getJSONObject(i);  
					  InvoiceItemVO purchaseItemvo =new InvoiceItemVO();
					  purchaseItemvo.setDefitem6(job.getString("defitem6"));
					  purchaseItemvo.setFphm(job.getString("fphm"));
					  purchaseItemvo.setSzxmid(job.getString("szxmid"));
					  purchaseItemvo.setTax_amount(job.getString("tax_amount"));
					  purchaseItemvo.setTax_rate(job.getString("tax_rate"));
					  purchaseItemvo.setTni_amount(job.getString("tni_amount"));
					  purchaseItemvo.setVat_amount(job.getString("vat_amount"));
					  invoiceItemList.add(purchaseItemvo);
				}  
			}
		}
		invoiceInBillvo.setInvoiceItemList(invoiceItemList);
		invoiceInBillvo.setAttachmentList(this.getfileVOlist(billid));
		invoiceInBillvo.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		return invoiceInBillvo;
	}

	//公司福利报销单
	@Override
	public BenefitMainVO getBenefitData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		BenefitMainVO benefitvo = new BenefitMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		benefitvo.setDjrq(jsonObj1.getString("djrq"));
		benefitvo.setDwbm(jsonObj1.getString("dwbm"));
		benefitvo.setTotal(jsonObj1.getString("total"));
		benefitvo.setProject_name(jsonObj1.getString("project_name"));
		benefitvo.setJkbxr(jsonObj1.getString("jkbxr"));
		benefitvo.setFydeptid(jsonObj1.getString("fydeptid"));
		benefitvo.setPaytarget(jsonObj1.getString("paytarget"));
		benefitvo.setFydwbm(jsonObj1.getString("fydwbm"));
		benefitvo.setZyx19(jsonObj1.getString("zyx19"));
		benefitvo.setZyx29(jsonObj1.getString("zyx29"));
		benefitvo.setJobid(jsonObj1.getString("jobid"));
		benefitvo.setDeptid(jsonObj1.getString("deptid"));
		benefitvo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		benefitvo.setHbbm(jsonObj1.getString("hbbm"));
		benefitvo.setJsfs(jsonObj1.getString("jsfs"));
		benefitvo.setBankcode(jsonObj1.getString("bankcode"));
		benefitvo.setFkyhzh(jsonObj1.getString("fkyhzh"));			
		benefitvo.setCustacccount(jsonObj1.getString("custacccount"));
		benefitvo.setDjbh(jsonObj1.getString("djbh"));			
		benefitvo.setMobile(jsonObj1.getString("mobile"));			
		boolean hasqty = jsonObj.has("qty");// 发票信息
		boolean hascxmx=jsonObj.has("cxmx");// 冲销明细
		BenefitsubItem benefitsub = new BenefitsubItem();						
		List<BenefitItemVO> itemVOList =new  ArrayList<BenefitItemVO>();//福利费明细
		BenefitItemVO itemvo = null;
		List<BenefitWriteoffVO> writeoffvoList = new  ArrayList<BenefitWriteoffVO>();//冲销明细
		BenefitWriteoffVO writeoffvo = null;
		// 填充福利费明细
		if(hasqty){
			JSONArray jsonObjqty = JSONArray.fromObject(jsonObj.getString("qty"));
			if(jsonObjqty.size()>0){
				for(int i=0;i<jsonObjqty.size();i++){  
					JSONObject job = jsonObjqty.getJSONObject(i);  
					itemvo =new BenefitItemVO();
					itemvo.setDefitem6(job.getString("defitem6"));
					itemvo.setFphm(job.getString("fphm"));
					itemvo.setSzxmid(job.getString("szxmid"));
					itemvo.setTax_amount(job.getString("tax_amount"));
					itemvo.setTax_rate(job.getString("tax_rate"));
					itemvo.setDefitem20(job.getString("defitem20"));
					itemvo.setVat_amount(job.getString("vat_amount"));
					itemVOList.add(itemvo);
				}  
			}
		}
		// 填充冲销明细
		if(hascxmx){
			JSONArray jsonObjcxmx = JSONArray.fromObject(jsonObj.getString("cxmx"));
			if(jsonObjcxmx.size()>0){
				for(int i=0;i<jsonObjcxmx.size();i++){
					JSONObject job = jsonObjcxmx.getJSONObject(i);
					writeoffvo = new BenefitWriteoffVO();
					writeoffvo.setCjkybje(job.getString("cjkybje"));
					writeoffvo.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
					writeoffvo.setDeptid(job.getString("deptid"));
					writeoffvo.setJkbxr(job.getString("jkbxr"));
					writeoffvo.setJkdjbh(job.getString("jkdjbh"));
					writeoffvo.setSxbz(job.getString("sxbz"));
					writeoffvo.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
					writeoffvo.setSzxmid(job.getString("szxmid"));
					writeoffvoList.add(writeoffvo);
				}
			}
		}
		benefitsub.setItemVOList(itemVOList);
		benefitsub.setWriteoffvoList(writeoffvoList);	
		benefitsub.setAttachmentList(this.getfileVOlist(billid));
		benefitsub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		benefitvo.setBenefitsub(benefitsub);
		return benefitvo;
	}

	// 费用报销单（个人）
	@Override
	public CostPsnMainVO getCostPsnData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		CostPsnMainVO costPsnvo = new CostPsnMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		costPsnvo.setDjrq(jsonObj1.getString("djrq"));
		costPsnvo.setProject_name(jsonObj1.getString("project_name"));
		costPsnvo.setBankcode(jsonObj1.getString("bankcode"));
		costPsnvo.setDeptid(jsonObj1.getString("deptid"));
		costPsnvo.setDjbh(jsonObj1.getString("djbh"));
		costPsnvo.setDwbm(jsonObj1.getString("dwbm"));
		costPsnvo.setFkyhzh(jsonObj1.getString("fkyhzh"));
		costPsnvo.setFydeptid(jsonObj1.getString("fydeptid"));
		costPsnvo.setFydwbm(jsonObj1.getString("fydwbm"));
		costPsnvo.setJkbxr(jsonObj1.getString("jkbxr"));
		costPsnvo.setJsfs(jsonObj1.getString("jsfs"));
		costPsnvo.setMobile(jsonObj1.getString("mobile"));
		costPsnvo.setPaytarget(jsonObj1.getString("paytarget"));
		costPsnvo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		costPsnvo.setTotal(jsonObj1.getString("total"));
		costPsnvo.setZyx19(jsonObj1.getString("zyx19"));
		costPsnvo.setZyx29(jsonObj1.getString("zyx29"));	
		boolean haszdf1 = jsonObj.has("zdf1");// 费用明细
		boolean hascxmx=jsonObj.has("cxmx");// 冲销明细
		CostPsnSubItem costpsnsub = new CostPsnSubItem();						
		List<CostPsnItemVO> itemVOList =new  ArrayList<CostPsnItemVO>();// 费用明细
		CostPsnItemVO itemvo = null;
		List<CostPsnWriteoffVO> writeoffvoList = new  ArrayList<CostPsnWriteoffVO>();// 冲销明细
		CostPsnWriteoffVO writeoffvo = null;
		// 填充福利费明细
		if(haszdf1){
			JSONArray jsonObjzdf1 = JSONArray.fromObject(jsonObj.getString("zdf1"));
			if(jsonObjzdf1.size()>0){
				for(int i=0;i<jsonObjzdf1.size();i++){  
					JSONObject job = jsonObjzdf1.getJSONObject(i);  
					itemvo = new CostPsnItemVO();
					itemvo.setDefitem6(job.getString("defitem6"));
					itemvo.setDefitem16(job.getString("defitem16"));
					itemvo.setDefitem17(job.getString("defitem17"));
					itemvo.setDefitem18(job.getString("defitem18"));
					itemvo.setTax_amount(job.getString("tax_amount"));
					itemvo.setTax_rate(job.getString("tax_rate"));
					itemvo.setJobid(job.getString("jobid"));
					itemvo.setVat_amount(job.getString("vat_amount"));
					itemvo.setSzxmid(job.getString("szxmid"));							
					itemvo.setTni_amount(job.getString("tni_amount"));							
					itemVOList.add(itemvo);
				}  
			}
		}
		// 填充冲销明细
		if(hascxmx){
			JSONArray jsonObjcxmx = JSONArray.fromObject(jsonObj.getString("cxmx"));
			if(jsonObjcxmx.size()>0){
				for(int i=0;i<jsonObjcxmx.size();i++){
					writeoffvo = new CostPsnWriteoffVO();
					JSONObject job = jsonObjcxmx.getJSONObject(i);
					writeoffvo.setJkdjbh(job.getString("jkdjbh"));
					writeoffvo.setPsnname(job.getString("psnname"));
					writeoffvo.setDeptname(job.getString("deptname"));
					writeoffvo.setBbje(job.getString("bbje"));
					writeoffvo.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
					writeoffvo.setSxbz(job.getString("sxbz"));
					writeoffvo.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
					writeoffvoList.add(writeoffvo);
				}
			}
		}		
		costpsnsub.setItemVOList(itemVOList);
		costpsnsub.setWriteoffvoList(writeoffvoList);		
		costpsnsub.setAttachmentList(this.getfileVOlist(billid));
		costpsnsub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		costPsnvo.setCostpsnsub(costpsnsub);
		return costPsnvo;
	}
	
	// 电脑补贴报销单
	@Override
	public ComputerMainVO getComputerData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		ComputerMainVO computervo = new ComputerMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		computervo.setBankcode(jsonObj1.getString("bankcode"));
		computervo.setDeptid(jsonObj1.getString("deptid"));
		computervo.setDjbh(jsonObj1.getString("djbh"));
		computervo.setDjrq(jsonObj1.getString("djrq"));
		computervo.setDwbm(jsonObj1.getString("dwbm"));
		computervo.setFkyhzh(jsonObj1.getString("fkyhzh"));
		computervo.setFydeptid(jsonObj1.getString("fydeptid"));
		computervo.setFydwbm(jsonObj1.getString("fydwbm"));
		computervo.setJkbxr(jsonObj1.getString("jkbxr"));
		computervo.setJsfs(jsonObj1.getString("jsfs"));
		computervo.setMobile(jsonObj1.getString("mobile"));
		computervo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		computervo.setProject_name(jsonObj1.getString("project_name"));
		computervo.setTotal(jsonObj1.getString("total"));
		computervo.setZyx19(jsonObj1.getString("zyx19"));
		computervo.setZyx29(jsonObj1.getString("zyx29"));
		boolean haszdf1 = jsonObj.has("zdf1");// 电脑信息
		boolean hascxmx=jsonObj.has("cxmx");// 冲销明细
		ComputerSubItem computersub = new ComputerSubItem();						
		List<ComputerItemVO> itemVOList =new  ArrayList<ComputerItemVO>();// 电脑信息
		ComputerItemVO itemvo = null;
		List<ComputerWriteoffVO> writeoffvoList = new  ArrayList<ComputerWriteoffVO>();// 冲销明细
		ComputerWriteoffVO writeoffvo = null;
		// 填充福利费明细
		if(haszdf1){
			JSONArray jsonObjzdf1 = JSONArray.fromObject(jsonObj.getString("zdf1"));
			if(jsonObjzdf1.size()>0){
				for(int i=0;i<jsonObjzdf1.size();i++){  
					JSONObject job = jsonObjzdf1.getJSONObject(i);  
					itemvo =new ComputerItemVO();
					itemvo.setDefitem6(job.getString("defitem6"));
					itemvo.setDefitem8(job.getString("defitem8"));
					itemvo.setJobid(job.getString("jobid"));
					itemvo.setSzxmid(job.getString("szxmid"));
					itemvo.setFphm(job.getString("fphm"));
					itemvo.setTax_amount(job.getString("tax_amount"));
					itemvo.setTax_rate(job.getString("tax_rate"));
					itemvo.setVat_amount(job.getString("vat_amount"));
					itemVOList.add(itemvo);
				}  
			}
		}
		// 填充冲销明细
		if(hascxmx){
			JSONArray jsonObjcxmx = JSONArray.fromObject(jsonObj.getString("cxmx"));
			if(jsonObjcxmx.size()>0){
				for(int i=0;i<jsonObjcxmx.size();i++){
					JSONObject job = jsonObjcxmx.getJSONObject(i);
					writeoffvo = new ComputerWriteoffVO();
					writeoffvo.setDeptname(job.getString("deptname"));
					writeoffvo.setFyybje(job.getString("fyybje"));
					writeoffvo.setJkdjbh(job.getString("jkdjbh"));
					writeoffvo.setPsnname(job.getString("psnname"));
					writeoffvoList.add(writeoffvo);
				}
			}
		}
		computersub.setItemVOList(itemVOList);
		computersub.setWriteoffvoList(writeoffvoList);		
		computersub.setAttachmentList(this.getfileVOlist(billid));
		computersub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		computervo.setComputersub(computersub);				
		return computervo;
	}

	// 招待费报销单-需申请
	@Override
	public ServeNeedApplyMainVO getServeNeedApplyData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		ServeNeedApplyMainVO servevo = new ServeNeedApplyMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		servevo.setBankcode(jsonObj1.getString("bankcode"));
		servevo.setCustacccount(jsonObj1.getString("custacccount"));
		servevo.setDjbh(jsonObj1.getString("djbh"));
		servevo.setDjrq(jsonObj1.getString("djrq"));
		servevo.setDwbm(jsonObj1.getString("dwbm"));
		servevo.setFkyhzh(jsonObj1.getString("fkyhzh"));
		servevo.setFydeptid(jsonObj1.getString("fydeptid"));
		servevo.setFydwbm(jsonObj1.getString("fydwbm"));
		servevo.setHbbm(jsonObj1.getString("hbbm"));
		servevo.setJkbxr(jsonObj1.getString("jkbxr"));
		servevo.setJsfs(jsonObj1.getString("jsfs"));
		servevo.setMobile(jsonObj1.getString("mobile"));
		servevo.setPaytarget(jsonObj1.getString("paytarget"));
		servevo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		servevo.setProject_name(jsonObj1.getString("project_name"));
		servevo.setTotal(jsonObj1.getString("total"));
		servevo.setZyx19(jsonObj1.getString("zyx19"));
		servevo.setZyx29(jsonObj1.getString("zyx29"));
		boolean haszdf1 = jsonObj.has("zdf1");// 招待费明细（页签一）
		boolean hascxmx=jsonObj.has("cxmx");// 冲销明细
		ServeNeedApplySubItem servesub = new ServeNeedApplySubItem();						
		List<ServeNeedApplyItem> itemVOList =new  ArrayList<ServeNeedApplyItem>();// 招待费明细（页签一）
		ServeNeedApplyItem itemvo = null;
		List<ServeWriteoffVO> writeoffvoList = new  ArrayList<ServeWriteoffVO>();// 冲销明细
		ServeWriteoffVO writeoffvo = null;
		// 填充福利费明细
		if(haszdf1){
			JSONArray jsonObjzdf1 = JSONArray.fromObject(jsonObj.getString("zdf1"));
			if(jsonObjzdf1.size()>0){
				for(int i=0;i<jsonObjzdf1.size();i++){  
					JSONObject job = jsonObjzdf1.getJSONObject(i); 
					itemvo =new ServeNeedApplyItem();
					itemvo.setSzxmid(job.getString("szxmid"));
					itemvo.setVat_amount(job.getString("vat_amount"));
					itemvo.setDefitem1(job.getString("defitem1"));
					itemvo.setDefitem6(job.getString("defitem6"));
					itemvo.setDefitem7(job.getString("defitem7"));
					itemvo.setDefitem8(job.getString("defitem8"));
					itemvo.setDefitem11(job.getString("defitem11"));
					itemvo.setDefitem20(job.getString("defitem20"));
					itemvo.setDefitem21(job.getString("defitem21"));
					itemvo.setProject_name(job.getString("project_name"));
					itemVOList.add(itemvo);
				}  
			}
		}
		// 填充冲销明细
		if(hascxmx){
			JSONArray jsonObjcxmx = JSONArray.fromObject(jsonObj.getString("cxmx"));
			if(jsonObjcxmx.size()>0){
				for(int i=0;i<jsonObjcxmx.size();i++){
					JSONObject job = jsonObjcxmx.getJSONObject(i);
					writeoffvo = new ServeWriteoffVO();
					writeoffvo.setJkdjbh(job.getString("jkdjbh"));
					writeoffvo.setPsnname(job.getString("psnname"));
					writeoffvo.setDeptname(job.getString("deptname"));
					writeoffvo.setCjkybje(job.getString("cjkybje"));
					writeoffvo.setSzxmid(job.getString("szxmid"));
					writeoffvo.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
					writeoffvo.setSxbz(job.getString("sxbz"));
					writeoffvo.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
					writeoffvoList.add(writeoffvo);
				}
			}
		}
		servesub.setItemVOList(itemVOList);
		servesub.setWriteoffvoList(writeoffvoList);
		servesub.setAttachmentList(this.getfileVOlist(billid));
		servesub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		servevo.setServesub(servesub);		
		return servevo;
	}

	// 成本类报销单
	@Override
	public CostClassMainVO getCostClassData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		CostClassMainVO costclassvo = new CostClassMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		costclassvo.setCustaccount(jsonObj1.getString("custaccount"));
		costclassvo.setDeptid(jsonObj1.getString("deptid"));
		costclassvo.setDjbh(jsonObj1.getString("djbh"));
		costclassvo.setDjrq(jsonObj1.getString("djrq"));
		costclassvo.setDwbm(jsonObj1.getString("dwbm"));
		costclassvo.setFkyhzh(jsonObj1.getString("fkyhzh"));
		costclassvo.setFydeptid(jsonObj1.getString("fydeptid"));
		costclassvo.setFydwbm(jsonObj1.getString("fydwbm"));
		costclassvo.setHbbm(jsonObj1.getString("hbbm"));
		costclassvo.setJkbxr(jsonObj1.getString("jkbxr"));
		costclassvo.setJsfs(jsonObj1.getString("jsfs"));
		costclassvo.setMobile(jsonObj1.getString("mobile"));
		costclassvo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		costclassvo.setPaytarget(jsonObj1.getString("paytarget"));
		costclassvo.setSkyhzh(jsonObj1.getString("skyhzh"));
		costclassvo.setTotal(jsonObj1.getString("total"));
		costclassvo.setZyx19(jsonObj1.getString("zyx19"));
		boolean hascbqr = jsonObj.has("cbqr");// 成本确认
		boolean hascxmx = jsonObj.has("cxmx");// 冲销明细
		CostClassSubItem costclasssub = new CostClassSubItem();						
		List<CostClassItem> itemVOList =new  ArrayList<CostClassItem>();// 成本确认
		CostClassItem itemvo = null;
		List<CostClassWriteoffVO> writeoffvoList = new  ArrayList<CostClassWriteoffVO>();// 冲销明细
		CostClassWriteoffVO writeoffvo = null;
		// 填充成本确认
		if(hascbqr){
			JSONArray jsonObjcbqr = JSONArray.fromObject(jsonObj.getString("cbqr"));
			if(jsonObjcbqr.size()>0){
				for(int i=0;i<jsonObjcbqr.size();i++){  
					JSONObject job = jsonObjcbqr.getJSONObject(i); 
					itemvo =new CostClassItem();
					itemvo.setSzxmid(job.getString("szxmid"));
					itemvo.setFphm(job.getString("fphm"));
					itemvo.setDefitem6(job.getString("defitem6"));
					itemvo.setTax_amount(job.getString("tax_amount"));
					itemvo.setTax_rate(job.getString("tax_rate"));
					itemvo.setTni_amount(job.getString("tni_amount"));
					itemvo.setVat_amount(job.getString("vat_amount"));
					itemvo.setDefitem20(job.getString("defitem20"));
					itemVOList.add(itemvo);
				}  
			}
		}				
		// 填充冲销明细
		if(hascxmx){
			JSONArray jsonObjcxmx = JSONArray.fromObject(jsonObj.getString("cxmx"));
			if(jsonObjcxmx.size()>0){
				for(int i=0;i<jsonObjcxmx.size();i++){
					JSONObject job = jsonObjcxmx.getJSONObject(i);
					writeoffvo = new CostClassWriteoffVO();
					writeoffvo.setJkdjbh(job.getString("jkdjbh"));
					writeoffvo.setJkbxr(job.getString("jkbxr"));
					writeoffvo.setDeptid(job.getString("deptid"));
					writeoffvo.setCjkybje(job.getString("cjkybje"));
					writeoffvo.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
					writeoffvo.setSxbz(job.getString("sxbz"));
					writeoffvo.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
					writeoffvoList.add(writeoffvo);
				}
			}
		}						
		costclasssub.setItemVOList(itemVOList);
		costclasssub.setWriteoffvoList(writeoffvoList);	
		costclasssub.setAttachmentList(this.getfileVOlist(billid));
		costclasssub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		costclassvo.setCostclasssub(costclasssub);
		return costclassvo;
	}

	// 销售宣传费用报销单
	@Override
	public SalesPropMainVO getSalesPropData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		SalesPropMainVO salespropvo = new SalesPropMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		salespropvo.setCustaccount(jsonObj1.getString("custaccount"));
		salespropvo.setDeptid(jsonObj1.getString("deptid"));
		salespropvo.setDjbh(jsonObj1.getString("djbh"));
		salespropvo.setDjrq(jsonObj1.getString("djrq"));
		salespropvo.setDwbm(jsonObj1.getString("dwbm"));
		salespropvo.setFkyhzh(jsonObj1.getString("fkyhzh"));
		salespropvo.setFydeptid(jsonObj1.getString("fydeptid"));
		salespropvo.setFydwbm(jsonObj1.getString("fydwbm"));
		salespropvo.setHbbm(jsonObj1.getString("hbbm"));
		salespropvo.setJkbxr(jsonObj1.getString("jkbxr"));
		salespropvo.setJsfs(jsonObj1.getString("jsfs"));
		salespropvo.setMobile(jsonObj1.getString("mobile"));
		salespropvo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		salespropvo.setPaytarget(jsonObj1.getString("paytarget"));
		salespropvo.setSkyhzh(jsonObj1.getString("bankcode"));// 个人银行账户
		salespropvo.setTotal(jsonObj1.getString("total"));
		salespropvo.setJobid(jsonObj1.getString("project_name"));
		salespropvo.setZyx29(jsonObj1.getString("zyx29"));
		salespropvo.setZyx5(jsonObj1.getString("zyx5"));
		boolean hasxsxcfy = jsonObj.has("xsxcfy");// 销售宣传费用
		boolean hascxmx = jsonObj.has("cxmx");// 冲销明细
		SalesPropSubItem salespropsub = new SalesPropSubItem();						
		List<SalesPropItem> itemVOList =new  ArrayList<SalesPropItem>();// 销售宣传费用
		SalesPropItem itemvo = null;
		List<SalesPropWriteoffVO> writeoffvoList = new  ArrayList<SalesPropWriteoffVO>();// 冲销明细
		SalesPropWriteoffVO writeoffvo = null;
		// 填充销售宣传费用
		if(hasxsxcfy){
			JSONArray jsonObjxsxcfy = JSONArray.fromObject(jsonObj.getString("xsxcfy"));
			if(jsonObjxsxcfy.size() > 0){
				for(int i=0;i<jsonObjxsxcfy.size();i++){
					JSONObject job = jsonObjxsxcfy.getJSONObject(i);
					itemvo = new SalesPropItem();
					itemvo.setVat_amount(job.getString("vat_amount"));
					itemvo.setDefitem20(job.getString("defitem20"));
					itemvo.setDefitem6(job.getString("defitem6"));
					itemvo.setFpdm(job.getString("fpdm"));
					itemvo.setSzxmid(job.getString("szxmid"));
					itemvo.setTax_amount(job.getString("tax_amount"));
					itemvo.setTax_rate(job.getString("tax_rate"));
					itemVOList.add(itemvo);
				}
			}
		}
		// 填充冲销明细
		if(hascxmx){
			JSONArray jsonObjcxmx = JSONArray.fromObject(jsonObj.getString("cxmx"));
			if(jsonObjcxmx.size()>0){
				for(int i=0;i<jsonObjcxmx.size();i++){
					JSONObject job = jsonObjcxmx.getJSONObject(i);
					writeoffvo = new SalesPropWriteoffVO();
					writeoffvo.setJkdjbh(job.getString("jkdjbh"));
					writeoffvo.setJkbxr(job.getString("jkbxr"));
					writeoffvo.setDeptid(job.getString("deptid"));
					writeoffvo.setCjkybje(job.getString("cjkybje"));
					writeoffvo.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
					writeoffvo.setSxbz(job.getString("sxbz"));
					writeoffvo.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
					writeoffvoList.add(writeoffvo);
				}
			}
		}	
		salespropsub.setItemVOList(itemVOList);
		salespropsub.setWriteoffvoList(writeoffvoList);
		salespropsub.setAttachmentList(this.getfileVOlist(billid));
		salespropsub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		salespropvo.setSalespropsub(salespropsub);
		return salespropvo;
	}

	// 公车费用报销单
	@Override
	public PublicBusMainVO getPublicBusData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		PublicBusMainVO publicbusvo = new PublicBusMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		publicbusvo.setDjbh(jsonObj1.getString("djbh"));
		publicbusvo.setDjrq(jsonObj1.getString("djrq"));
		publicbusvo.setTotal(jsonObj1.getString("total"));
		publicbusvo.setSkyhzh(jsonObj1.getString("bankcode"));
		publicbusvo.setJkbxr(jsonObj1.getString("jkbxr"));
		publicbusvo.setMobile(jsonObj1.getString("mobile"));
		publicbusvo.setPk_org(jsonObj1.getString("dwbm"));// 报销人单位
		publicbusvo.setFkyhzh(jsonObj1.getString("fkyhzh"));
		publicbusvo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		publicbusvo.setJsfs(jsonObj1.getString("jsfs"));
		publicbusvo.setFydeptid(jsonObj1.getString("fydeptid"));
		publicbusvo.setFydwbm(jsonObj1.getString("fydwbm"));
		publicbusvo.setproject_name(jsonObj1.getString("project_name"));
		publicbusvo.setHbbm(jsonObj1.getString("hbbm"));
		publicbusvo.setDeptid(jsonObj1.getString("deptid"));
		publicbusvo.setPaytarget(jsonObj1.getString("paytarget"));
		publicbusvo.setCustaccount(jsonObj1.getString("custaccount"));
		publicbusvo.setZyx5(jsonObj1.getString("zyx5"));
		boolean hasgcfy = jsonObj.has("gcfy");// 公车费用
		boolean haszsfy = jsonObj.has("zsfy");// 住宿费用
		boolean hasccbt = jsonObj.has("ccbt");// 出差补贴
		boolean hascxmx = jsonObj.has("cxmx");// 冲销明细
		PublicBusSubItem publicbussub = new PublicBusSubItem();						
		List<PublicBusItem> itemVOList =new  ArrayList<PublicBusItem>();// 公车费用
		PublicBusItem itemvo = null;
		List<PublicHotelItem> hotelList =new  ArrayList<PublicHotelItem>();// 住宿费用
		PublicHotelItem hotelvo = null;
		List<PublicTravelItem> travelList =new  ArrayList<PublicTravelItem>();//  出差补贴
		PublicTravelItem travelvo = null;
		List<PublicBusWriteoffVO> writeoffvoList = new  ArrayList<PublicBusWriteoffVO>();// 冲销明细
		PublicBusWriteoffVO writeoffvo = null;
		// 填充公车费用
		if(hasgcfy){
			JSONArray jsonObjgcfy = JSONArray.fromObject(jsonObj.getString("gcfy"));
			if(jsonObjgcfy.size() > 0){
				for(int i=0;i<jsonObjgcfy.size();i++){
					JSONObject job = jsonObjgcfy.getJSONObject(i);
					itemvo = new PublicBusItem();
					itemvo.setDefitem10(job.getString("defitem10"));
					itemvo.setSzxmid(job.getString("szxmid"));
					itemvo.setDefitem1(job.getString("defitem1"));
					itemvo.setDefitem6(job.getString("defitem6"));
					itemvo.setTax_amount(job.getString("tax_amount"));
					itemvo.setTax_rate(job.getString("tax_rate"));
					itemvo.setVat_amount(job.getString("vat_amount"));
					itemvo.setTni_amount(job.getString("tni_amount"));
					itemvo.setFphm(job.getString("fphm"));
					itemVOList.add(itemvo);
				}
			}
		}
		// 填充住宿费用
		if(haszsfy){
			JSONArray jsonObjzsfy = JSONArray.fromObject(jsonObj.getString("zsfy"));
			if(jsonObjzsfy.size() > 0){
				for(int i=0;i<jsonObjzsfy.size();i++){
					JSONObject job = jsonObjzsfy.getJSONObject(i);
					hotelvo = new PublicHotelItem();
					hotelvo.setSzxmid(job.getString("szxmid"));
					hotelvo.setDefitem1(job.getString("defitem1"));
					hotelvo.setDefitem2(job.getString("defitem2"));
					hotelvo.setDefitem9(job.getString("defitem9"));
					hotelvo.setTax_amount(job.getString("tax_amount"));
					hotelvo.setTax_rate(job.getString("tax_rate"));
					hotelvo.setVat_amount(job.getString("vat_amount"));
					hotelList.add(hotelvo);
				}
			}
		}
		// 填充出差补贴
		if(hasccbt){
			JSONArray jsonObjccbt = JSONArray.fromObject(jsonObj.getString("ccbt"));
			if(jsonObjccbt.size() > 0){
				for(int i=0;i<jsonObjccbt.size();i++){
					JSONObject job = jsonObjccbt.getJSONObject(i);
					travelvo = new PublicTravelItem();
					travelvo.setSzxmid(job.getString("szxmid"));
					travelvo.setDefitem9(job.getString("defitem9"));
					travelvo.setDefitem11(job.getString("defitem11"));
					travelvo.setVat_amount(job.getString("vat_amount"));
					travelList.add(travelvo);
				}
			}
		}
		// 填充冲销明细
		if(hascxmx){
			JSONArray jsonObjcxmx = JSONArray.fromObject(jsonObj.getString("cxmx"));
			if(jsonObjcxmx.size()>0){
				for(int i=0;i<jsonObjcxmx.size();i++){
					JSONObject job = jsonObjcxmx.getJSONObject(i);
					writeoffvo = new PublicBusWriteoffVO();
					writeoffvo.setJkdjbh(job.getString("jkdjbh"));
					writeoffvo.setJkbxr(job.getString("jkbxr"));
					writeoffvo.setDeptid(job.getString("deptid"));
					writeoffvo.setCjkybje(job.getString("cjkybje"));
					writeoffvo.setFyybje(job.getString("fyybje"));
					writeoffvo.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
					writeoffvo.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
					writeoffvoList.add(writeoffvo);
				}
			}
		}
		publicbussub.setHotelList(hotelList);
		publicbussub.setItemVOList(itemVOList);
		publicbussub.setTravelList(travelList);
		publicbussub.setWriteoffvoList(writeoffvoList);
		publicbussub.setAttachmentList(this.getfileVOlist(billid));
		publicbussub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		publicbusvo.setPublicbussub(publicbussub);
		return publicbusvo;
	}

	// 还款单
	@Override
	public RepaymentMainVO getRepaymentData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		RepaymentMainVO repaymentvo = new RepaymentMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		repaymentvo.setCjkbbje(jsonObj1.getString("cjkbbje"));
		repaymentvo.setDeptid(jsonObj1.getString("deptid"));
		repaymentvo.setDjbh(jsonObj1.getString("djbh"));
		repaymentvo.setDjrq(jsonObj1.getString("djrq"));
		repaymentvo.setDwbm(jsonObj1.getString("dwbm"));
		repaymentvo.setFydeptid(jsonObj1.getString("fydeptid"));
		repaymentvo.setFydwbm(jsonObj1.getString("fydwbm"));
		repaymentvo.setHkybje(jsonObj1.getString("hkybje"));
		repaymentvo.setJkbxr(jsonObj1.getString("jkbxr"));
		repaymentvo.setJsfs(jsonObj1.getString("jsfs"));
		repaymentvo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		repaymentvo.setSkyhzh(jsonObj1.getString("bankcode"));
		boolean hashkxx = jsonObj.has("hkxx");// 还款信息
		RepaymentSubItem repaymentsub = new RepaymentSubItem();						
		List<RepaymentItem> itemVOList =new  ArrayList<RepaymentItem>();// 公车费用
		RepaymentItem itemvo = null;
		// 填充还款信息
		if(hashkxx){
			JSONArray jsonObjhkxx = JSONArray.fromObject(jsonObj.getString("hkxx"));
			if(jsonObjhkxx.size()>0){
				for(int i=0;i<jsonObjhkxx.size();i++){
					JSONObject job = jsonObjhkxx.getJSONObject(i);
					itemvo = new RepaymentItem();
					itemvo.setJkdjbh(job.getString("jkdjbh"));
					itemvo.setJkbxr(job.getString("jkbxr"));
					itemvo.setDeptid(job.getString("deptid"));
					itemvo.setHkybje(job.getString("hkybje"));
					itemvo.setSxbz(job.getString("sxbz"));
					itemvo.setCxrq(DateTimeUtil.getShortDate(job.getString("cxrq")));
					itemvo.setSxrq(DateTimeUtil.getShortDate(job.getString("sxrq")));
					itemvo.setSzxmid(job.getString("szxmid"));
					itemVOList.add(itemvo);
				}
			}
		}
		repaymentsub.setItemVOList(itemVOList);
		repaymentsub.setAttachmentList(this.getfileVOlist(billid));
		repaymentsub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		repaymentvo.setRepaymentsub(repaymentsub);
		return repaymentvo;
	}

	// 借款单（个人）
	@Override
	public BorrowPsnMainVO getBorrPsnData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		BorrowPsnMainVO brrowPsnvo = new BorrowPsnMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		brrowPsnvo.setDeptid(jsonObj1.getString("deptid"));	
		brrowPsnvo.setDjbh(jsonObj1.getString("djbh"));
		brrowPsnvo.setDjrq(jsonObj1.getString("djrq"));
		brrowPsnvo.setFkyhzh(jsonObj1.getString("fkyhzh"));
		brrowPsnvo.setFydeptid(jsonObj1.getString("fydeptid"));
		brrowPsnvo.setFydwbm(jsonObj1.getString("fydwbm"));
		brrowPsnvo.setJkbxr(jsonObj1.getString("jkbxr"));	
		brrowPsnvo.setJobid(jsonObj1.getString("jobid"));
		brrowPsnvo.setJsfs(jsonObj1.getString("jsfs"));
		brrowPsnvo.setMobile(jsonObj1.getString("mobile"));
		brrowPsnvo.setPk_cashaccount(jsonObj1.getString("pk_cashaccount"));
		brrowPsnvo.setPk_org(jsonObj1.getString("pk_org"));	
		brrowPsnvo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		brrowPsnvo.setSkyhzh(jsonObj1.getString("skyhzh"));
		brrowPsnvo.setTotal(jsonObj1.getString("total"));
		brrowPsnvo.setZyx1(jsonObj1.getString("zyx1"));
		brrowPsnvo.setZyx5(jsonObj1.getString("zyx5"));
		boolean hasjkje = jsonObj.has("jkje");
		BorrowPsnSubItem brrowPsnsub = new BorrowPsnSubItem();						
		List<BorrowPsnItem> itemVOList =new  ArrayList<BorrowPsnItem>();// 借款金额
		BorrowPsnItem itemvo = null;
		// 借款金额
		if(hasjkje){
			JSONArray jsonObjjkje = JSONArray.fromObject(jsonObj.getString("jkje"));
			if(jsonObjjkje.size()>0){
				for(int i=0;i<jsonObjjkje.size();i++){
					JSONObject job = jsonObjjkje.getJSONObject(i);
					itemvo = new BorrowPsnItem();
					itemvo.setSzxmid(job.getString("szxmid"));
					itemvo.setAmount(job.getString("amount"));
					itemVOList.add(itemvo);
				}
			}
		}
		brrowPsnsub.setItemVOList(itemVOList);
		brrowPsnsub.setAttachmentList(this.getfileVOlist(billid));
		brrowPsnsub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		brrowPsnvo.setBrrowPsnsub(brrowPsnsub);
		return brrowPsnvo;
	}

	// 借款单（对公）
	@Override
	public BorrowPubMainVO getBorrPubData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		BorrowPubMainVO brrowPubvo = new BorrowPubMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		brrowPubvo.setDeptid(jsonObj1.getString("deptid"));	
		brrowPubvo.setDjbh(jsonObj1.getString("djbh"));
		brrowPubvo.setDjrq(jsonObj1.getString("djrq"));
		brrowPubvo.setFkyhzh(jsonObj1.getString("fkyhzh"));
		brrowPubvo.setFydeptid(jsonObj1.getString("fydeptid"));
		brrowPubvo.setFydwbm(jsonObj1.getString("fydwbm"));
		brrowPubvo.setJkbxr(jsonObj1.getString("jkbxr"));	
		brrowPubvo.setJobid(jsonObj1.getString("jobid"));
		brrowPubvo.setJsfs(jsonObj1.getString("jsfs"));
		brrowPubvo.setMobile(jsonObj1.getString("mobile"));
		brrowPubvo.setPk_cashaccount(jsonObj1.getString("pk_cashaccount"));
		brrowPubvo.setPk_org(jsonObj1.getString("pk_org"));	
		brrowPubvo.setPk_payorg(jsonObj1.getString("pk_payorg"));
		brrowPubvo.setSkyhzh(jsonObj1.getString("skyhzh"));
		brrowPubvo.setTotal(jsonObj1.getString("total"));
		brrowPubvo.setZyx1(jsonObj1.getString("zyx1"));
		brrowPubvo.setZyx5(jsonObj1.getString("zyx5"));
		brrowPubvo.setPaytarget(jsonObj1.getString("paytarget"));
		brrowPubvo.setHbbm(jsonObj1.getString("hbbm"));
		brrowPubvo.setCustaccount(jsonObj1.getString("custaccount"));
		boolean hasjkje = jsonObj.has("jkje");
		BorrowPubSubItem brrowPubsub = new BorrowPubSubItem();						
		List<BorrowPubItem> itemVOList =new  ArrayList<BorrowPubItem>();// 借款金额
		BorrowPubItem itemvo = null;
		// 借款金额
		if(hasjkje){
			JSONArray jsonObjjkje = JSONArray.fromObject(jsonObj.getString("jkje"));
			if(jsonObjjkje.size()>0){
				for(int i=0;i<jsonObjjkje.size();i++){
					JSONObject job = jsonObjjkje.getJSONObject(i);
					itemvo = new BorrowPubItem();
					itemvo.setSzxmid(job.getString("szxmid"));
					itemvo.setAmount(job.getString("amount"));
					itemVOList.add(itemvo);
				}
			}
		}
		brrowPubsub.setItemVOList(itemVOList);
		brrowPubsub.setAttachmentList(this.getfileVOlist(billid));
		brrowPubsub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		brrowPubvo.setBrrowPubsub(brrowPubsub);
		return brrowPubvo;
	}

	// 招待费申请单
	@Override
	public ServePutMainVO getservePutData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		ServePutMainVO servePutvo = new ServePutMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		servePutvo.setAmount(jsonObj1.getString("amount"));
		servePutvo.setApply_dept(jsonObj1.getString("apply_dept"));
		servePutvo.setApply_org(jsonObj1.getString("apply_org"));
		servePutvo.setBilldate(jsonObj1.getString("billdate"));
		servePutvo.setBillmaker(jsonObj1.getString("billmaker"));
		servePutvo.setBillno(jsonObj1.getString("billno"));
		servePutvo.setDefitem2(jsonObj1.getString("defitem2"));
		servePutvo.setDefitem3(jsonObj1.getString("defitem3"));
		servePutvo.setDefitem30(jsonObj1.getString("defitem30"));
		boolean haszdf1 = jsonObj.has("zdf1");
		ServePutSubItem servePutsub = new ServePutSubItem();						
		List<ServePutItemVO> itemVOList =new  ArrayList<ServePutItemVO>();// 详细信息
		ServePutItemVO itemvo = null;
		// 填充详细信息
		if(haszdf1){
			JSONArray jsonObjzdf1 = JSONArray.fromObject(jsonObj.getString("zdf1"));
			if(jsonObjzdf1.size()>0){
				for(int i=0;i<jsonObjzdf1.size();i++){
					JSONObject job = jsonObjzdf1.getJSONObject(i);
					itemvo = new ServePutItemVO();
					itemvo.setMax_amount(job.getString("max_amount"));
					itemvo.setAmount(job.getString("amount"));
					itemVOList.add(itemvo);
				}
			}
		}
		servePutsub.setItemVOList(itemVOList);
		servePutsub.setAttachmentList(this.getfileVOlist(billid));
		servePutsub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		servePutvo.setServePutsub(servePutsub);
		return servePutvo;
	}

	// 油卡充值申请单
	@Override
	public OilCardMainVO getoilcardData(JSONObject jsonObj,String billid, String billtype, String checkman) {
		OilCardMainVO oilcardvo = new OilCardMainVO();
		// 填充主表
		JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getString("h"));
		oilcardvo.setAmount(jsonObj1.getString("amount"));
		oilcardvo.setApply_dept(jsonObj1.getString("apply_dept"));
		oilcardvo.setApply_org(jsonObj1.getString("apply_org"));
		oilcardvo.setBilldate(jsonObj1.getString("billdate"));
		oilcardvo.setBillmaker(jsonObj1.getString("billmaker"));
		oilcardvo.setBillno(jsonObj1.getString("billno"));
		oilcardvo.setDefitem2(jsonObj1.getString("defitem2"));
		oilcardvo.setDefitem29(jsonObj1.getString("defitem29"));
		oilcardvo.setDefitem3(jsonObj1.getString("defitem3"));
		oilcardvo.setDefitem30(jsonObj1.getString("defitem30"));
		boolean haszdf1 = jsonObj.has("zdf1");
		OilCardSubItem  oilcardsub = new OilCardSubItem();						
		List<OilCardItemVO> itemVOList =new  ArrayList<OilCardItemVO>();// 详细信息
		OilCardItemVO itemvo = null;
		// 填充详细信息
		if(haszdf1){
			JSONArray jsonObjzdf1 = JSONArray.fromObject(jsonObj.getString("zdf1"));
			if(jsonObjzdf1.size()>0){
				for(int i=0;i<jsonObjzdf1.size();i++){
					JSONObject job = jsonObjzdf1.getJSONObject(i);
					itemvo = new OilCardItemVO();
					itemvo.setDefitem2(job.getString("defitem2"));
					itemvo.setAmount(job.getString("amount"));
					itemVOList.add(itemvo);
				}
			}
		}
		oilcardsub.setItemVOList(itemVOList);
		oilcardsub.setAttachmentList(this.getfileVOlist(billid));
		oilcardsub.setImgURL(this.getimageVOlist(billid, billtype, checkman));
		oilcardvo.setOilcardsub(oilcardsub);
		return oilcardvo;
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
}
