package org.easyworld.pm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easyworld.pm.bean.PmTemplateBean;
import org.easyworld.pm.dao.PmTemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmTemplateService {
	@Autowired
	private PmTemplateDao pmTemplateDao;
	
	/**
	 * load the templates by project id
	 * @param projectId
	 * @return
	 */
	public List<PmTemplateBean> loadTemplateByProjectId(String projectId){
		List<PmTemplateBean> templates = new ArrayList<PmTemplateBean>();
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("projectId", projectId);
		templates = this.pmTemplateDao.selectTemplatesByProject(parameter);
		return templates;
	}
}
