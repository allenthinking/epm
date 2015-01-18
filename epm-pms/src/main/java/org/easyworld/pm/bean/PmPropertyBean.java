package org.easyworld.pm.bean;

import java.util.Date;
import java.util.List;

public class PmPropertyBean {

	private String propertyId;

	private String propertyName;
	
	private String propertyValue;
	
	private String propertyType;
	
	private String propertyDataType;
	
	private String propertySize;
	
	private String propertyJavaType;
	
	private String propertySqlType;
	
	private String propertyDescription;
	
	//input,radio,checkbox,
	private String propertyHtmlType;
	

	private String createLoginNo;

	private Date createDate;
	
	private String dbColumnName;
	
	private String dbColumnType;
	
	private String htmlDisplayName;
	
	private String htmlElementName;

	private String javaPropertyName;
	
	private String javaPropertyNameUpper;
	
	private String primaryType;
	
	private String displayType; //00: it will be used to display the property in the model.
	
	private String remark;
	
	public String getHtmlDisplayName() {
		return htmlDisplayName;
	}

	public void setHtmlDisplayName(String htmlDisplayName) {
		this.htmlDisplayName = htmlDisplayName;
	}

	private List<PmPropertyLanguageBean> languages;
	
	private List<PmPropertyValidationBean> validations;
	
	private List<PmPropertyEventBean> events;


	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public List<PmPropertyEventBean> getEvents() {
		return events;
	}

	public void setEvents(List<PmPropertyEventBean> events) {
		this.events = events;
	}

	public List<PmPropertyValidationBean> getValidations() {
		return validations;
	}

	public void setValidations(List<PmPropertyValidationBean> validations) {
		this.validations = validations;
	}

	public String getPropertyHtmlType() {
		return propertyHtmlType;
	}

	public void setPropertyHtmlType(String propertyHtmlType) {
		this.propertyHtmlType = propertyHtmlType;
	}

	public List<PmPropertyLanguageBean> getLanguages() {
		return languages;
	}

	public void setLanguages(List<PmPropertyLanguageBean> languages) {
		this.languages = languages;
	}

	public String getDbColumnType() {
		return dbColumnType;
	}

	public void setDbColumnType(String dbColumnType) {
		this.dbColumnType = dbColumnType;
	}

	public String getJavaPropertyName() {
		return javaPropertyName;
	}

	public void setJavaPropertyName(String javaPropertyName) {
		this.javaPropertyName = javaPropertyName;
	}

	public String getPrimaryType() {
		return primaryType;
	}

	public void setPrimaryType(String primaryType) {
		this.primaryType = primaryType;
	}

	public String getJavaPropertyNameUpper() {
		return javaPropertyNameUpper;
	}

	public void setJavaPropertyNameUpper(String javaPropertyNameUpper) {
		this.javaPropertyNameUpper = javaPropertyNameUpper;
	}

	public String getPropertyDataType() {
		return propertyDataType;
	}

	public void setPropertyDataType(String propertyDataType) {
		this.propertyDataType = propertyDataType;
	}

	public String getPropertySize() {
		return propertySize;
	}

	public void setPropertySize(String propertySize) {
		this.propertySize = propertySize;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	
	public String getDbColumnName() {
		return dbColumnName;
	}

	public void setDbColumnName(String dbColumnName) {
		this.dbColumnName = dbColumnName;
	}

	public String getHtmlElementName() {
		return htmlElementName;
	}

	public void setHtmlElementName(String htmlElementName) {
		this.htmlElementName = htmlElementName;
	}


	public String getPropertyJavaType() {
		return propertyJavaType;
	}

	public void setPropertyJavaType(String propertyJavaType) {
		this.propertyJavaType = propertyJavaType;
	}

	public String getPropertySqlType() {
		return propertySqlType;
	}

	public void setPropertySqlType(String propertySqlType) {
		this.propertySqlType = propertySqlType;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
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
