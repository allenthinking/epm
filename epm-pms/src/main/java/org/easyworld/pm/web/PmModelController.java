package org.easyworld.pm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easyworld.epm.core.utils.StringUtils;
import org.easyworld.pm.bean.PmModelBean;
import org.easyworld.pm.bean.PmPropertyBean;
import org.easyworld.pm.service.PmModelService;
import org.easyworld.pm.service.PmPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping(value = "/pm/model")
public class PmModelController {

	@Autowired
	private PmPropertyService pmPropertyService;
	
	@Autowired
	private PmModelService pmModelService;
	
	
	@ModelAttribute
	public PmModelBean getPmModelBean(
			@RequestParam(required = false) String pmModelBeanId) {
		if (StringUtils.isNotBlank(pmModelBeanId)) {
			return this.pmModelService.getModelByModelId(pmModelBeanId);
		} else {
			return new PmModelBean();
		}
	}
	
	
	@RequestMapping(value = "savePmModel")
	public String savePmModel(){
		System.out.println("Hello Spring MVC Controller");
		return "/web/module/index";
	}
	
	
	@RequestMapping("mamagementPmModel")
	public String managementPmModel(HttpServletRequest request,
			HttpServletResponse response,Model model){
		String userId = "1";
		List<PmModelBean> models = this.pmModelService.getPmModelsByUserId(userId);
		model.addAttribute("models", models);
		return "/web/pm/model/modelManagementPage";
	}
	
	@RequestMapping("viewPmModel")
	public String viewPmModel(HttpServletRequest request,
			HttpServletResponse response,Model model){
		String modelId = request.getParameter("modelId");
		this.pmModelService.getModelByModelId(modelId);
		List<PmPropertyBean> properties = this.pmPropertyService.getPropertiesByModel(modelId);
		
		return "/web/pm/module/viewManagementPage";
	}
	
	@RequestMapping("editPmModelForm")
	public String editPmModelForm(HttpServletRequest request,
			HttpServletResponse response,Model model,PmModelBean pmModelBean){
		String modelId = request.getParameter("pmModelBeanId");
		pmModelBean = this.pmModelService.getModelByModelId(modelId);
		List<PmPropertyBean> properties = this.pmPropertyService.getPropertiesByModel(modelId);
		model.addAttribute("properties",properties);
		model.addAttribute("model",pmModelBean);
		return "/web/pm/model/editPmModelForm";
	}
	
	
	@RequestMapping("savePmModelForm")
	public String savePmModelForm(HttpServletRequest request,
			HttpServletResponse response,Model model,PmModelBean pmModelBean){

		model.addAttribute("pmModelBean", pmModelBean);
		
		return "/web/pm/model/savePmModelForm";
	}
	
	
	@RequestMapping("listPmModels")
	public String listPmModels(HttpServletRequest request,
			HttpServletResponse response,Model model){
		String modelId = request.getParameter("modelId");
		this.pmModelService.getModelByModelId(modelId);
		List<PmPropertyBean> properties = this.pmPropertyService.getPropertiesByModel(modelId);
		
		model.addAttribute("properties", properties);
		return "/web/pm/model/editPmModelForm";
	}
	
	
	@RequestMapping("generatePmModel")
	public String generateModel(HttpServletRequest request,
			HttpServletResponse response,Model model){
		String modelId = request.getParameter("modelId");
		this.pmModelService.getModelByModelId(modelId);
		List<PmPropertyBean> properties = this.pmPropertyService.getPropertiesByModel(modelId);
		
		return "/web/pm/module/viewManagementPage";
	}
}
