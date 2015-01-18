package org.easyworld.pm.service;

import java.util.ArrayList;
import java.util.List;

import org.easyworld.pm.bean.PmModelBean;
import org.easyworld.pm.dao.PmModelDao;
import org.easyworld.pm.dao.PmPropertyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmModelService {

	@Autowired
	private PmModelDao pmModelDao;

	@Autowired
	private PmPropertyDao pmPropertyDao;

	/**
	 * save the PmModelBean object
	 * 
	 * @param pmModelBean
	 */
	public void savePmModel(PmModelBean pmModelBean) {
		this.pmModelDao.insertPmModel(pmModelBean);
	}

	/**
	 * get PmModelBean object by modelId
	 * 
	 * @param modelId
	 * @return
	 */
	public PmModelBean getModelByModelId(String modelId) {
		PmModelBean pmModelBean = new PmModelBean();
		pmModelBean.setModelId(modelId);
		List<PmModelBean> result = this.pmModelDao
				.getModelsByDefault(pmModelBean);
		if (result.size() > 0) {
			pmModelBean = result.get(0);
		}
		return pmModelBean;
	}
	
	public List<PmModelBean> getPmModelsByUserId(String userId){
		PmModelBean pmModelBean = new PmModelBean();
		pmModelBean.setCreateLoginNo(userId);
		
		List<PmModelBean> result = new ArrayList<PmModelBean>();
		result = this.pmModelDao.getModelsByDefault(pmModelBean);
		
		return result;
	}

}
