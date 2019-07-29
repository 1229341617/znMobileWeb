package com.yonyou.component.ncservice.vo.sub.repayment;

/**
 * 还款信息
 * @author ChenChong
 * @since 2018-06-21
 */
public class RepaymentItem {
	
	private String jkdjbh;// 借款单号
	private String jkbxr;// 借款人
	private String deptid;// 借款部门
	private String hkybje;// 还款金额
	private String cxrq;// 冲销日期
	private String sxbz;// 生效标志
	private String sxrq;// 生效日期
	private String szxmid;// 收支项目
	
	public RepaymentItem(){
		
	}

	public String getJkdjbh() {
		return jkdjbh;
	}

	public void setJkdjbh(String jkdjbh) {
		this.jkdjbh = jkdjbh;
	}

	public String getJkbxr() {
		return jkbxr;
	}

	public void setJkbxr(String jkbxr) {
		this.jkbxr = jkbxr;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getHkybje() {
		return hkybje;
	}

	public void setHkybje(String hkybje) {
		this.hkybje = hkybje;
	}

	public String getCxrq() {
		return cxrq;
	}

	public void setCxrq(String cxrq) {
		this.cxrq = cxrq;
	}

	public String getSxbz() {
		return sxbz;
	}

	public void setSxbz(String sxbz) {
		this.sxbz = sxbz;
	}

	public String getSxrq() {
		return sxrq;
	}

	public void setSxrq(String sxrq) {
		this.sxrq = sxrq;
	}

	public String getSzxmid() {
		return szxmid;
	}

	public void setSzxmid(String szxmid) {
		this.szxmid = szxmid;
	}
	
}
