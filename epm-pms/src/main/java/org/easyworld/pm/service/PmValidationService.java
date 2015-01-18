package org.easyworld.pm.service;

import java.util.ArrayList;
import java.util.List;

import org.easyworld.pm.bean.PmValidationBean;
import org.easyworld.pm.dao.PmValidationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmValidationService {

	@Autowired
	private PmValidationDao pmValidationDao;
	
	
	/**
	 * load the project of validations with project id
	 * @param projectId
	 * @return
	 */
	public List<PmValidationBean> loadProjectValidations(String projectId){
		
		List<PmValidationBean> validations = new ArrayList<PmValidationBean>();
		
		validations = this.pmValidationDao.selectValidationsByProjectId(projectId);
		
		return validations;
	}
	
}
