package com.yonyou.component.ncservice.vo.sub.travel;

public class HotelItemVO {
      
      private String arrivedate;//入住日期
      private String leavedate;//离开日期
      private String ndays;//住宿天数
      private String hotelrate;//税率
      private String hoteltaxamount;//税金
      private String hotelnotaxamount;//除税金额
      private String hotelamount;//住宿费用金额
      private String hotelitem;//收支项目
      private String hoteladdvaluerate;//增值税税率
      private String invoicenum;//发票号码
      private String arriveplace;//入住地点
      
	public HotelItemVO() {
	}

	public String getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(String arrivedate) {
		this.arrivedate = arrivedate;
	}

	public String getLeavedate() {
		return leavedate;
	}

	public void setLeavedate(String leavedate) {
		this.leavedate = leavedate;
	}

	public String getNdays() {
		return ndays;
	}

	public void setNdays(String ndays) {
		this.ndays = ndays;
	}

	public String getHotelrate() {
		return hotelrate;
	}

	public void setHotelrate(String hotelrate) {
		this.hotelrate = hotelrate;
	}

	public String getHoteltaxamount() {
		return hoteltaxamount;
	}

	public void setHoteltaxamount(String hoteltaxamount) {
		this.hoteltaxamount = hoteltaxamount;
	}

	public String getHotelnotaxamount() {
		return hotelnotaxamount;
	}

	public void setHotelnotaxamount(String hotelnotaxamount) {
		this.hotelnotaxamount = hotelnotaxamount;
	}

	public String getHotelamount() {
		return hotelamount;
	}

	public void setHotelamount(String hotelamount) {
		this.hotelamount = hotelamount;
	}

	public String getHotelitem() {
		return hotelitem;
	}

	public void setHotelitem(String hotelitem) {
		this.hotelitem = hotelitem;
	}

	public String getHoteladdvaluerate() {
		return hoteladdvaluerate;
	}

	public void setHoteladdvaluerate(String hoteladdvaluerate) {
		this.hoteladdvaluerate = hoteladdvaluerate;
	}

	public String getInvoicenum() {
		return invoicenum;
	}

	public String getArriveplace() {
		return arriveplace;
	}

	public void setArriveplace(String arriveplace) {
		this.arriveplace = arriveplace;
	}

	public void setInvoicenum(String invoicenum) {
		this.invoicenum = invoicenum;
	}
   
}
