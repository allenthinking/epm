package org.easyworld.erp.web;

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

import org.easyworld.erp.entity.ErpUserBean;
import org.easyworld.erp.service.ErpUserService;


@Controller
@RequestMapping( value= "/erp/user")
public class ErpUserController {
	
	@Autowired
	private ErpUserService erpUserService;
	
	
	@RequestMapping(value = "modifyErpUserForm")
	public String modifyErpUserBeanForm(@RequestParam(required=false) String erpUserId,HttpServletRequest request, HttpServletResponse response,Model model){
		
		ErpUserBean erpUser = new ErpUserBean();

		erpUser =	erpUserService.selectErpUserBeanById(erpUserId);
				
		model.addAttribute("erpUser", erpUser);
		
		return "web/jsp/erp/user/erpUserEditForm";
	}
	
	
	@RequestMapping(value = "modifyErpUser")
	public String modifyErpUserBean(ErpUserBean erpUserBean,HttpServletRequest request, HttpServletResponse response,Model model){
		this.erpUserService.modifyErpUser(erpUserBean);
		
		return "web/jsp/erp/user/erpUserList";
	}

	@RequestMapping(value = "removeErpUser")
	public void removeErpUserBean(ErpUserBean erpUserBean){
		this.erpUserService.removeErpUser(erpUserBean);
	}
		
	@RequestMapping(value = "removeErpUserById")
	public void removeErpUserBeanById(String erpUserId){
		this.erpUserService.removeErpUserById(erpUserId);
	}
	
	@RequestMapping(value = "saveErpUser")
	public void saveErpUserBean(ErpUserBean erpUserBean){
		this.erpUserService.saveErpUser(erpUserBean);
	}
	
	@RequestMapping(value = "queryErpUser")
	public String selectErpUserBean(ErpUserBean erpUserBean){
		
		this.erpUserService.selectErpUsersByUserBean(erpUserBean);
		
		return "web/jsp/erp/user/erpUserList";
	}
	
	@RequestMapping(value = "queryErpUserByMap")
	public String selectErpUsersByMap(Map parameter){
		this.erpUserService.selectErpUsersByMap(parameter);
		
		return "web/jsp/erp/user/erpUserList";
	}
	
	@RequestMapping(value = "queryOneErpUserById")
	public String selectErpUserBeanById(String erpUserId){
		this.erpUserService.selectErpUserBeanById(erpUserId);
		
		return "web/jsp/erp/user/erpUserList";
	}
}