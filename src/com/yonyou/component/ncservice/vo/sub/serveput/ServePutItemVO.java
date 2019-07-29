package com.yonyou.component.ncservice.vo.sub.serveput;

/**
 * 详细信息
 * @author ChenChong
 * @since 2018-06-29
 */
public class ServePutItemVO {

	private String amount;// 金额
	private String max_amount;// 允许报销最大金额
	
	public ServePutItemVO(){
		
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMax_amount() {
		return max_amount;
	}

	public void setMax_amount(String max_amount) {
		this.max_amount = max_amount;
	}
	
}
