package com.yonyou.component.ncservice.vo.sub.repayment;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 还款单子表合集
 * @author ChenChong
 * @since 2018-06-21
 */
public class RepaymentSubItem {
	
	private List<RepaymentItem> itemVOList;// 还款信息
	private List<AttachmentVO> attachmentList;// 附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public RepaymentSubItem(){
		
	}

	public List<RepaymentItem> getItemVOList() {
		return itemVOList;
	}

	public void setItemVOList(List<RepaymentItem> itemVOList) {
		this.itemVOList = itemVOList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
