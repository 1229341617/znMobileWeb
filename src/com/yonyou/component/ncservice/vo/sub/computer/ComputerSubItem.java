package com.yonyou.component.ncservice.vo.sub.computer;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 电脑补贴报销单子表集合
 * @author ChenChong
 * @since 2018-06-14
 */
public class ComputerSubItem {
	
	private List<ComputerItemVO> itemVOList;// 电脑信息
	private List<ComputerWriteoffVO> writeoffvoList;// 冲销明细
	private List<AttachmentVO> attachmentList;//附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	
	public ComputerSubItem(){
		
	}

	public List<ComputerItemVO> getItemVOList() {
		return itemVOList;
	}

	public void setItemVOList(List<ComputerItemVO> itemVOList) {
		this.itemVOList = itemVOList;
	}

	public List<ComputerWriteoffVO> getWriteoffvoList() {
		return writeoffvoList;
	}

	public void setWriteoffvoList(List<ComputerWriteoffVO> writeoffvoList) {
		this.writeoffvoList = writeoffvoList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
