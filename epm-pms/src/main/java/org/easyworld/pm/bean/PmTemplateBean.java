package org.easyworld.pm.bean;

import java.util.Date;

public class PmTemplateBean {

	private String templateId;

	private String templateName;

	private String templatePath;

	// JSP,JAVA,JAVASCRIPT,SQL
	private String templateType;

	private String createLoginNo;

	private Date createDate;

	private String remark;

	private String templateFileName;

	private String sourceType;
	
	private String sourceOutputPath;
	
	public String getSourceOutputPath() {
		return sourceOutputPath;
	}

	public void setSourceOutputPath(String sourceOutputPath) {
		this.sourceOutputPath = sourceOutputPath;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getTemplateFileName() {
		return templateFileName;
	}

	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getCreateLoginNo() {
		return createLoginNo;
	}

	public void setCreateLoginNo(String createLoginNo) {
		this.createLoginNo = createLoginNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
