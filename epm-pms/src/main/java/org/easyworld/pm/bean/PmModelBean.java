package org.easyworld.pm.bean;

import java.util.Date;

public class PmModelBean {
	private String modelId;
	private String modelName;
	private String modelNameUpper;
	private String modelAlias;
	private String modelAliasUper;
	
	private String modelValue;
	/**
	 * generated code store path combine the project basic path and model path.
	 * JSP is the folder style
	 * JAVA is package style
	 */
	private String modelPath;
	//sub system.
	private String subSystem;
	private String subSystemUpper;
	private String modelDescription;
	private Date createDate;
	private String createLoginNo;
	private String remark;
	
	private String tableName;
	
	private String projectId;
	
	private PmPropertyBean primaryPropertyBean;
	
	public PmPropertyBean getPrimaryPropertyBean() {
		return primaryPropertyBean;
	}

	public void setPrimaryPropertyBean(PmPropertyBean primaryPropertyBean) {
		this.primaryPropertyBean = primaryPropertyBean;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getModelNameUpper() {
		return modelNameUpper;
	}

	public void setModelNameUpper(String modelNameUpper) {
		this.modelNameUpper = modelNameUpper;
	}

	public String getSubSystemUpper() {
		return subSystemUpper;
	}

	public void setSubSystemUpper(String subSystemUpper) {
		this.subSystemUpper = subSystemUpper;
	}

	public String getModelPath() {
		return modelPath;
	}

	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}

	public String getSubSystem() {
		return subSystem;
	}

	public void setSubSystem(String subSystem) {
		this.subSystem = subSystem;
	}

	public String getModelValue() {
		return modelValue;
	}

	public void setModelValue(String modelValue) {
		this.modelValue = modelValue;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelDescription() {
		return modelDescription;
	}

	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateLoginNo() {
		return createLoginNo;
	}

	public void setCreateLoginNo(String createLoginNo) {
		this.createLoginNo = createLoginNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getModelAlias() {
		return modelAlias;
	}

	public void setModelAlias(String modelAlias) {
		this.modelAlias = modelAlias;
	}

	public String getModelAliasUper() {
		return modelAliasUper;
	}

	public void setModelAliasUper(String modelAliasUper) {
		this.modelAliasUper = modelAliasUper;
	}
}
