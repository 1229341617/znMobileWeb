package com.yonyou.component.ncservice.vo.sub.publicbus;

/**
 * 冲销明细
 * @author ChenChong
 * @since 2018-06-19
 */
public class PublicBusWriteoffVO {

	private String jkdjbh;// 借款单号
	private String jkbxr;// 借款人
	private String deptid;// 借款部门
	private String cjkybje;// 冲销金额
	private String fyybje;// 费用原币金额
	private String cxrq;// 冲销日期
	private String sxrq;// 生效日期
	
	public PublicBusWriteoffVO(){
		
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

	public String getSxrq() {
		return sxrq;
	}

	public void setSxrq(String sxrq) {
		this.sxrq = sxrq;
	}

	public String getFyybje() {
		return fyybje;
	}

	public void setFyybje(String fyybje) {
		this.fyybje = fyybje;
	}
	
}
