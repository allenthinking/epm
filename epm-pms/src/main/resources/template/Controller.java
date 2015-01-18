package ${project.javaBasicPackagePath}.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.easyworld.epm.core.utils.StringUtils;

import ${project.javaBasicPackagePath}.entity.${model.subSystemUpper}${model.modelNameUpper}Bean;
import ${project.javaBasicPackagePath}.service.${model.subSystemUpper}${model.modelNameUpper}Service;


@Controller
@RequestMapping( value= "/${model.subSystem}/${model.subSystemUpper}${model.modelNameUpper}")
public class ${model.subSystemUpper}${model.modelNameUpper}Controller {
	
	@Autowired
	private ${model.subSystemUpper}${model.modelNameUpper}Service ${model.subSystem}${model.modelNameUpper}Service;
	
	
	@RequestMapping(value = "modify${model.subSystemUpper}${model.modelNameUpper}Form")
	public String modify${model.subSystemUpper}${model.modelNameUpper}BeanForm(@RequestParam(required=false) String ${model.subSystem}${model.modelNameUpper}Id,HttpServletRequest request, HttpServletResponse response,Model model){
		
		${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper} = new ${model.subSystemUpper}${model.modelNameUpper}Bean();

		${model.subSystem}${model.modelNameUpper} =	${model.subSystem}${model.modelNameUpper}Service.select${model.subSystemUpper}${model.modelNameUpper}BeanById(${model.subSystem}${model.modelNameUpper}Id);
				
		model.addAttribute("${model.subSystem}${model.modelNameUpper}", ${model.subSystem}${model.modelNameUpper});
		
		return "${pmProjectCommonBean.jspBasicPath}${model.subSystem}/${model.modelName}/${model.subSystem}${model.modelNameUpper}EditForm";
	}
	
	
	@RequestMapping(value = "modify${model.subSystemUpper}${model.modelNameUpper}")
	public String modify${model.subSystemUpper}${model.modelNameUpper}Bean(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean,HttpServletRequest request, HttpServletResponse response,Model model){
		this.${model.subSystem}${model.modelNameUpper}Service.modify${model.subSystemUpper}${model.modelNameUpper}(${model.subSystem}${model.modelNameUpper}Bean);
		
		return "${pmProjectCommonBean.jspBasicPath}${model.subSystem}/${model.modelName}/${model.subSystem}${model.modelNameUpper}List";
	}

	@RequestMapping(value = "remove${model.subSystemUpper}${model.modelNameUpper}")
	public void remove${model.subSystemUpper}${model.modelNameUpper}Bean(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean){
		this.${model.subSystem}${model.modelNameUpper}Service.remove${model.subSystemUpper}${model.modelNameUpper}(${model.subSystem}${model.modelNameUpper}Bean);
	}
		
	@RequestMapping(value = "remove${model.subSystemUpper}${model.modelNameUpper}ById")
	public void remove${model.subSystemUpper}${model.modelNameUpper}BeanById(String ${model.subSystem}${model.modelNameUpper}Id){
		this.${model.subSystem}${model.modelNameUpper}Service.remove${model.subSystemUpper}${model.modelNameUpper}ById(${model.subSystem}${model.modelNameUpper}Id);
	}
	
	@RequestMapping(value = "save${model.subSystemUpper}${model.modelNameUpper}")
	public void save${model.subSystemUpper}${model.modelNameUpper}Bean(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean){
		this.${model.subSystem}${model.modelNameUpper}Service.save${model.subSystemUpper}${model.modelNameUpper}(${model.subSystem}${model.modelNameUpper}Bean);
	}
	
	@RequestMapping(value = "query${model.subSystemUpper}${model.modelNameUpper}")
	public String select${model.subSystemUpper}${model.modelNameUpper}Bean(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean){
		
		this.${model.subSystem}${model.modelNameUpper}Service.select${model.subSystemUpper}${model.modelNameUpper}sBy${model.modelNameUpper}Bean(${model.subSystem}${model.modelNameUpper}Bean);
		
		return "${pmProjectCommonBean.jspBasicPath}${model.subSystem}/${model.modelName}/${model.subSystem}${model.modelNameUpper}List";
	}
	
	@RequestMapping(value = "query${model.subSystemUpper}${model.modelNameUpper}ByMap")
	public String select${model.subSystemUpper}${model.modelNameUpper}sByMap(Map parameter){
		this.${model.subSystem}${model.modelNameUpper}Service.select${model.subSystemUpper}${model.modelNameUpper}sByMap(parameter);
		
		return "${pmProjectCommonBean.jspBasicPath}${model.subSystem}/${model.modelName}/${model.subSystem}${model.modelNameUpper}List";
	}
	
	@RequestMapping(value = "queryOne${model.subSystemUpper}${model.modelNameUpper}ById")
	public String select${model.subSystemUpper}${model.modelNameUpper}BeanById(String ${model.subSystem}${model.modelNameUpper}Id){
		this.${model.subSystem}${model.modelNameUpper}Service.select${model.subSystemUpper}${model.modelNameUpper}BeanById(${model.subSystem}${model.modelNameUpper}Id);
		
		return "${pmProjectCommonBean.jspBasicPath}${model.subSystem}/${model.modelName}/${model.subSystem}${model.modelNameUpper}List";
	}
}