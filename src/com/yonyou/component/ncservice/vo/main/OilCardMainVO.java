package com.yonyou.component.ncservice.vo.main;

import com.yonyou.component.ncservice.vo.sub.oilcard.OilCardSubItem;

/**
 * 油卡充值申请单
 * @author ChenChong
 * @since 2018-06-19
 */
public class OilCardMainVO {

	private String billno;// 单据编号
	private String billdate;// 单据日期
	private String billmaker;// 申请人
	private String apply_org;// 申请单位
	private String apply_dept;// 申请部门
	private String amount;// 申请金额
	private String defitem2;// 手机
	private String defitem3;// 充值卡号
	private String defitem29;// 单据录入说明
	private String defitem30;// 事由
	private OilCardSubItem  oilcardsub;// 子表信息list
	
	public OilCardMainVO(){
		
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getBilldate() {
		return billdate;
	}

	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}

	public String getBillmaker() {
		return billmaker;
	}

	public void setBillmaker(String billmaker) {
		this.billmaker = billmaker;
	}

	public String getApply_org() {
		return apply_org;
	}

	public void setApply_org(String apply_org) {
		this.apply_org = apply_org;
	}

	public String getApply_dept() {
		return apply_dept;
	}

	public void setApply_dept(String apply_dept) {
		this.apply_dept = apply_dept;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDefitem2() {
		return defitem2;
	}

	public void setDefitem2(String defitem2) {
		this.defitem2 = defitem2;
	}

	public String getDefitem3() {
		return defitem3;
	}

	public void setDefitem3(String defitem3) {
		this.defitem3 = defitem3;
	}

	public String getDefitem29() {
		return defitem29;
	}

	public void setDefitem29(String defitem29) {
		this.defitem29 = defitem29;
	}

	public String getDefitem30() {
		return defitem30;
	}

	public void setDefitem30(String defitem30) {
		this.defitem30 = defitem30;
	}

	public OilCardSubItem getOilcardsub() {
		return oilcardsub;
	}

	public void setOilcardsub(OilCardSubItem oilcardsub) {
		this.oilcardsub = oilcardsub;
	}
	
}
