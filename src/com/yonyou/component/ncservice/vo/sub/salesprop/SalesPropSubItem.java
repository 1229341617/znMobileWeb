package com.yonyou.component.ncservice.vo.sub.salesprop;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 销售宣传费用报销单子集合集
 * @author ChenChong
 * @since 2018-06-19
 */
public class SalesPropSubItem {

	private List<SalesPropItem> itemVOList;// 销售宣传费用
	private List<SalesPropWriteoffVO> writeoffvoList;// 冲销明细
	private List<AttachmentVO> attachmentList;// 附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public SalesPropSubItem(){
		
	}

	public List<SalesPropItem> getItemVOList() {
		return itemVOList;
	}

	public void setItemVOList(List<SalesPropItem> itemVOList) {
		this.itemVOList = itemVOList;
	}

	public List<SalesPropWriteoffVO> getWriteoffvoList() {
		return writeoffvoList;
	}

	public void setWriteoffvoList(List<SalesPropWriteoffVO> writeoffvoList) {
		this.writeoffvoList = writeoffvoList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
