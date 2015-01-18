package org.easyworld.pm.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easyworld.epm.core.utils.IdentitiesUtils;
import org.easyworld.epm.core.utils.StringUtils;
import org.easyworld.pm.bean.PmModelPropertyBean;
import org.easyworld.pm.bean.PmPropertyBean;
import org.easyworld.pm.bean.PmPropertyLanguageBean;
import org.easyworld.pm.bean.PmPropertyValidationBean;
import org.easyworld.pm.service.PmPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/pm/property")
public class PmPropertyController {

	@Autowired
	private PmPropertyService pmPropertyService;

	@ModelAttribute
	public PmPropertyBean getPmPropertyBean(
			@RequestParam(required = false) String pmPropertyBeanId) {
		if (StringUtils.isNotBlank(pmPropertyBeanId)) {
			return this.pmPropertyService.getPropertyById(pmPropertyBeanId);
		} else {
			return new PmPropertyBean();
		}
	}

	@RequestMapping(value = "savePmProperty")
	public String savePmProperty(HttpServletRequest request,
			HttpServletResponse response, PmPropertyBean pmPropertyBean) {
		pmPropertyBean.setPropertyId(IdentitiesUtils.generateDateAndRandom(6));
		this.pmPropertyService.addPmProperty(pmPropertyBean);

		return "";
	}

	@RequestMapping(value = "matchCountry")
	public String matchCountry(HttpServletRequest request,
			HttpServletResponse response, PmPropertyBean pmPropertyBean) {
		this.pmPropertyService.getAllCountryMoney();

		return "";
	}

	@RequestMapping(value = "savePmProeprtyBeanForm")
	public String pmPropoertySaveForm(HttpServletRequest request,
			HttpServletResponse resonse, PmPropertyBean pmPropertyBean) {

		return "/web/pm/property/savePmPropertyForm";
	}

	@RequestMapping(value = "addPmProertyBeanWihtAjax", method = RequestMethod.GET)
	public @ResponseBody PmPropertyBean addPmProertyBeanWihtAjax(
			@RequestParam("modelId") String modelId,
			@RequestParam("displayName") String displayName,
			@RequestParam("propertyDescription") String propertyDescription,
			@RequestParam("propertySize") String propertySize,
			@RequestParam("propertyType") String propertyType,
			@RequestParam("primaryType") String primaryType,
			@RequestParam("displayType") String displayType,
			@RequestParam("htmlType") String propertyHtmlType,
			PmPropertyBean pmPropertyBean) {

		String propertyId = IdentitiesUtils.generateString(50);
		
		String projectId = "1";//need to get from the session
		String propertyName = StringUtils.removeBlank(displayName);
		pmPropertyBean.setPropertyName(propertyName);
		
		pmPropertyBean.setPropertyId(propertyId);
		pmPropertyBean.setPropertyHtmlType(propertyHtmlType);
		pmPropertyBean.setCreateDate(new Date());
		pmPropertyBean.setCreateLoginNo("1");
		pmPropertyBean.setPropertyType(propertyType);
		pmPropertyBean.setPropertySize(propertySize);
		
		PmModelPropertyBean modelPropery = new PmModelPropertyBean();
		modelPropery.setMpRelNo(IdentitiesUtils.generateString(50));
		modelPropery.setPropertyId(propertyId);
		modelPropery.setModelId(modelId);
		modelPropery.setProjectId(projectId);
	

		this.pmPropertyService.savePmProperty(pmPropertyBean, modelPropery);

		return pmPropertyBean;
	}

	@RequestMapping(value = "modifyPmProertyTypeWihtAjax", method = RequestMethod.GET)
	public @ResponseBody PmPropertyBean modifyPmProertyTypeWihtAjax(
			@RequestParam("propertyId") String propertyId,
			@RequestParam("propertyHtmlType") String propertyHtmlType) {

		PmPropertyBean pmPropertyBean = new PmPropertyBean();
		pmPropertyBean.setPropertyId(propertyId);
		pmPropertyBean.setPropertyHtmlType(propertyHtmlType);
		this.pmPropertyService.modifyProperty(pmPropertyBean);

		return pmPropertyBean;
	}

	@RequestMapping(value = "loadPropertyBasicViewWithAjax", method = RequestMethod.GET)
	public @ResponseBody PmPropertyBean loadPropertyBasicViewWithAjax(
			@RequestParam("propertyId") String propertyId,
			PmPropertyBean pmPropertyBean) {
		pmPropertyBean = this.pmPropertyService.getPropertyById(propertyId);
		String propertyName = pmPropertyBean.getPropertyName();
		String uncapitalize = StringUtils.uncapitalize(propertyName);
		String dbColumnName = StringUtils.underlineConvertCamel(propertyName);

		pmPropertyBean.setHtmlElementName(uncapitalize);
		pmPropertyBean.setDbColumnName(dbColumnName);
		return pmPropertyBean;
	}

	@RequestMapping(value = "modifyPropertyDisplayNameWithAjax", method = RequestMethod.GET)
	public @ResponseBody PmPropertyLanguageBean modifyPropertyDisplayNameWithAjax(
			@RequestParam("propertyId") String propertyId,
			@RequestParam("propertyDisplayName") String propertyDisplayName) {
		PmPropertyLanguageBean pmPropertyLanguageBean = new PmPropertyLanguageBean();
		pmPropertyLanguageBean.setPropertyId(propertyId);
		pmPropertyLanguageBean.setLanguageValue(propertyDisplayName);
		pmPropertyLanguageBean = this.pmPropertyService
				.saveProprtyLanguageByBean(pmPropertyLanguageBean);

		return pmPropertyLanguageBean;
	}

	@RequestMapping(value = "loadPropertyValidationWithAjax", method = RequestMethod.GET)
	public @ResponseBody List<PmPropertyValidationBean> loadPmPropertyValidations(
			@RequestParam("propertyId") String propertyId) {
		List<PmPropertyValidationBean> validations = new ArrayList<PmPropertyValidationBean>();
		validations = this.pmPropertyService.getPropertyValidationsByProertyId(propertyId);
		return validations;
	}
	
	

	/**
	 * manage the property validation page
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "managerPropertyValidationPage")
	public String managePropertyOfValidation(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String modelId = request.getParameter("modelId");
		
		
		return "";
	}
}
