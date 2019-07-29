package com.yonyou.component.
ncservice.vo.main;

import com.yonyou.component.ncservice.vo.sub.repayment.RepaymentSubItem;

/**
 * 还款单
 * @author ChenChong
 * @since 2018-06-21
 */
public class RepaymentMainVO {

	private String djbh;// 单据编号
	private String djrq;// 单据日期
	private String hkybje;// 还款金额
	private String jkbxr;// 还款人
	private String dwbm;// 报销人单位
	private String deptid;// 报销人部门
	private String cjkbbje;// 冲借款金额
	private String fydwbm;// 费用承担单位
	private String fydeptid;// 费用承担部门
	private String pk_payorg;// 支付单位
	private String skyhzh;// 个人银行账户
	private String jsfs;// 结算方式
	private RepaymentSubItem repaymentsub;// 子表信息list
	
	public RepaymentMainVO(){
		
	}

	public RepaymentSubItem getRepaymentsub() {
		return repaymentsub;
	}

	public void setRepaymentsub(RepaymentSubItem repaymentsub) {
		this.repaymentsub = repaymentsub;
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

	public String getHkybje() {
		return hkybje;
	}

	public void setHkybje(String hkybje) {
		this.hkybje = hkybje;
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

	public String getCjkbbje() {
		return cjkbbje;
	}

	public void setCjkbbje(String cjkbbje) {
		this.cjkbbje = cjkbbje;
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

	public String getSkyhzh() {
		return skyhzh;
	}

	public void setSkyhzh(String skyhzh) {
		this.skyhzh = skyhzh;
	}

	public String getJsfs() {
		return jsfs;
	}

	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}
	
}
