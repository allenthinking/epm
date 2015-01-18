package org.easyworld.pm.dao;

import java.util.List;

import org.easyworld.core.persistence.mybatis.annotation.MyBatisDaoAnnotation;
import org.easyworld.pm.bean.PmValidationBean;

@MyBatisDaoAnnotation
public interface PmValidationDao {
	
	public List<PmValidationBean> selectValidationsByProjectId(String projectId);
	
	public List<PmValidationBean> selectDefaultGenerateValidation(PmValidationBean pmValidationBean);
}
