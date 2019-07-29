package com.yonyou.component.ncservice.vo.main;

import com.yonyou.component.ncservice.vo.sub.borrowpsn.BorrowPsnSubItem;

/**
 * 借款单（个人）
 * @author ChenChong
 * @since 2018-06-29
 */
public class BorrowPsnMainVO {
	
	private String pk_billtypeid;// 交易类型
	private String djbh;// 单据编号
	private String djrq;// 单据日期
	private String total;// 借款金额
	private String jkbxr;// 借款人
	private String pk_org;// 借款单位
	private String zyx1;// 借款人岗位
	private String mobile;// 手机
	private String skyhzh;// 个人银行账户
	private String fydwbm;// 费用承担单位
	private String fydeptid;// 费用承担部门
	private String pk_payorg;// 支付单位
	private String jsfs;// 结算方式
	private String fkyhzh;// 单位银行账户
	private String pk_cashaccount;// 现金账户
	private String zyx5;// 事由
	private String deptid;// 借款人部门
	private String jobid;// 项目
	private BorrowPsnSubItem brrowPsnsub;// 子表信息list
	
	public BorrowPsnMainVO(){
		
	}

	public String getPk_billtypeid() {
		return pk_billtypeid;
	}

	public void setPk_billtypeid(String pk_billtypeid) {
		this.pk_billtypeid = pk_billtypeid;
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

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getJkbxr() {
		return jkbxr;
	}

	public void setJkbxr(String jkbxr) {
		this.jkbxr = jkbxr;
	}

	public String getPk_org() {
		return pk_org;
	}

	public void setPk_org(String pk_org) {
		this.pk_org = pk_org;
	}

	public String getZyx1() {
		return zyx1;
	}

	public void setZyx1(String zyx1) {
		this.zyx1 = zyx1;
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

	public String getPk_cashaccount() {
		return pk_cashaccount;
	}

	public void setPk_cashaccount(String pk_cashaccount) {
		this.pk_cashaccount = pk_cashaccount;
	}

	public String getZyx5() {
		return zyx5;
	}

	public void setZyx5(String zyx5) {
		this.zyx5 = zyx5;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public BorrowPsnSubItem getBrrowPsnsub() {
		return brrowPsnsub;
	}

	public void setBrrowPsnsub(BorrowPsnSubItem brrowPsnsub) {
		this.brrowPsnsub = brrowPsnsub;
	}
	
}
