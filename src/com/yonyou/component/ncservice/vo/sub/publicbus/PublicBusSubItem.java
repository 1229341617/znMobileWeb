package com.yonyou.component.ncservice.vo.sub.publicbus;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 公车费用报销单子表合集
 * @author ChenChong
 * @since 2018-06-19
 */
public class PublicBusSubItem {

	private List<PublicBusItem> itemVOList;//公车费用
	private List<PublicHotelItem> hotelList;// 住宿费用
	private List<PublicTravelItem> travelList;// 出差补贴
	private List<PublicBusWriteoffVO> writeoffvoList;// 冲销明细
	private List<AttachmentVO> attachmentList;// 附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	public PublicBusSubItem(){
		
	}

	public List<PublicBusItem> getItemVOList() {
		return itemVOList;
	}

	public void setItemVOList(List<PublicBusItem> itemVOList) {
		this.itemVOList = itemVOList;
	}

	public List<PublicBusWriteoffVO> getWriteoffvoList() {
		return writeoffvoList;
	}

	public void setWriteoffvoList(List<PublicBusWriteoffVO> writeoffvoList) {
		this.writeoffvoList = writeoffvoList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<PublicHotelItem> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<PublicHotelItem> hotelList) {
		this.hotelList = hotelList;
	}

	public List<PublicTravelItem> getTravelList() {
		return travelList;
	}

	public void setTravelList(List<PublicTravelItem> travelList) {
		this.travelList = travelList;
	}
	
}
