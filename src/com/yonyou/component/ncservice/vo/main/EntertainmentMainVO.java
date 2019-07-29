package com.yonyou.component.ncservice.vo.main;

import com.yonyou.component.ncservice.vo.sub.entertainment.EntertainmentSub;

public class EntertainmentMainVO {
	private String djbh;//单据编号
	private String djrq;//日期
	private String total;//招待费合计金额
	private String jkbxr;// 报销人
	private String mobile;// 手机
	private String bankcode;//个人银行账户
	private String dwbm;//通用类和招待费报销人单位
	private String deptid;//报销人部门
	private String fydwbm;//费用承担单位
	private String fydeptid;//通用类和招待费费用承担部门
	private String jsfs;//结算方式
	private String fkyhzh;//单位银行账户pk_payorg
	private String pk_payorg;//支付单位
	private String project_name;//项目
	private String paytarget;//支付对象hbbm  zyx29  custacccount  zyx19
	private String hbbm;//供应商
	private String zyx29;//备注
	private String custacccount;//供应商银行账户
	private String zyx19;//事由

	private EntertainmentSub  entertainmentSub;//详细信息list
	
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
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

	public String getPk_payorg() {
		return pk_payorg;
	}

	public void setPk_payorg(String pk_payorg) {
		this.pk_payorg = pk_payorg;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
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

	public String getZyx29() {
		return zyx29;
	}

	public void setZyx29(String zyx29) {
		this.zyx29 = zyx29;
	}

	public String getCustacccount() {
		return custacccount;
	}

	public void setCustacccount(String custacccount) {
		this.custacccount = custacccount;
	}

	public String getZyx19() {
		return zyx19;
	}

	public void setZyx19(String zyx19) {
		this.zyx19 = zyx19;
	}

	public EntertainmentSub getEntertainmentSub() {
		return entertainmentSub;
	}

	public void setEntertainmentSub(EntertainmentSub entertainmentSub) {
		this.entertainmentSub = entertainmentSub;
	}

	public EntertainmentMainVO() {
		
	}

}
