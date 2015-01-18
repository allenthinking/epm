package org.easyworld.erp.dao;

import java.util.List;
import java.util.Map;

import org.easyworld.core.persistence.mybatis.annotation.MyBatisDaoAnnotation;
import org.easyworld.erp.entity.ErpUserBean;



@MyBatisDaoAnnotation
public interface ErpUserDao {
	
	public void insertErpUser(ErpUserBean erpUserBean);
	
	public List<ErpUserBean> selectErpUsersByUserBean(ErpUserBean erpUserBean);
	
	public List<ErpUserBean> selectErpUsersByMap(Map parameter);
	
	public ErpUserBean selectErpUserByUserId(String erpUserId);
	
	public void updateErpUserByUserBean(ErpUserBean erpUserBean);
	
	public void deleteErpUserByUserBean(ErpUserBean erpUserBean);
	
	public void deleteErpUserByUserId(String erpUserId);
}