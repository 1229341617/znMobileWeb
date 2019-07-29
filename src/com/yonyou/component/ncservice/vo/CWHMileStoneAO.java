package com.yonyou.component.ncservice.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.yonyou.component.ncservice.entity.CWHWorkHourEntity;


public class CWHMileStoneAO {
	
	private String pkmilestone;//里程碑主键
	
	private String stagename;
	
	private String projectName;
	
	private String projectid;
	//计划人天
	private String PV;
	//实际标准人天
	private String EV;
	//百分比
	private String CPI;//CPI=EV/PV
	//剩余人天
	private String CV;//CV=PV-EV
	
	private String isrprequired;
	
	public void setPECC(String pv,String ev){
		this.PV = pv;
		this.EV = ev;
		this.CPI =(new BigDecimal(ev).divide(new BigDecimal(pv), 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).toString().concat("%"); 
		this.CV = new BigDecimal(pv).subtract( new BigDecimal(ev)).toString();
		
	}
	
	List<CWHWorkHourEntity> cwhWorkHourEntityList = new ArrayList<CWHWorkHourEntity>();
	
	public CWHMileStoneAO(CWHWorkHourEntity cwh){
		this.setProjectid(cwh.getProjectid());
		this.setPkmilestone(cwh.getPkMilestone());
		this.setStagename(cwh.getStagename());
		this.setProjectName(cwh.getProjectName());
		this.setIsrprequired(cwh.getIsrprequired());
	}
	
	
	public CWHMileStoneAO() {
		// TODO 自动生成的构造函数存根
	}


	public String getIsrprequired() {
		return isrprequired;
	}


	public void setIsrprequired(String isrprequired) {
		this.isrprequired = isrprequired;
	}


	public String getPV() {
		return PV;
	}


	public void setPV(String pV) {
		PV = pV;
	}


	public String getEV() {
		return EV;
	}


	public void setEV(String eV) {
		EV = eV;
	}


	public String getCPI() {
		return CPI;
	}


	public void setCPI(String cPI) {
		CPI = cPI;
	}


	public String getCV() {
		return CV;
	}


	public void setCV(String cV) {
		CV = cV;
	}
	
	
	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public void setDate(CWHWorkHourEntity cwh){
		cwhWorkHourEntityList.add(cwh);
	}
	public String getPkmilestone() {
		return pkmilestone;
	}
	public void setPkmilestone(String pkmilestone) {
		this.pkmilestone = pkmilestone;
	}
	public String getStagename() {
		return stagename;
	}
	public void setStagename(String stagename) {
		this.stagename = stagename;
	}
	public List<CWHWorkHourEntity> getCwhWorkHourEntityList() {
		return cwhWorkHourEntityList;
	}
	public void setCwhWorkHourEntityList(
			List<CWHWorkHourEntity> cwhWorkHourEntityList) {
		this.cwhWorkHourEntityList = cwhWorkHourEntityList;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	
}
