package com.yonyou.appbase.user.entity;

public class UserInfo {

	private String memberId;
	private String name;
	private String companyName;
	private String deptName;
	private String email;
	private String avatar;
	private String unread;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnread() {
		return unread;
	}

	public void setUnread(String unread) {
		this.unread = unread;
	}

	@Override
	public String toString() {
		return "UserInfo [memberId=" + memberId + ", name=" + name
				+ ", companyName=" + companyName + ", deptName=" + deptName
				+ ", email=" + email + "]";
	}
	
	

}
