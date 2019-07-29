package com.yonyou.component.ncservice.vo.sub.salesprop;

/**
 * 冲销明细
 * @author ChenChong
 * @since 2018-06-19
 */
public class SalesPropWriteoffVO {

	private String jkdjbh;// 借款单号
	private String jkbxr;// 借款人
	private String deptid;// 借款部门
	private String cjkybje;// 冲销原币金额
	private String cxrq;// 冲销日期
	private String sxbz;// 生效标志
	private String sxrq;// 生效日期
	
	public SalesPropWriteoffVO(){
		
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
	
}
