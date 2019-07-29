package com.yonyou.component.feedback.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Column;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Entity;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Id;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Table;
import com.yonyou.iuap.persistence.vo.BaseEntity;

/**
 * @author: lugl9
 * @description:
 * @date: Created in 下午2:45 2018/2/24
 * @modified by:
 */
@Entity
@Table(name = "feedback")
public class Feedback extends BaseEntity{
	private static final long serialVersionUID = 1L;

	/**
	 * 反馈id
	 */
	@Id
	@Column(name = "pk_feedback")
	private String pkFeedback;

	/**
	 * 反馈人
	 */
	@Column(name = "askperson")
	private String askperson;

	@Column(name = "askpersonname")
	private String askpersonname;

	/**
	 * 反馈内容
	 */
	@Column(name = "askcontent")
	private String askcontent;

	/**
	 * 反馈时间
	 */
	@Column(name = "asktime")
	private String asktime;

	/**
	 * 回复时间
	 */
	@Column(name = "replytime")
	private String replytime;

	/**
	 * 可见类型(0.私有  1.公有)
	 */
	@Column(name = "visibletype")
	private String visibletype;

	/**
	 * 回复内容
	 */
	@Column(name = "replycontent")
	private String replycontent;

	/**
	 * 排序
	 */
	@Column(name = "publicorder")
	private String publicorder;

	/**
	 * 问题类型id
	 */
	@Column(name = "pk_question_type")
	private String pkQuestionType;

	/**
	 * 问题类型名称
	 */
	@Column(name = "question_type_name")
	private String questionTypeName;

	/**
	 * 附件id
	 */
	@Column(name = "pk_feedback_attachement")
	private String pkFeedbackAttachement;

	/**
	 * 状态(1.已回复未阅读，2.未回复，3.已阅)
	 */
	@Column(name = "readstatus")
	private String readstatus;

	@Column(name = "ts")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date ts;

	@Column(name = "dr")
	private String dr;

	/**
	 * 是否发布(0.否  1.是)
	 */
	@Column(name = "publish")
	private String publish;

	public String getPkFeedback() {
		return pkFeedback;
	}

	public void setPkFeedback(String pkFeedback) {
		this.pkFeedback = pkFeedback;
	}

	public String getAskperson() {
		return askperson;
	}

	public void setAskperson(String askperson) {
		this.askperson = askperson;
	}

	public String getAskcontent() {
		return askcontent;
	}

	public void setAskcontent(String askcontent) {
		this.askcontent = askcontent;
	}

	public String getAsktime() {
		return asktime;
	}

	public void setAsktime(String asktime) {
		this.asktime = asktime;
	}

	public String getReplytime() {
		return replytime;
	}

	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}

	public String getVisibletype() {
		return visibletype;
	}

	public void setVisibletype(String visibletype) {
		this.visibletype = visibletype;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public String getPublicorder() {
		return publicorder;
	}

	public void setPublicorder(String publicorder) {
		this.publicorder = publicorder;
	}

	public String getPkQuestionType() {
		return pkQuestionType;
	}

	public void setPkQuestionType(String pkQuestionType) {
		this.pkQuestionType = pkQuestionType;
	}

	public String getPkFeedbackAttachement() {
		return pkFeedbackAttachement;
	}

	public void setPkFeedbackAttachement(String pkFeedbackAttachement) {
		this.pkFeedbackAttachement = pkFeedbackAttachement;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public String getDr() {
		return dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

	public String getReadstatus() {
		return readstatus;
	}

	public void setReadstatus(String readstatus) {
		this.readstatus = readstatus;
	}

	public String getAskpersonname() {
		return askpersonname;
	}

	public void setAskpersonname(String askpersonname) {
		this.askpersonname = askpersonname;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getQuestionTypeName() {
		return questionTypeName;
	}

	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}

	@Override
	public String getMetaDefinedName() {
		return "upesn";
	}

	@Override
	public String getNamespace() {
		return "metadata";
	}

}
