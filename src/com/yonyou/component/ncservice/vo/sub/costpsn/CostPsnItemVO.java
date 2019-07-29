package com.yonyou.component.ncservice.vo.sub.costpsn;

/**
 * 费用明细
 * @author ChenChong
 * @since 2018-06-14
 */
public class CostPsnItemVO {
	
	private String defitem6;// 增值税税率
	private String defitem16;// 费用总额
	private String defitem17;// 已报销金额
	private String defitem18;// 剩余可报销金额
	private String szxmid;// 收支项目
	private String tax_rate;// 税率
	private String jobid;// 产业类别
	private String vat_amount;// 报销金额
	private String tax_amount;// 税金
	private String tni_amount;// 不含税金额
	
	public CostPsnItemVO(){
		
	}

	public String getDefitem6() {
		return defitem6;
	}

	public void setDefitem6(String defitem6) {
		this.defitem6 = defitem6;
	}

	public String getDefitem16() {
		return defitem16;
	}

	public void setDefitem16(String defitem16) {
		this.defitem16 = defitem16;
	}

	public String getDefitem17() {
		return defitem17;
	}

	public void setDefitem17(String defitem17) {
		this.defitem17 = defitem17;
	}

	public String getDefitem18() {
		return defitem18;
	}

	public void setDefitem18(String defitem18) {
		this.defitem18 = defitem18;
	}

	public String getSzxmid() {
		return szxmid;
	}

	public void setSzxmid(String szxmid) {
		this.szxmid = szxmid;
	}

	public String getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getVat_amount() {
		return vat_amount;
	}

	public void setVat_amount(String vat_amount) {
		this.vat_amount = vat_amount;
	}

	public String getTax_amount() {
		return tax_amount;
	}

	public void setTax_amount(String tax_amount) {
		this.tax_amount = tax_amount;
	}

	public String getTni_amount() {
		return tni_amount;
	}

	public void setTni_amount(String tni_amount) {
		this.tni_amount = tni_amount;
	}
	
}
