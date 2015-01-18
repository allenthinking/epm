package org.easyworld.pm.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easyworld.epm.core.utils.PathUtils;
import org.easyworld.pm.bean.PmGenerateResaultBean;
import org.easyworld.pm.service.PmEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Manage how to generate code
 * @author Allen.Wang
 *
 */
@Controller
@RequestMapping("/pm/engine")
public class PmEngineConroller {

	@Autowired
	private PmEngineService pmEngineService;

	@RequestMapping("generateCode")
	public String generateCode(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String projectId = request.getParameter("projectId");
		String modelId = request.getParameter("modelId");
		try {
			System.out.println(PathUtils.currentPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pmEngineService.generate(projectId, modelId);

		return "";

	}

	@RequestMapping(value = "generateBeanCodeWithAjax", method = RequestMethod.GET)
	public @ResponseBody PmGenerateResaultBean generateBeanWithAjax(
			@RequestParam("projectId") String projectId,
			@RequestParam("modelId") String modelId) {
		PmGenerateResaultBean result = this.pmEngineService.generate(projectId, modelId);
		return result;
	}
}
