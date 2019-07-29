package com.yonyou.component.ncservice.vo.sub.publicbus;

/**
 * 住宿费用
 * @author ChenChong
 * @since 2018-06-20
 */
public class PublicHotelItem {

	private String szxmid;// 收支项目
	private String defitem1;// 入住日期
	private String defitem2;// 离店日期
	private String defitem9;// 住宿天数
	private String tax_rate;// 税率
	private String tax_amount;// 税金
	private String vat_amount;// 报销金额
	
	public PublicHotelItem(){
		
	}

	public String getDefitem1() {
		return defitem1;
	}

	public void setDefitem1(String defitem1) {
		this.defitem1 = defitem1;
	}

	public String getDefitem2() {
		return defitem2;
	}

	public void setDefitem2(String defitem2) {
		this.defitem2 = defitem2;
	}

	public String getDefitem9() {
		return defitem9;
	}

	public void setDefitem9(String defitem9) {
		this.defitem9 = defitem9;
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

	public String getVat_amount() {
		return vat_amount;
	}

	public void setVat_amount(String vat_amount) {
		this.vat_amount = vat_amount;
	}

	public String getSzxmid() {
		return szxmid;
	}

	public void setSzxmid(String szxmid) {
		this.szxmid = szxmid;
	}
	
}
