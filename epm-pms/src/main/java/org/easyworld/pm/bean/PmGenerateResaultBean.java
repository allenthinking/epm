package org.easyworld.pm.bean;

import java.util.Date;

public class PmGenerateResaultBean {

	private String codeName;

	private String codeType;

	private String generateLoginNo;

	private Date generateDate;

	private String modelId;

	private String tempalteName;

	private String sourcePath;

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getGenerateLoginNo() {
		return generateLoginNo;
	}

	public void setGenerateLoginNo(String generateLoginNo) {
		this.generateLoginNo = generateLoginNo;
	}

	public Date getGenerateDate() {
		return generateDate;
	}

	public void setGenerateDate(Date generateDate) {
		this.generateDate = generateDate;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getTempalteName() {
		return tempalteName;
	}

	public void setTempalteName(String tempalteName) {
		this.tempalteName = tempalteName;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}
}
