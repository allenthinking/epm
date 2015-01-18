package org.easyworld.erp.service;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.easyworld.epm.core.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.easyworld.erp.entity.ErpUserBean;
import org.easyworld.erp.dao.ErpUserDao;


@Service
public class ErpUserService{
	
	@Autowired
	private ErpUserDao erpUserDao;
	
	
	
	
	public void modifyErpUser(ErpUserBean erpUserBean){
		this.erpUserDao.updateErpUserByUserBean(erpUserBean);
	}
	
	public void removeErpUser(ErpUserBean erpUserBean){
		this.erpUserDao.deleteErpUserByUserBean(erpUserBean);
	}
	
	public void removeErpUserById(String erpUserId){
		this.erpUserDao.deleteErpUserByUserId(erpUserId);
	}
	
	public void saveErpUser(ErpUserBean erpUserBean){
		this.erpUserDao.insertErpUser(erpUserBean);
	}
	
	public List<ErpUserBean> selectErpUsersByUserBean(ErpUserBean erpUserBean){
		
		List<ErpUserBean> erpUsers = new ArrayList<ErpUserBean>();
		erpUsers = this.erpUserDao.selectErpUsersByUserBean( erpUserBean);
		
		return erpUsers;
	}
	
	public List<ErpUserBean> selectErpUsersByMap(Map parameter){
		List<ErpUserBean> erpUsers = new ArrayList<ErpUserBean>();
		erpUsers = this.erpUserDao.selectErpUsersByMap(parameter);
		
		return erpUsers;
	}
	
	public ErpUserBean selectErpUserBeanById(String erpUserId){
		
		ErpUserBean erpUser = new ErpUserBean();
		
		if(StringUtils.isNotBlank(erpUserId)){
			erpUser =	this.erpUserDao.selectErpUserByUserId(erpUserId);
			return erpUser;
		}else{
			return erpUser;
		}
		
		
	}
	
}