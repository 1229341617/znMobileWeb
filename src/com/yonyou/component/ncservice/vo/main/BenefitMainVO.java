package com.yonyou.component.ncservice.vo.main;

import com.yonyou.component.ncservice.vo.sub.benefit.BenefitsubItem;

/**
 * 公司福利报销单
 * @author ChenChong
 * @since 2018-06-14
 */
public class BenefitMainVO {
	
	private String total;// 合计金额
	private String project_name;// 项目名称
	private String jkbxr;// 单据报销人
	private String dwbm;// 报销人单位
	private String djrq;// 单据日期
	private String fydeptid;// 费用承担部门
	private String paytarget;// 支付对象
	private String fydwbm;// 费用承担部门
	private String zyx29;// 备注
	private String zyx19;// 事由
	private String jobid;// 产业类别
	private String deptid;// 报销人部门
	private String pk_payorg;// 支付单位
	private String hbbm;// 供应商
	private String bankcode;// 个人银行账户
	private String jsfs;// 结算方式
	private String fkyhzh;// 单位银行账户
	private String custacccount;// 供应商银行账户
	private String djbh;// 单据编号
	private String mobile;// 手机
	private BenefitsubItem benefitsub;// 子表信息list
	
	public BenefitMainVO(){
		
	}
	
	public BenefitsubItem getBenefitsub() {
		return benefitsub;
	}
	public void setBenefitsub(BenefitsubItem benefitsub) {
		this.benefitsub = benefitsub;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
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
	public String getDjrq() {
		return djrq;
	}
	public void setDjrq(String djrq) {
		this.djrq = djrq;
	}
	public String getFydeptid() {
		return fydeptid;
	}
	public void setFydeptid(String fydeptid) {
		this.fydeptid = fydeptid;
	}
	public String getPaytarget() {
		return paytarget;
	}
	public void setPaytarget(String paytarget) {
		this.paytarget = paytarget;
	}
	public String getFydwbm() {
		return fydwbm;
	}
	public void setFydwbm(String fydwbm) {
		this.fydwbm = fydwbm;
	}
	public String getZyx29() {
		return zyx29;
	}
	public void setZyx29(String zyx29) {
		this.zyx29 = zyx29;
	}
	public String getZyx19() {
		return zyx19;
	}
	public void setZyx19(String zyx19) {
		this.zyx19 = zyx19;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getPk_payorg() {
		return pk_payorg;
	}
	public void setPk_payorg(String pk_payorg) {
		this.pk_payorg = pk_payorg;
	}
	public String getHbbm() {
		return hbbm;
	}
	public void setHbbm(String hbbm) {
		this.hbbm = hbbm;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
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
	public String getCustacccount() {
		return custacccount;
	}
	public void setCustacccount(String custacccount) {
		this.custacccount = custacccount;
	}
	public String getDjbh() {
		return djbh;
	}
	public void setDjbh(String djbh) {
		this.djbh = djbh;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
