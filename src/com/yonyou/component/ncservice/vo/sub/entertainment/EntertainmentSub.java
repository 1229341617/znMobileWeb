package com.yonyou.component.ncservice.vo.sub.entertainment;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

public class EntertainmentSub {
	private List<DetailoneVO> detailoneList;//招待费页签一
	private List<DetailtwoVO> detailtwoList;//招待费页签二
	private List<EntertainmentWriteoffVO> writeoffList;//冲销明细
	private List<AttachmentVO> attachmentList;//附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public EntertainmentSub() {
	}

	public List<DetailoneVO> getDetailoneList() {
		return detailoneList;
	}

	public void setDetailoneList(List<DetailoneVO> detailoneList) {
		this.detailoneList = detailoneList;
	}

	public List<DetailtwoVO> getDetailtwoList() {
		return detailtwoList;
	}

	public void setDetailtwoList(List<DetailtwoVO> detailtwoList) {
		this.detailtwoList = detailtwoList;
	}

	public List<EntertainmentWriteoffVO> getWriteoffList() {
		return writeoffList;
	}

	public void setWriteoffList(List<EntertainmentWriteoffVO> writeoffList) {
		this.writeoffList = writeoffList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}

}
