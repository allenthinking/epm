package org.easyworld.pm.dao;

import java.util.List;
import java.util.Map;

import org.easyworld.core.persistence.mybatis.annotation.MyBatisDaoAnnotation;
import org.easyworld.pm.bean.CountryPMBean;
import org.easyworld.pm.bean.PmModelPropertyBean;
import org.easyworld.pm.bean.PmPropertyBean;
import org.easyworld.pm.bean.PmPropertyEventBean;
import org.easyworld.pm.bean.PmPropertyLanguageBean;
import org.easyworld.pm.bean.PmPropertyValidationBean;

@MyBatisDaoAnnotation
public interface PmPropertyDao {
	/**
	 * add the PmPropertyBean object to the database.
	 * 
	 * @param pmPropertyBean
	 */
	public void insertPmProperty(PmPropertyBean pmPropertyBean);
	
	public void insertPmPropertyLanguageBean(PmPropertyLanguageBean pmPropertyLanguageBean);

	public void insertPmModelPropertyReletionship(PmModelPropertyBean pmModelPropertyBean);
	/**
	 * get properties by some properties of PmPropertyBean object
	 * 
	 * @param paramter
	 * @return List of PmPropertyBean object.
	 */
	public List<PmPropertyBean> getProperties(Map paramter);

	/**
	 * get properties by some properties of PmModelBean class
	 * 
	 * @param paramter
	 * @return
	 */
	public List<PmPropertyBean> getPropertiesByModel(Map paramter);

	public List<PmPropertyLanguageBean> selectPropertyLanguageByPropertyId(
			String propertyId);

	public List<CountryPMBean> getAllCountryMoney();

	public List<CountryPMBean> getAllCountryCode(Map paramter);

	/**
	 * load the property with language by model id and language key
	 * 
	 * @param Paramter
	 * @return
	 */
	public List<PmPropertyLanguageBean> selectPropertyWithLanguages(Map Paramter);
	
	public List<PmPropertyEventBean> selectPropertyEventsByPropertyId(String propertyId);

	public void insertResult(Map par);
	
	public PmPropertyBean getPropertyById(String propertyId);
	
	public void updatePmPropertyBean(PmPropertyBean pmPropertyBean);
	
	public void insertPropertyValidation(PmPropertyValidationBean pmPropertyValiationBean);
	
	public List<PmPropertyValidationBean> selectProertyValidationsByPropertyId(String propertyId);
	
	public List<PmPropertyValidationBean> selectPropertyOfValidation(String propertyId);
	
	public void insertPropertyEvent(PmPropertyEventBean event);
	
}
