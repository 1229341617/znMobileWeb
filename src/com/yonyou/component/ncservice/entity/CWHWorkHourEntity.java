package com.yonyou.component.ncservice.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Column;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Entity;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Id;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Table;
import com.yonyou.iuap.persistence.vo.BaseEntity;


/**
 * 项目工时信息表
 * 
 */
@Entity
@Table(name="CWH_WORKHOUR")
public class CWHWorkHourEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PK_CWH_WORKHOUR")
	private String pkCwhWorkHour;

	@Column(name="APPROVAL_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date approvalDate;

	@Column(name="PK_APPROVAL")
	private String pkApproval;

	@Column(name="BILL_STATUS")
	private String billStatus;

	@Column(name="DR")
	private String dr;

	@Column(name="END_TIME")
	private String endTime;

	@Column(name="IS_EVECTION")
	private String isEvection;

	@Column(name="PK_MILESTONE")
	private String pkMilestone;
	
	//PMP中的方法论名称
	@Column(name="STAGEOLDNAME")
	private String stageOldName;

	@Column(name="PK_ORG")
	private String pkOrg;
	
	@Column(name="REJECT_CAUSE")
	private String rejectCause;

	//项目编码
	@Column(name="PK_PROJECT")
	private String pkProject;
	
	//项目id
	@Column(name="PROJECTID")
	private String projectid;

	@Column(name="START_Time")
	private String startTime;

	@Column(name="TS")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date ts;

	@Column(name="PK_USER")
	private String pkUser;

	@Column(name="WORK_DATE")
	private String workDate;

	@Column(name="WORK_DESCRIBE")
	private String workDescribe;

	@Column(name="WORK_HOUR")
	private BigDecimal workHour;

	@Column(name="WORK_LOCATION")
	private String workLocation;
	
	//延期日期
	@Column(name="DEFER_DATE")
	private String deferDate;
	
	//项目名称
	@Column(name="PROJECTNAME_SUB")
	private String projectName;
	
	//方法论名称
	@Column(name="STAGENAME")
	private String stagename;
	
	//填报人姓名
	@Column(name="username")
	private String username;
	
	//填报人邮箱
	@Column(name="useremail")
	private String useremail;
	
	//填报人部门
	@Column(name="deptname")
	private String deptname;
	
	//审批人姓名
	@Column(name="approvator")
	private String approvator;
	
	@Column(name="autoid")
	private int autoid;
	
	//是否执行人天预算
	@Column(name="isrprequired")
	private String isrprequired;
	
	

	public CWHWorkHourEntity() {
	}

	
	public String getDeptname() {
		return deptname;
	}


	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}


	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public int getAutoid() {
		return autoid;
	}


	public void setAutoid(int autoid) {
		this.autoid = autoid;
	}


	public String getStageOldName() {
		return stageOldName;
	}


	public String getProjectid() {
		return projectid;
	}


	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}


	public void setStageOldName(String stageOldName) {
		this.stageOldName = stageOldName;
	}


	public String getApprovator() {
		return approvator;
	}


	public void setApprovator(String approvator) {
		this.approvator = approvator;
	}


	public String getDeferDate() {
		return deferDate;
	}

	public void setDeferDate(String deferDate) {
		this.deferDate = deferDate;
	}

	public String getRejectCause() {
		return rejectCause;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRejectCause(String rejectCause) {
		this.rejectCause = rejectCause;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getStagename() {
		return stagename;
	}



	public void setStagename(String stagename) {
		this.stagename = stagename;
	}



	public String getPkCwhWorkHour() {
		return pkCwhWorkHour;
	}


	public void setPkCwhWorkHour(String pkCwhWorkHour) {
		this.pkCwhWorkHour = pkCwhWorkHour;
	}


	public Date getApprovalDate() {
		return approvalDate;
	}


	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}


	public String getPkApproval() {
		return pkApproval;
	}


	public void setPkApproval(String pkApproval) {
		this.pkApproval = pkApproval;
	}


	public String getBillStatus() {
		return billStatus;
	}


	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}


	public String getDr() {
		return dr;
	}


	public void setDr(String dr) {
		this.dr = dr;
	}


	public String getIsEvection() {
		return isEvection;
	}


	public void setIsEvection(String isEvection) {
		this.isEvection = isEvection;
	}


	public String getPkMilestone() {
		return pkMilestone;
	}


	public void setPkMilestone(String pkMilestone) {
		this.pkMilestone = pkMilestone;
	}


	public String getPkOrg() {
		return pkOrg;
	}


	public void setPkOrg(String pkOrg) {
		this.pkOrg = pkOrg;
	}


	public String getPkProject() {
		return pkProject;
	}


	public void setPkProject(String pkProject) {
		this.pkProject = pkProject;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public Date getTs() {
		return ts;
	}


	public void setTs(Date ts) {
		this.ts = ts;
	}


	public String getPkUser() {
		return pkUser;
	}


	public void setPkUser(String pkUser) {
		this.pkUser = pkUser;
	}


	public String getWorkDate() {
		return workDate;
	}


	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}


	public String getWorkDescribe() {
		return workDescribe;
	}


	public void setWorkDescribe(String workDescribe) {
		this.workDescribe = workDescribe;
	}


	public BigDecimal getWorkHour() {
		return workHour;
	}


	public void setWorkHour(BigDecimal workHour) {
		this.workHour = workHour;
	}


	public String getWorkLocation() {
		return workLocation;
	}


	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	
	
	public String getIsrprequired() {
		return isrprequired;
	}


	public void setIsrprequired(String isrprequired) {
		this.isrprequired = isrprequired;
	}


	public String getMetaDefinedName(){
		return "pmsc";
	}
	public String getNamespace(){
		return "com.yonyou.pmsc.metadata";
	}

}