package org.easyworld.pm.dao;

import java.util.List;
import java.util.Map;

import org.easyworld.core.persistence.mybatis.annotation.MyBatisDaoAnnotation;
import org.easyworld.pm.bean.PmModelBean;
import org.easyworld.pm.bean.PmPropertyBean;

@MyBatisDaoAnnotation
public interface PmModelDao {
	/**
	 * add the PmModelBean object to the database.
	 * @param pmModelBean
	 */
	public void insertPmModel(PmModelBean pmModelBean);
	
	/**
	 * get models with the model object
	 */
	public List<PmModelBean> getModelsByDefault(PmModelBean pmModelBean);
	
}
