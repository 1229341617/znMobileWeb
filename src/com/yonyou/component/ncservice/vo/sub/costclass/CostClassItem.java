package com.yonyou.component.ncservice.vo.sub.costclass;

/**
 * 成本确认
 * @author ChenChong
 * @since 2018-06-19
 */
public class CostClassItem {

	private String szxmid;// 收支项目
	private String fphm;// 发票号码
	private String defitem6;// 增值税税率
	private String tax_amount;// 税金
	private String tax_rate;// 税率
	private String tni_amount;// 不含税金额
	private String vat_amount;// 报销金额
	private String defitem20;// 产业类别
	
	public CostClassItem(){
		
	}

	public String getSzxmid() {
		return szxmid;
	}

	public void setSzxmid(String szxmid) {
		this.szxmid = szxmid;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public String getDefitem6() {
		return defitem6;
	}

	public void setDefitem6(String defitem6) {
		this.defitem6 = defitem6;
	}

	public String getTax_amount() {
		return tax_amount;
	}

	public void setTax_amount(String tax_amount) {
		this.tax_amount = tax_amount;
	}

	public String getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
	}

	public String getTni_amount() {
		return tni_amount;
	}

	public void setTni_amount(String tni_amount) {
		this.tni_amount = tni_amount;
	}

	public String getVat_amount() {
		return vat_amount;
	}

	public void setVat_amount(String vat_amount) {
		this.vat_amount = vat_amount;
	}

	public String getDefitem20() {
		return defitem20;
	}

	public void setDefitem20(String defitem20) {
		this.defitem20 = defitem20;
	}
	
}
