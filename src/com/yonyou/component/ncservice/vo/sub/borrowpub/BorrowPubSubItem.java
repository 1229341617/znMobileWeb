package com.yonyou.component.ncservice.vo.sub.borrowpub;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 借款单（对公）子集合集
 * @author ChenChong
 * @since 2018-06-29
 */
public class BorrowPubSubItem {

	private List<BorrowPubItem> itemVOList;// 借款金额
	private List<AttachmentVO> attachmentList;//附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	public BorrowPubSubItem(){
		
	}

	public List<BorrowPubItem> getItemVOList() {
		return itemVOList;
	}

	public void setItemVOList(List<BorrowPubItem> itemVOList) {
		this.itemVOList = itemVOList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
