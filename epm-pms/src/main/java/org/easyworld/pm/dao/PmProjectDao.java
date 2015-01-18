package org.easyworld.pm.dao;

import java.util.List;
import java.util.Map;

import org.easyworld.core.persistence.mybatis.annotation.MyBatisDaoAnnotation;
import org.easyworld.pm.bean.PmProjectBean;
import org.easyworld.pm.bean.PmProjectLanguageBean;
import org.easyworld.pm.bean.PmProjectPropertyBean;

@MyBatisDaoAnnotation
public interface PmProjectDao {
	/**
	 * select the PmProjectBean object with the properties of the PmProjectBean
	 * object
	 * 
	 * @param pmProjectBean
	 * @return
	 */
	public List<PmProjectBean> selectPmProjects(PmProjectBean pmProjectBean);
	
	
	/**
	 * select the project support language.
	 * @param projectId
	 * @return
	 */
	public List<PmProjectLanguageBean> selectPmProjectLanguagesByProjectId(String projectId);
	
	/**
	 * load the properties of the project with project id
	 * @param projectId
	 * @return
	 */
	public List<PmProjectPropertyBean> selectPmProjectProertysByProjectId(String projectId);
	
	public PmProjectLanguageBean selectPmProjectLanguagesByMap(Map parameter);
}
