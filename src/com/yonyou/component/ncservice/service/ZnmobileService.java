package com.yonyou.component.ncservice.service;

import net.sf.json.JSONObject;

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

public interface ZnmobileService {
	// 发票入账单
	InvoiceInBillMainVO getInvoiceInBillData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 公司福利报销单
	BenefitMainVO getBenefitData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 费用报销单（个人）
	CostPsnMainVO getCostPsnData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 电脑补贴报销单
	ComputerMainVO getComputerData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 招待费报销单-需申请
	ServeNeedApplyMainVO getServeNeedApplyData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 成本类报销单
	CostClassMainVO getCostClassData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 销售宣传费用报销单
	SalesPropMainVO getSalesPropData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 公车费用报销单
	PublicBusMainVO getPublicBusData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 还款单
	RepaymentMainVO getRepaymentData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 借款单（个人）
	BorrowPsnMainVO getBorrPsnData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 借款单（对公）
	BorrowPubMainVO getBorrPubData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 招待费申请单
	ServePutMainVO getservePutData(JSONObject jsonObj, String billid, String billtype, String checkman);
	// 油卡充值申请单
	OilCardMainVO getoilcardData(JSONObject jsonObj, String billid, String billtype, String checkman);
}
