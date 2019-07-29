package com.yonyou.component.ncservice.vo.sub.common;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;
import com.yonyou.component.ncservice.vo.sub.entertainment.DetailoneVO;

public class CommonSub {
	private List<OtherCostVO> otherCostList;//其他费用
	private List<CommonWriteoffVO> writeoffList;//冲销明细
	private List<AttachmentVO> attachmentList;//附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	public CommonSub() {
		// TODO 自动生成的构造函数存根
	}
	public List<OtherCostVO> getOtherCostList() {
		return otherCostList;
	}
	public void setOtherCostList(List<OtherCostVO> otherCostList) {
		this.otherCostList = otherCostList;
	}
	public List<CommonWriteoffVO> getWriteoffList() {
		return writeoffList;
	}
	public void setWriteoffList(List<CommonWriteoffVO> writeoffList) {
		this.writeoffList = writeoffList;
	}
	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}

}
