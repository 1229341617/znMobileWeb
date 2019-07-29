package com.yonyou.component.ncservice.vo.sub.costclass;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 成本类报销单子表合集
 * @author ChenChong
 * @since 2018-06-19
 */
public class CostClassSubItem {
	
	private List<CostClassItem> itemVOList;// 成本确认
	private List<CostClassWriteoffVO> writeoffvoList;// 冲销明细
	private List<AttachmentVO> attachmentList;// 附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	public CostClassSubItem(){
		
	}

	public List<CostClassItem> getItemVOList() {
		return itemVOList;
	}

	public void setItemVOList(List<CostClassItem> itemVOList) {
		this.itemVOList = itemVOList;
	}

	public List<CostClassWriteoffVO> getWriteoffvoList() {
		return writeoffvoList;
	}

	public void setWriteoffvoList(List<CostClassWriteoffVO> writeoffvoList) {
		this.writeoffvoList = writeoffvoList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
