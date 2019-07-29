package com.yonyou.appbase.user.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Transient;

import com.yonyou.iuap.persistence.jdbc.framework.annotation.Column;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Entity;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.GeneratedValue;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Id;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Stragegy;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Table;
import com.yonyou.iuap.persistence.vo.BaseEntity;


/**
 * The persistent class for the sm_user database table.
 * 
 */
@Entity
@Table(name="sm_user")
public class UserEntity extends BaseEntity  {
	private static final long serialVersionUID = 1210745573396580069L;

	@Id
	@Column(name="pk_sm_user")
	@GeneratedValue(strategy=Stragegy.UUID,moudle="pk_sm_user")
	private String pkSmUser;

	@Column(name="dr")
	private String dr;

	@Column(name="effectivedate")
	private String effectivedate;

	@Column(name="email")
	private String email;

	@Column(name="expirationdate")
	private String expirationdate;

	@Column(name="mobile")
	private String mobile;

	@Column(name="officetel")
	private String officetel;

	@Column(name="organ")
	private String organ;

	@Column(name="ts")
	private Date ts;

	@Column(name="usercode")
	private String usercode;

	@Column(name="username")
	private String username;

	@Column(name="orgname")
	private String orgname;
	
	@Column(name="password")
	private String password;
	
	@Column(name="salt")
	private String salt;
	
	@Column(name="registerdate")
	private String registerdate;
	
	@Column(name="dutylevelname")
	private String dutylevelname;
	
	@Column(name = "ORGLONGNAME")
    private String orglongname;

	@Column(name = "PK_SM_ORGAN")
    private String pkSmOrgan;
    
	@Column(name = "PK_SM_PROJECT_ORGAN")
    private String pkSmProjectOrgan;
	
	@Column(name = "ISCHARGE")
    private String ischarge;
	
	private String plainPassword;
	
	@Column(name = "JOBNAME")
	private String jobName;
	
	@Column(name = "PK_SM_DEPT")
	private String pkSmDept;
	
	@Column(name = "IS_DEPT_MANAGER")
	private String isDeptManager;
	
	@Column(name = "MDM_CODE")
	private String mdmCode;
	
	@Column(name="ROLENAME")//用户角色名称
	private String rolename;
	
	@Column(name="PK_SM_ROLE")//用户角色pk
	private String pkSmRole;
	
	@Column(name="ORGSHORTNAME")
	private String orgShortName;
	
	@Column(name="ORGCODE")
	private String orgcode;
	
	
	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getPkSmRole() {
		return pkSmRole;
	}

	public void setPkSmRole(String pkSmRole) {
		this.pkSmRole = pkSmRole;
	}

	public String getOrgShortName() {
		return orgShortName;
	}

	public void setOrgShortName(String orgShortName) {
		this.orgShortName = orgShortName;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	// 不持久化到数据库，也不显示在Restful接口的属性. 
    @Transient
    public String getPlainPassword() {
        return plainPassword;
    }

    
    public String getDutylevelname() {
		return dutylevelname;
	}

	
	public String getOrglongname() {
		return orglongname;
	}


	public void setOrglongname(String orglongname) {
		this.orglongname = orglongname;
	}

	public void setDutylevelname(String dutylevelname) {
		this.dutylevelname = dutylevelname;
	}


	public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }
    
	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getPkSmUser() {
		return pkSmUser;
	}


	public void setPkSmUser(String pkSmUser) {
		this.pkSmUser = pkSmUser;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}


	public UserEntity() {
	}


	public String getDr() {
		return this.dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

	public String getEffectivedate() {
		return this.effectivedate;
	}

	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExpirationdate() {
		return this.expirationdate;
	}

	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOfficetel() {
		return this.officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getOrgan() {
		return this.organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}


	public Date getTs() {
		return this.ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	
	}
		
	public String getUsercode() {
		return this.usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getPkSmOrgan() {
		return pkSmOrgan;
	}


	public void setPkSmOrgan(String pkSmOrgan) {
		this.pkSmOrgan = pkSmOrgan;
	}


	public String getPkSmProjectOrgan() {
		return pkSmProjectOrgan;
	}


	public void setPkSmProjectOrgan(String pkSmProjectOrgan) {
		this.pkSmProjectOrgan = pkSmProjectOrgan;
	}


	public String getIscharge() {
		return ischarge;
	}


	public void setIscharge(String ischarge) {
		this.ischarge = ischarge;
	}


	public String getPkSmDept() {
		return pkSmDept;
	}

	public void setPkSmDept(String pkSmDept) {
		this.pkSmDept = pkSmDept;
	}

	public String getIsDeptManager() {
		return isDeptManager;
	}

	public void setIsDeptManager(String isDeptManager) {
		this.isDeptManager = isDeptManager;
	}

	public String getMdmCode() {
		return mdmCode;
	}

	public void setMdmCode(String mdmCode) {
		this.mdmCode = mdmCode;
	}

	public String getMetaDefinedName(){
		return "pmsc";
	}
	public String getNamespace(){
		return "com.yonyou.pmsc.metadata";
	}


}
