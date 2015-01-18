package org.easyworld.pm.bean;

public class PmProjectLanguageBean {
	
	private String projectId;
	private String languageKey;
	private String languageValue;
	private String languageAlais;
	private String isDefault;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getLanguageKey() {
		return languageKey;
	}

	public void setLanguageKey(String languageKey) {
		this.languageKey = languageKey;
	}

	public String getLanguageValue() {
		return languageValue;
	}

	public void setLanguageValue(String languageValue) {
		this.languageValue = languageValue;
	}

	public String getLanguageAlais() {
		return languageAlais;
	}

	public void setLanguageAlais(String languageAlais) {
		this.languageAlais = languageAlais;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
}
