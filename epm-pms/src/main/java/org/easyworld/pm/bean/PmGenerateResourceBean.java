package org.easyworld.pm.bean;

import java.util.List;

import freemarker.template.Configuration;

/**
 * this class store the Model detail information, those information local from database.
 * at the same time ,those information will be re-generate as the different code type.
 * @author Allen.Wang
 *
 */
public class PmGenerateResourceBean {
	private PmModelBean model;

	private PmProjectBean project;
	
	private PmPropertyBean primaryPropertyBean;

	private Configuration freeMarkerCfg;

	private List<PmPropertyBean> properties;

	private List<PmTemplateBean> templates;
	
	private PmRunTimeVariableBean runtimeVariable;
	
	private List<PmPropertyBean> languageProperties;
	
	private PmProjectCommonBean pmProjectCommonBean;

	
	public PmPropertyBean getPrimaryPropertyBean() {
		return primaryPropertyBean;
	}

	public void setPrimaryPropertyBean(PmPropertyBean primaryPropertyBean) {
		this.primaryPropertyBean = primaryPropertyBean;
	}

	public PmProjectCommonBean getPmProjectCommonBean() {
		return pmProjectCommonBean;
	}

	public void setPmProjectCommonBean(PmProjectCommonBean pmProjectCommonBean) {
		this.pmProjectCommonBean = pmProjectCommonBean;
	}

	public List<PmPropertyBean> getLanguageProperties() {
		return languageProperties;
	}

	public void setLanguageProperties(List<PmPropertyBean> languageProperties) {
		this.languageProperties = languageProperties;
	}

	public PmRunTimeVariableBean getRuntimeVariable() {
		return runtimeVariable;
	}

	public void setRuntimeVariable(PmRunTimeVariableBean runtimeVariable) {
		this.runtimeVariable = runtimeVariable;
	}

	public PmModelBean getModel() {
		return model;
	}

	public PmProjectBean getProject() {
		return project;
	}

	public void setProject(PmProjectBean project) {
		this.project = project;
	}

	public Configuration getFreeMarkerCfg() {
		return freeMarkerCfg;
	}

	public void setFreeMarkerCfg(Configuration freeMarkerCfg) {
		this.freeMarkerCfg = freeMarkerCfg;
	}

	public List<PmPropertyBean> getProperties() {
		return properties;
	}

	public void setProperties(List<PmPropertyBean> properties) {
		this.properties = properties;
	}

	public List<PmTemplateBean> getTemplates() {
		return templates;
	}

	public void setTemplates(List<PmTemplateBean> templates) {
		this.templates = templates;
	}

	public void setModel(PmModelBean model) {
		this.model = model;
	}

}
