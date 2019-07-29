package com.yonyou.component.ncservice.vo.sub.costpsn;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 费用报销单（个人）的子表合集
 * @author ChenChong
 * @since 2018-06-14
 */
public class CostPsnSubItem {
	
	private List<CostPsnItemVO> itemVOList;// 费用明细
	private List<CostPsnWriteoffVO> writeoffvoList;// 冲销明细
	private List<AttachmentVO> attachmentList;// 附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	
	public CostPsnSubItem(){
		
	}

	public List<CostPsnItemVO> getItemVOList() {
		return itemVOList;
	}

	public void setItemVOList(List<CostPsnItemVO> itemVOList) {
		this.itemVOList = itemVOList;
	}

	public List<CostPsnWriteoffVO> getWriteoffvoList() {
		return writeoffvoList;
	}

	public void setWriteoffvoList(List<CostPsnWriteoffVO> writeoffvoList) {
		this.writeoffvoList = writeoffvoList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
