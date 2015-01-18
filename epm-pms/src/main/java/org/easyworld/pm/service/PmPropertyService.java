package org.easyworld.pm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easyworld.epm.core.utils.IdentitiesUtils;
import org.easyworld.pm.bean.CountryPMBean;
import org.easyworld.pm.bean.PmModelPropertyBean;
import org.easyworld.pm.bean.PmProjectLanguageBean;
import org.easyworld.pm.bean.PmPropertyBean;
import org.easyworld.pm.bean.PmPropertyEventBean;
import org.easyworld.pm.bean.PmPropertyLanguageBean;
import org.easyworld.pm.bean.PmPropertyValidationBean;
import org.easyworld.pm.bean.PmValidationBean;
import org.easyworld.pm.dao.PmProjectDao;
import org.easyworld.pm.dao.PmPropertyDao;
import org.easyworld.pm.dao.PmValidationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmPropertyService {

	@Autowired
	private PmPropertyDao pmPropertyDao;

	@Autowired
	private PmProjectDao pmProjectDao;

	@Autowired
	private PmValidationDao pmValidationDao;

	/**
	 * add the property object
	 * 
	 * @param pmPropertyBean
	 */
	public void addPmProperty(PmPropertyBean pmPropertyBean) {
		this.pmPropertyDao.insertPmProperty(pmPropertyBean);
	}

	public void modifyProperty(PmPropertyBean pmPropertyBean) {
		this.pmPropertyDao.updatePmPropertyBean(pmPropertyBean);
	}

	public List<PmPropertyLanguageBean> findPropertyLanguagesByPropertyId(
			String propertyId) {
		List<PmPropertyLanguageBean> languages = this.pmPropertyDao
				.selectPropertyLanguageByPropertyId(propertyId);

		return languages;
	}

	/**
	 * @see org.easyworld.pm.dao.PmPropertyDao#getPropertiesByModel(Map)
	 * @param paramter
	 * @return
	 */
	public List<PmPropertyBean> getPropertiesByModel(String modelId) {

		Map<String, Object> paramter = new HashMap<String, Object>();
		paramter.put("modelId", modelId);

		List<PmPropertyBean> properties = this.pmPropertyDao
				.getPropertiesByModel(paramter);
		/*
		 * initialize the language and validation
		 */
		if (properties.size() > 0) {
			for (PmPropertyBean property : properties) {
				String properptyId = property.getPropertyId();
				List<PmPropertyLanguageBean> languages = this.pmPropertyDao
						.selectPropertyLanguageByPropertyId(properptyId);
				List<PmPropertyValidationBean> validations = this.pmPropertyDao
						.selectPropertyOfValidation(properptyId);
				property.setValidations(validations);
				property.setLanguages(languages);
			}
		}

		return properties;
	}

	public PmPropertyBean getPropertyById(String pmPropertyBeanId) {
		PmPropertyBean property = new PmPropertyBean();
		property = this.pmPropertyDao.getPropertyById(pmPropertyBeanId);

		return property;
	}

	public List<PmPropertyLanguageBean> getPropertyWithLanguage(Map paramter) {
		List<PmPropertyLanguageBean> result = this.pmPropertyDao
				.selectPropertyWithLanguages(paramter);
		return result;
	}

	public void getAllCountryMoney() {
		List<CountryPMBean> countries = this.pmPropertyDao.getAllCountryMoney();
		Map pp = new HashMap();

		int flag = 0;
		for (CountryPMBean item : countries) {
			Map rs = new HashMap();
			rs.put("country_name", item.getCountryName());

			String countryName = item.getCountryName();
			pp.put("countryName", countryName);
			List<CountryPMBean> codes = this.pmPropertyDao
					.getAllCountryCode(pp);

			if (codes.size() == 0) {
				rs.put("result_type", "0");
				rs.put("counrty_code", "counrty_code");
				rs.put("allowance_money", item.getBefMoney());

			} else if (codes.size() == 1) {
				rs.put("result_type", "1");
				rs.put("counrty_code", codes.get(0).getCountryValue()
						.substring(0, 3));
				System.out.println(codes.get(0).getCountryValue()
						.substring(0, 3)
						+ "^ ^20001101^PDAX^^^^^784^"
						+ item.getBefMoney()
						+ "^0^0^0^0^0^0^0^0^0^");
				rs.put("allowance_money", item.getBefMoney());
				flag++;
			} else if (codes.size() > 1) {
				rs.put("result_type", "2");

				rs.put("counrty_code", "2000000");
				rs.put("allowance_money", item.getBefMoney());
			}
			this.pmPropertyDao.insertResult(rs);
		}
		System.out.println("total number is " + flag);
	}

	public void insertResult(Map rs) {
		this.pmPropertyDao.insertResult(rs);
	}

	public void savePmProperty(PmPropertyBean pmPropertyBean,
			PmModelPropertyBean mpBean) {

		String projectId = mpBean.getProjectId();
		this.pmPropertyDao.insertPmProperty(pmPropertyBean);
		this.pmPropertyDao.insertPmModelPropertyReletionship(mpBean);

		PmValidationBean pmValidationBean = new PmValidationBean();
		pmValidationBean.setProjectId(projectId);
		pmValidationBean.setBuildType("00");
		pmValidationBean.setValidationStatus("00");
		List<PmValidationBean> validations = this.pmValidationDao
				.selectDefaultGenerateValidation(pmValidationBean);

		PmPropertyLanguageBean languageBean = new PmPropertyLanguageBean();
		languageBean.setPropertyId(pmPropertyBean.getPropertyId());
		languageBean.setLanguageValue(pmPropertyBean.getPropertyName());
		this.saveProprtyLanguageByBean(languageBean);
		
		this.generateValidation(pmPropertyBean, validations);
	}

	public PmPropertyLanguageBean saveProprtyLanguageByBean(
			PmPropertyLanguageBean pmPropertyLanguageBean) {
		Map parameter = new HashMap();
		parameter.put("projectId", "1");
		parameter.put("isDefault", "0");

		PmProjectLanguageBean projectLuange = this.pmProjectDao
				.selectPmProjectLanguagesByMap(parameter);
		pmPropertyLanguageBean.setLanguageKey(projectLuange.getLanguageKey());
		pmPropertyLanguageBean.setIsDefault("0");
		this.pmPropertyDao.insertPmPropertyLanguageBean(pmPropertyLanguageBean);

		return pmPropertyLanguageBean;
	}

	public void generateValidation(PmPropertyBean pmPropertyBean,
			List<PmValidationBean> validations) {

		String propertyType = pmPropertyBean.getPropertyType();
		String propertyId = pmPropertyBean.getPropertyId();
		if (propertyType.equals("0")) {// String
			for (PmValidationBean validation : validations) {
				PmPropertyValidationBean pv = new PmPropertyValidationBean();
				
				pv.setPropertyId(propertyId);
				pv.setValidationId(validation.getValidationId());
				pv.setValidationEvent("1");
				this.pmPropertyDao.insertPropertyValidation(pv);
				
			}			
		} else if (propertyType.equals("1")) {

		} else {

		}
	}

	public List<PmPropertyValidationBean> getPropertyValidationsByProertyId(
			String propertyId) {
		List<PmPropertyValidationBean> validations = new ArrayList<PmPropertyValidationBean>();
		validations = this.pmPropertyDao
				.selectProertyValidationsByPropertyId(propertyId);
		return validations;
	}
}
