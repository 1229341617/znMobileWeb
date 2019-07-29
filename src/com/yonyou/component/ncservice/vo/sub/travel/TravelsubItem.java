package com.yonyou.component.ncservice.vo.sub.travel;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

public class TravelsubItem {
	private List<TrafficItemVO> trafficItemList;//交通
	private List<HotelItemVO> hotelItemList;//住宿
	private List<AllowanceItemVO> allowanceItemVOList;//补贴
	private List<WriteoffVO> writeoffList;//冲销
	private List<AttachmentVO> attachmentList;//附件
	private String imgURL;//影像地址
	
	public List<TrafficItemVO> getTrafficItemList() {
		return trafficItemList;
	}

	public void setTrafficItemList(List<TrafficItemVO> trafficItemList) {
		this.trafficItemList = trafficItemList;
	}

	public List<HotelItemVO> getHotelItemList() {
		return hotelItemList;
	}

	public void setHotelItemList(List<HotelItemVO> hotelItemList) {
		this.hotelItemList = hotelItemList;
	}

	public List<AllowanceItemVO> getAllowanceItemVOList() {
		return allowanceItemVOList;
	}

	public void setAllowanceItemVOList(List<AllowanceItemVO> allowanceItemVOList) {
		this.allowanceItemVOList = allowanceItemVOList;
	}

	public List<WriteoffVO> getWriteoffList() {
		return writeoffList;
	}

	public void setWriteoffList(List<WriteoffVO> writeoffList) {
		this.writeoffList = writeoffList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public TravelsubItem() {
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

}
