package org.easyworld.pm.bean;

import java.util.List;

public class PmRunTimeVariableBean {
	private String generateLanguageKey;

	private List<PmPropertyLanguageBean> generatePropertyLanguage;

	public String getGenerateLanguageKey() {
		return generateLanguageKey;
	}

	public void setGenerateLanguageKey(String generateLanguageKey) {
		this.generateLanguageKey = generateLanguageKey;
	}

	public List<PmPropertyLanguageBean> getGeneratePropertyLanguage() {
		return generatePropertyLanguage;
	}

	public void setGeneratePropertyLanguage(
			List<PmPropertyLanguageBean> generatePropertyLanguage) {
		this.generatePropertyLanguage = generatePropertyLanguage;
	}

}
