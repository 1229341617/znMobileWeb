package com.yonyou.component.ncservice.vo.main;

import com.yonyou.component.ncservice.vo.sub.travel.TravelsubItem;

public class TravelMainVO {
	private String djbh;//单据编号
	private String djrq;//日期
	private String jkbxr;// 报销人
	private String bbje;//金额
	private String pk_org;//报销人单位
	private String deptid;//报销人部门
	private String fydw;//费用承担单位
	private String fydwbm;//费用承担部门
	private String zyx5;//报销事由
	private TravelsubItem  billsubItemVO;//详细信息list
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
	public String getJkbxr() {
		return jkbxr;
	}
	public void setJkbxr(String jkbxr) {
		this.jkbxr = jkbxr;
	}
	public String getBbje() {
		return bbje;
	}
	public void setBbje(String bbje) {
		this.bbje = bbje;
	}
	public String getPk_org() {
		return pk_org;
	}
	public void setPk_org(String pk_org) {
		this.pk_org = pk_org;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getFydw() {
		return fydw;
	}
	public void setFydw(String fydw) {
		this.fydw = fydw;
	}
	public String getFydwbm() {
		return fydwbm;
	}
	public void setFydwbm(String fydwbm) {
		this.fydwbm = fydwbm;
	}
	public String getZyx5() {
		return zyx5;
	}
	public void setZyx5(String zyx5) {
		this.zyx5 = zyx5;
	}
	
	public TravelsubItem getBillsubItemVO() {
		return billsubItemVO;
	}
	public void setBillsubItemVO(TravelsubItem billsubItemVO) {
		this.billsubItemVO = billsubItemVO;
	}
	public TravelMainVO() {
		
	}

}
