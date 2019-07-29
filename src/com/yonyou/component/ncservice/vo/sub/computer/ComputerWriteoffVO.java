package com.yonyou.component.ncservice.vo.sub.computer;

/**
 * 冲销明细
 * @author ChenChong
 * @since 2018-06-14
 */
public class ComputerWriteoffVO {
	
	private String jkdjbh;// 借款单号
	private String psnname;// 借款人
	private String deptname;// 借款部门
	private String fyybje;// 费用原币金额
	
	public ComputerWriteoffVO(){
		
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

	public String getFyybje() {
		return fyybje;
	}

	public void setFyybje(String fyybje) {
		this.fyybje = fyybje;
	}
	
}
