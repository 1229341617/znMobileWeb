package com.yonyou.web.ncservice;
import java.util.List;
import java.util.Map;

public class BillDetailVO {
	private String[] senddate;
	private String[] total;
	private String[] bxresult;
	private String[] billno;
	private String[] billtypename;
	private String[] sender_name;
	private Map<String, Map<String, List<ChildBillDetailVO>>> childBillDetailVO;
//	List<ChildBillDetailVO> childBillDetailVO;
	public String[] getSenddate() {
		return senddate;
	}
	public void setSenddate(String[] senddate) {
		this.senddate = senddate;
	}
	public String[] getTotal() {
		return total;
	}
	public void setTotal(String[] total) {
		this.total = total;
	}
	public String[] getBxresult() {
		return bxresult;
	}
	public void setBxresult(String[] bxresult) {
		this.bxresult = bxresult;
	}
	public String[] getBillno() {
		return billno;
	}
	public void setBillno(String[] billno) {
		this.billno = billno;
	}
	public String[] getBilltypename() {
		return billtypename;
	}
	public void setBilltypename(String[] billtypename) {
		this.billtypename = billtypename;
	}
	public String[] getSender_name() {
		return sender_name;
	}
	public void setSender_name(String[] sender_name) {
		this.sender_name = sender_name;
	}
//	public List<ChildBillDetailVO> getChildBillDetailVO() {
//		return childBillDetailVO;
//	}
//	public void setChildBillDetailVO(List<ChildBillDetailVO> childBillDetailVO) {
//		this.childBillDetailVO = childBillDetailVO;
//	}
	public Map<String, Map<String, List<ChildBillDetailVO>>> getChildBillDetailVO() {
		return childBillDetailVO;
	}
	public void setChildBillDetailVO(
			Map<String, Map<String, List<ChildBillDetailVO>>> childBillDetailVO) {
		this.childBillDetailVO = childBillDetailVO;
	}
	

}
