package org.easyworld.pm.service;

import java.util.List;

import org.easyworld.pm.bean.PmProjectBean;
import org.easyworld.pm.bean.PmProjectLanguageBean;
import org.easyworld.pm.bean.PmProjectPropertyBean;
import org.easyworld.pm.dao.PmProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmProjectService {

	@Autowired
	private PmProjectDao pmProjectDao;

	/**
	 * load the project information by project identify
	 * 
	 * @param projectId
	 * @return
	 */
	public PmProjectBean getPmProjectByProjectId(String projectId) {
		PmProjectBean project = new PmProjectBean();
		project.setProjectId(projectId);

		List<PmProjectBean> result = this.pmProjectDao
				.selectPmProjects(project);
		
		List<PmProjectLanguageBean> languages = this.pmProjectDao
				.selectPmProjectLanguagesByProjectId(projectId);
		List<PmProjectPropertyBean> properties = this.pmProjectDao
				.selectPmProjectProertysByProjectId(projectId);

		if (result.size() > 0) {
			project = result.get(0);
			project.setProjectLanguages(languages);
			project.setProjectProperties(properties);
		}
		return project;
	}

}
