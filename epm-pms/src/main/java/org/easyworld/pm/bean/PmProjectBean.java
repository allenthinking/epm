package org.easyworld.pm.bean;

import java.util.Date;
import java.util.List;

public class PmProjectBean {
	private String projectId;
	private String projectName;
	private String projectPath;
	private List<PmProjectPropertyBean> projectProperties;
	
	
	public List<PmProjectPropertyBean> getProjectProperties() {
		return projectProperties;
	}


	public void setProjectProperties(List<PmProjectPropertyBean> projectProperties) {
		this.projectProperties = projectProperties;
	}

	/**
	 * real store the source path
	 */
	private String sourcePath;
	
	/**
	 * this property will be generate the java package or JSP parent path.
	 * www.org.easyworld.org - org.easyworld.
	 */
	private String projectDomain;
	private String projectDescription;
	private String createLoginNo;
	
	/**
	 * java basic package path. such as org.easyword
	 */
	private String javaBasicPackagePath;
	
	/**
	 * such as "/WEB-INF/views/jsp"
	 * @return
	 */
	private String jspBasicPath;
	
	/**
	 * project support language list;
	 */
	private List<PmProjectLanguageBean> projectLanguages;
	
	
	public List<PmProjectLanguageBean> getProjectLanguages() {
		return projectLanguages;
	}


	public void setProjectLanguages(List<PmProjectLanguageBean> projectLanguages) {
		this.projectLanguages = projectLanguages;
	}


	public String getJspBasicPath() {
		return jspBasicPath;
	}

	
	public String getSourcePath() {
		return sourcePath;
	}


	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}


	public void setJspBasicPath(String jspBasicPath) {
		this.jspBasicPath = jspBasicPath;
	}

	public String getJavaBasicPackagePath() {
		return javaBasicPackagePath;
	}

	public void setJavaBasicPackagePath(String javaBasicPackagePath) {
		this.javaBasicPackagePath = javaBasicPackagePath;
	}

	private Date createDate;

	public String getProjectDomain() {
		return projectDomain;
	}

	public void setProjectDomain(String projectDomain) {
		this.projectDomain = projectDomain;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
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

}
