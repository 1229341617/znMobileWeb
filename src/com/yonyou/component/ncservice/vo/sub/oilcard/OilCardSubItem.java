package com.yonyou.component.ncservice.vo.sub.oilcard;

import java.util.List;

import com.yonyou.component.ncservice.vo.sub.AttachmentVO;

/**
 * 油卡充值申请单子集合集
 * @author ChenChong
 * @since 2018-06-29
 */
public class OilCardSubItem {

	private List<OilCardItemVO> itemVOList;// 详细信息
	private List<AttachmentVO> attachmentList;// 附件
	private String imgURL;//影像地址

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public OilCardSubItem(){
		
	}

	public List<OilCardItemVO> getItemVOList() {
		return itemVOList;
	}

	public void setItemVOList(List<OilCardItemVO> itemVOList) {
		this.itemVOList = itemVOList;
	}

	public List<AttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
