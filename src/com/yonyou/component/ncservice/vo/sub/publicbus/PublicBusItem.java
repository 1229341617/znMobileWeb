package com.yonyou.component.ncservice.vo.sub.publicbus;

/**
 * 公车费用
 * @author ChenChong
 * @since 2018-06-19
 */
public class PublicBusItem {
	
	private String defitem10;// 汽车档案
	private String szxmid;// 收支项目
	private String defitem1;// 出发日期
	private String defitem6;// 增值税税率
	private String tax_rate;// 税率
	private String tax_amount;// 税金
	private String vat_amount;// 报销金额
	private String tni_amount;// 不含税金额
	private String fphm;// 发票号码
	
	public PublicBusItem(){
		
	}

	public String getSzxmid() {
		return szxmid;
	}

	public void setSzxmid(String szxmid) {
		this.szxmid = szxmid;
	}

	public String getDefitem1() {
		return defitem1;
	}

	public void setDefitem1(String defitem1) {
		this.defitem1 = defitem1;
	}

	public String getVat_amount() {
		return vat_amount;
	}

	public void setVat_amount(String vat_amount) {
		this.vat_amount = vat_amount;
	}

	public String getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
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

	public String getDefitem10() {
		return defitem10;
	}

	public void setDefitem10(String defitem10) {
		this.defitem10 = defitem10;
	}

	public String getDefitem6() {
		return defitem6;
	}

	public void setDefitem6(String defitem6) {
		this.defitem6 = defitem6;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}
	
}
