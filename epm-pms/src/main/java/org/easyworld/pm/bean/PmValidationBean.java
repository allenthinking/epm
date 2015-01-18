package org.easyworld.pm.bean;

public class PmValidationBean {
	private String validationId;

	private String validationType;

	private String validationStatus;

	private String validationEvent;
	
	private String validationWay;

	private String validationValue;//JSON String

	private String validationMessageId;

	private String validationDescription;
	
	private String buildType;
	
	private String projectId;
	
	public String getBuildType() {
		return buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getValidationId() {
		return validationId;
	}

	public void setValidationId(String validationId) {
		this.validationId = validationId;
	}

	public String getValidationType() {
		return validationType;
	}

	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}

	public String getValidationStatus() {
		return validationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}

	public String getValidationEvent() {
		return validationEvent;
	}

	public void setValidationEvent(String validationEvent) {
		this.validationEvent = validationEvent;
	}

	public String getValidationWay() {
		return validationWay;
	}

	public void setValidationWay(String validationWay) {
		this.validationWay = validationWay;
	}

	public String getValidationValue() {
		return validationValue;
	}

	public void setValidationValue(String validationValue) {
		this.validationValue = validationValue;
	}

	public String getValidationMessageId() {
		return validationMessageId;
	}

	public void setValidationMessageId(String validationMessageId) {
		this.validationMessageId = validationMessageId;
	}

	public String getValidationDescription() {
		return validationDescription;
	}

	public void setValidationDescription(String validationDescription) {
		this.validationDescription = validationDescription;
	}
	
	
}
