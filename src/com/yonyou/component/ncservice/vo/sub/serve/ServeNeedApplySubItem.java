package com.yonyou.component.ncservice.vo.sub.serve;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 招待费报销单-需申请子表合集
 * @author ChenChong
 * @since 2018-06-14
 */
public class ServeNeedApplySubItem {

	private List<ServeNeedApplyItem> itemVOList;// 招待费明细（页签一）
	private List<ServeWriteoffVO> writeoffvoList;// 冲销明细
	private List<AttachmentVO> attachmentList;//附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public ServeNeedApplySubItem(){
		
	}

	public List<ServeNeedApplyItem> getItemVOList() {
		return itemVOList;
	}

	public void setItemVOList(List<ServeNeedApplyItem> itemVOList) {
		this.itemVOList = itemVOList;
	}

	public List<ServeWriteoffVO> getWriteoffvoList() {
		return writeoffvoList;
	}

	public void setWriteoffvoList(List<ServeWriteoffVO> writeoffvoList) {
		this.writeoffvoList = writeoffvoList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
