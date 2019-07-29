package com.yonyou.component.ncservice.vo.sub.benefit;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 公司福利报销单子表集合
 * @author ChenChong
 * @since 2018-06-14
 */
public class BenefitsubItem {
	private List<BenefitItemVO> itemVOList;// 福利费明细
	private List<BenefitWriteoffVO> writeoffvoList;// 冲销明细
	private List<AttachmentVO> attachmentList;// 附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public BenefitsubItem(){
		
	}
	
	public List<BenefitItemVO> getItemVOList() {
		return itemVOList;
	}
	public void setItemVOList(List<BenefitItemVO> itemVOList) {
		this.itemVOList = itemVOList;
	}
	public List<BenefitWriteoffVO> getWriteoffvoList() {
		return writeoffvoList;
	}
	public void setWriteoffvoList(List<BenefitWriteoffVO> writeoffvoList) {
		this.writeoffvoList = writeoffvoList;
	}
	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
