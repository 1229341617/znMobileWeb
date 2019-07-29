package com.yonyou.component.ncservice.vo.sub.costpsn;

/**
 * 冲销明细
 * @author ChenChong
 * @since 2018-06-14
 */
public class CostPsnWriteoffVO {
	
	private String jkdjbh;// 借款单号
	private String psnname;// 借款人
	private String deptname;// 借款部门
	private String bbje;// 申请金额
	private String cxrq;// 申请日期
	private String sxrq;// 生效日期
	private String sxbz;// 生效标志
	
	public CostPsnWriteoffVO(){
		
	}

	public String getJkdjbh() {
		return jkdjbh;
	}

	public void setJkdjbh(String jkdjbh) {
		this.jkdjbh = jkdjbh;
	}

	public String getPsnname() {
		return psnname;
	}

	public void setPsnname(String psnname) {
		this.psnname = psnname;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getBbje() {
		return bbje;
	}

	public void setBbje(String bbje) {
		this.bbje = bbje;
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
