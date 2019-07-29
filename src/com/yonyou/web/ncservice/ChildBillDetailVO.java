package com.yonyou.web.ncservice;

import java.util.List;

public class ChildBillDetailVO {
	 private	String[] sender_date ;
	 private	String[] arrive_date ;
	 private	String[] sender_place ;
	 private	String[] arrive_place ;
	 private	String[] transport ;
	 private	String[] total ;
	 private List<GrandsonDetailVO> grandsonDetailVOList;
	public String[] getSender_date() {
		return sender_date;
	}
	public void setSender_date(String[] sender_date) {
		this.sender_date = sender_date;
	}
	public String[] getArrive_date() {
		return arrive_date;
	}
	public void setArrive_date(String[] arrive_date) {
		this.arrive_date = arrive_date;
	}
	public String[] getSender_place() {
		return sender_place;
	}
	public void setSender_place(String[] sender_place) {
		this.sender_place = sender_place;
	}
	public String[] getArrive_place() {
		return arrive_place;
	}
	public void setArrive_place(String[] arrive_place) {
		this.arrive_place = arrive_place;
	}
	public String[] getTransport() {
		return transport;
	}
	public void setTransport(String[] transport) {
		this.transport = transport;
	}
	public String[] getTotal() {
		return total;
	}
	public void setTotal(String[] total) {
		this.total = total;
	}
	public List<GrandsonDetailVO> getGrandsonDetailVOList() {
		return grandsonDetailVOList;
	}
	public void setGrandsonDetailVOList(List<GrandsonDetailVO> grandsonDetailVOList) {
		this.grandsonDetailVOList = grandsonDetailVOList;
	}
	 
	
	 
}
