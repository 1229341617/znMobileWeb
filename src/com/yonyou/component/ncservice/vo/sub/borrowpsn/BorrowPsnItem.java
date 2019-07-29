package com.yonyou.component.ncservice.vo.sub.borrowpsn;

/**
 * 借款金额
 * @author ChenChong
 * @since 2018-06-29
 */
public class BorrowPsnItem {
	private String szxmid;// 收支项目
	private String amount;// 借款金额
	
	public BorrowPsnItem(){
		
	}

	public String getSzxmid() {
		return szxmid;
	}

	public void setSzxmid(String szxmid) {
		this.szxmid = szxmid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
