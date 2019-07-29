package com.yonyou.component.ncservice.vo.main;

import com.yonyou.component.ncservice.vo.sub.costclass.CostClassSubItem;

/**
 * 成本类报销单
 * @author ChenChong
 * @since 2018-06-19
 */
public class CostClassMainVO {
	
	private String djbh;// 单据编号
	private String djrq;// 单据日期
	private String jkbxr;// 报销人
	private String dwbm;// 报销人单位
	private String deptid;// 报销人部门
	private String mobile;// 手机
	private String skyhzh;// 个人银行账户
	private String total;// 合计金额
	private String fydwbm;// 费用承担单位
	private String fydeptid;// 费用承担部门
	private String pk_payorg;// 支付单位
	private String jsfs;// 结算方式
	private String fkyhzh;// 单位银行账户
	private String paytarget;// 支付对象
	private String hbbm;// 供应商
	private String custaccount;// 供应商银行账户
	private String zyx19;// 事由
	private CostClassSubItem costclasssub;// 子表信息list
	
	public CostClassMainVO(){
		
	}

	public String getDjbh() {
		return djbh;
	}

	public void setDjbh(String djbh) {
		this.djbh = djbh;
	}

	public String getDjrq() {
		return djrq;
	}

	public void setDjrq(String djrq) {
		this.djrq = djrq;
	}

	public String getJkbxr() {
		return jkbxr;
	}

	public void setJkbxr(String jkbxr) {
		this.jkbxr = jkbxr;
	}

	public String getDwbm() {
		return dwbm;
	}

	public void setDwbm(String dwbm) {
		this.dwbm = dwbm;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSkyhzh() {
		return skyhzh;
	}

	public void setSkyhzh(String skyhzh) {
		this.skyhzh = skyhzh;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getFydwbm() {
		return fydwbm;
	}

	public void setFydwbm(String fydwbm) {
		this.fydwbm = fydwbm;
	}

	public String getFydeptid() {
		return fydeptid;
	}

	public void setFydeptid(String fydeptid) {
		this.fydeptid = fydeptid;
	}

	public String getPk_payorg() {
		return pk_payorg;
	}

	public void setPk_payorg(String pk_payorg) {
		this.pk_payorg = pk_payorg;
	}

	public String getJsfs() {
		return jsfs;
	}

	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}

	public String getFkyhzh() {
		return fkyhzh;
	}

	public void setFkyhzh(String fkyhzh) {
		this.fkyhzh = fkyhzh;
	}

	public String getPaytarget() {
		return paytarget;
	}

	public void setPaytarget(String paytarget) {
		this.paytarget = paytarget;
	}

	public String getHbbm() {
		return hbbm;
	}

	public void setHbbm(String hbbm) {
		this.hbbm = hbbm;
	}

	public String getCustaccount() {
		return custaccount;
	}

	public void setCustaccount(String custaccount) {
		this.custaccount = custaccount;
	}

	public String getZyx19() {
		return zyx19;
	}

	public void setZyx19(String zyx19) {
		this.zyx19 = zyx19;
	}

	public CostClassSubItem getCostclasssub() {
		return costclasssub;
	}

	public void setCostclasssub(CostClassSubItem costclasssub) {
		this.costclasssub = costclasssub;
	}
	
}
