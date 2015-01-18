package org.easyworld.pm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easyworld.pm.bean.PmValidationBean;
import org.easyworld.pm.service.PmValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pm/validation")
public class PmValidationController {

	@Autowired
	public PmValidationService pmValidationService;

	@RequestMapping(value = "validationManagementPage")
	public String validationManagementPage(HttpServletRequest request,
			HttpServletResponse reponse, Model model) {
		String projectId = request.getParameter("projectId");
		List<PmValidationBean> projectValidations = this.pmValidationService
				.loadProjectValidations(projectId);
		model.addAttribute("validtions", projectValidations);
		return "/web/pm/validation/validationManagementPage";
	}
}
