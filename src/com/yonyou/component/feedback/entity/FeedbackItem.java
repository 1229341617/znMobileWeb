package com.yonyou.component.feedback.entity;

import com.yonyou.iuap.persistence.jdbc.framework.annotation.Column;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Entity;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Id;
import com.yonyou.iuap.persistence.jdbc.framework.annotation.Table;
import com.yonyou.iuap.persistence.vo.BaseEntity;

/**
 * @author: lugl9
 * @description:
 * @date: Created in 上午11:17 2018/3/5
 * @modified by:
 */
@Entity
@Table(name = "feedback")
public class FeedbackItem extends BaseEntity{
	private static final long serialVersionUID = 1L;

	/**
	 * 反馈id
	 */
	@Id
	@Column(name = "pk_feedback")
	private String pkFeedback;

	/**
	 * 反馈内容
	 */
	@Column(name = "askcontent")
	private String askcontent;

	/**
	 * 回复内容
	 */
	@Column(name = "replycontent")
	private String replycontent;

	/**
	 * 回复时间
	 */
	@Column(name = "replytime")
	private String replytime;

	/**
	 * 提问时间
	 */
	@Column(name = "asktime")
	private String asktime;

	/**
	 * 问题类型名称
	 */
	@Column(name = "question_type_name")
	private String questionTypeName;

	public String getPkFeedback() {
		return pkFeedback;
	}

	public void setPkFeedback(String pkFeedback) {
		this.pkFeedback = pkFeedback;
	}

	public String getAskcontent() {
		return askcontent;
	}

	public void setAskcontent(String askcontent) {
		this.askcontent = askcontent;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public String getReplytime() {
		return replytime;
	}

	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}

	public String getAsktime() {
		return asktime;
	}

	public void setAsktime(String asktime) {
		this.asktime = asktime;
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
