package com.yonyou.component.ncservice.vo.sub.travel;

public class AllowanceItemVO {
	private String allowancerule;//出差补贴标准
    private String allowancedays;//出差天数
    private String allowanceamount;//补助金额
    private String allowanceitem;//收支项目
	public AllowanceItemVO() {
	}
	public String getAllowancerule() {
		return allowancerule;
	}
	public void setAllowancerule(String allowancerule) {
		this.allowancerule = allowancerule;
	}
	public String getAllowancedays() {
		return allowancedays;
	}
	public void setAllowancedays(String allowancedays) {
		this.allowancedays = allowancedays;
	}
	public String getAllowanceamount() {
		return allowanceamount;
	}
	public void setAllowanceamount(String allowanceamount) {
		this.allowanceamount = allowanceamount;
	}
	public String getAllowanceitem() {
		return allowanceitem;
	}
	public void setAllowanceitem(String allowanceitem) {
		this.allowanceitem = allowanceitem;
	}

}
