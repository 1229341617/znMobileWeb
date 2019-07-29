package com.yonyou.component.ncservice.vo.sub.benefit;

/**
 * 冲销明细
 * @author ChenChong
 * @since 2018-06-14
 */
public class BenefitWriteoffVO {
	private String jkdjbh;// 借款单号
	private String jkbxr;// 申请人
	private String deptid;// 申请部门
	private String cjkybje;// 申请金额
	private String szxmid;// 收支项目
	private String cxrq;// 申请日期
	private String sxrq;// 生效日期
	private String sxbz;// 生效标志
	
	public BenefitWriteoffVO(){
		
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

	public String getCjkybje() {
		return cjkybje;
	}

	public void setCjkybje(String cjkybje) {
		this.cjkybje = cjkybje;
	}

	public String getSzxmid() {
		return szxmid;
	}

	public void setSzxmid(String szxmid) {
		this.szxmid = szxmid;
	}

	public String getCxrq() {
		return cxrq;
	}

	public void setCxrq(String cxrq) {
		this.cxrq = cxrq;
	}

	public String getSxrq() {
		return sxrq;
	}

	public void setSxrq(String sxrq) {
		this.sxrq = sxrq;
	}

	public String getSxbz() {
		return sxbz;
	}

	public void setSxbz(String sxbz) {
		this.sxbz = sxbz;
	}
	
}
