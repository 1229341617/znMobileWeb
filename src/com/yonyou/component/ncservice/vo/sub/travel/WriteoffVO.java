package com.yonyou.component.ncservice.vo.sub.travel;


public class WriteoffVO {
	/*private String loanbillno;//借款单号
	private String loanbilluser;//借款人
	private String loanbilldept;// 借款部门
	private String writeoffamount;//冲销原币金额
*/	
	private String jkdjbh;//借款单号
	private String psnname;//借款人
	private String deptname;// 借款部门
	private String cjkybje;//冲销原币金额
	private String cxrq;//冲销日期
	private String sxrq;//生效标记
	private String sxbz;//生效日期
	public WriteoffVO() {
		
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
