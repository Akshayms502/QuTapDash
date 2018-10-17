package com.qutap.dash.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qutap.dash.CommonUtils.Response;
import com.qutap.dash.CommonUtils.StatusCode;
import com.qutap.dash.CommonUtils.Utils;
import com.qutap.dash.model.ModuleModel;
import com.qutap.dash.service.ModuleService;

@RestController
@RequestMapping("/Qutap")
public class ModuleContoller {
	org.slf4j.Logger log = LoggerFactory.getLogger(ProjectInfoController.class);

	@Autowired
	ModuleService moduleService;

	@PostMapping("/saveModule")
	public Response saveProjectInfo(@RequestBody ModuleModel moduleModel, HttpServletRequest req) {
		log.info("url of the application" + req.getRequestURL().toString());
		Response response = moduleService.saveModuleModel(moduleModel);
		response.setUrl(req.getRequestURL().toString());
		return response;

	}

	@GetMapping("/ModuleData/{moduleId}")
	public Object getModuleInfo(@PathVariable String moduleId, HttpServletRequest req) {
		Response response = Utils.getResponseObject("getting project details data");
		try {

			ModuleModel moduleModel = moduleService.getModuleModel(moduleId);
			if (moduleModel == null) {
				response.setStatus(StatusCode.FAILURE.name());
			} else {
				response.setStatus(StatusCode.SUCCESS.name());
				response.setUrl(req.getRequestURL().toString());
				response.setData(moduleModel);
				return Utils.getJson(response);
			}
		} catch (Exception e) {

			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return null;

	}

	@GetMapping("/ModuleData")
	public Object getProjectListInfo(HttpServletRequest req) {
		Response response = Utils.getResponseObject("getting project details data");
		try {

			List<ModuleModel> moduleModel = moduleService.getModuleListInfo();
			if (moduleModel == null) {
				response.setStatus(StatusCode.FAILURE.name());
			} else {
				response.setStatus(StatusCode.SUCCESS.name());
				response.setUrl(req.getRequestURL().toString());
				response.setData(moduleModel);
				return Utils.getJson(response);
			}
		} catch (Exception e) {

			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return null;
	}

	@PutMapping("/updateModule")
	public Response updateProjectInfo(@RequestBody ModuleModel moduleModel, HttpServletRequest req) {
		log.info("url of the application" + req.getRequestURL().toString());
		Response response = moduleService.updateModuleModel(moduleModel);
		response.setUrl(req.getRequestURL().toString());
		return response;

	}

	@DeleteMapping("/deleteModule/{moduleId}")
	public Response deleteModuleInfo(@PathVariable String moduleId, HttpServletRequest req) {
		log.info("url of the application" + req.getRequestURL().toString());
		Response response = moduleService.deleteModuleModel(moduleId);
		response.setUrl(req.getRequestURL().toString());
		return response;

	}
}
