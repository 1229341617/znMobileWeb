package com.yonyou.component.ncservice.vo.sub;


public class AttachmentVO {
	private String displayname;// 显示名称
	private String filename;//附件名称
	private String filetypo;// 附件类型
	private String filemgr;// 附件管理类
	private String pk_lfwfile;// 附件url
	private String pk;
	
	
	
	public AttachmentVO() {
		
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getFiletypo() {
		return filetypo;
	}
	public void setFiletypo(String filetypo) {
		this.filetypo = filetypo;
	}
	public String getFilemgr() {
		return filemgr;
	}
	public void setFilemgr(String filemgr) {
		this.filemgr = filemgr;
	}
	public String getPk_lfwfile() {
		return pk_lfwfile;
	}
	public void setPk_lfwfile(String pk_lfwfile) {
		this.pk_lfwfile = pk_lfwfile;
	}
		

}
