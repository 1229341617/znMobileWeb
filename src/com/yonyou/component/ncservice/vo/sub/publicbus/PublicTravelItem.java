package com.yonyou.component.ncservice.vo.sub.publicbus;

/**
 * 出差补贴
 * @author ChenChong
 * @since 2018-06-20
 */
public class PublicTravelItem {
	
	private String defitem11;// 出差补差标准
	private String defitem9;// 出差天数
	private String szxmid;// 收支项目
	private String vat_amount;// 补助金额
	
	public PublicTravelItem(){
		
	}

	public String getDefitem11() {
		return defitem11;
	}

	public void setDefitem11(String defitem11) {
		this.defitem11 = defitem11;
	}

	public String getDefitem9() {
		return defitem9;
	}

	public void setDefitem9(String defitem9) {
		this.defitem9 = defitem9;
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
