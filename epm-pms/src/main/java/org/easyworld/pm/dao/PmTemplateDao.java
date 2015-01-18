package org.easyworld.pm.dao;

import java.util.List;
import java.util.Map;

import org.easyworld.core.persistence.mybatis.annotation.MyBatisDaoAnnotation;
import org.easyworld.pm.bean.PmProjectBean;
import org.easyworld.pm.bean.PmTemplateBean;

@MyBatisDaoAnnotation
public interface PmTemplateDao {
	public List<PmTemplateBean> selectTemplatesByProject(Map paramter);
}
