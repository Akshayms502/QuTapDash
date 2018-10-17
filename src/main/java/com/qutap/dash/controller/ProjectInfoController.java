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

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.commonUtils.StatusCode;
import com.qutap.dash.commonUtils.Utils;
import com.qutap.dash.model.ProjectInfoModel;
import com.qutap.dash.service.ProjectInfoService;


@RestController
@RequestMapping("/Qutap")
public class ProjectInfoController {
	
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoController.class);
	
	@Autowired
	ProjectInfoService projectInfoService;

	@PostMapping("/saveProject")
	public Response saveProjectInfo(@RequestBody ProjectInfoModel projectInfoModel,HttpServletRequest req) { 
		log.info("url of the application"+req.getRequestURL().toString());
		Response response=projectInfoService.saveProjectInfo(projectInfoModel);
		response.setUrl(req.getRequestURL().toString());
		return response;
		
	}
	
	@GetMapping("/projectDataById/{projectId}")
	public   Object getProjectInfo(@PathVariable String projectId,HttpServletRequest req) {
		Response response=Utils.getResponseObject("getting project details data");
		try {
			
			
		
		ProjectInfoModel projectInfoModel=projectInfoService.getProjectInfo(projectId);
		if(projectInfoModel==null) {
			response.setStatus(StatusCode.FAILURE.name());
		}else {
			response.setStatus(StatusCode.SUCCESS.name());
			response.setUrl(req.getRequestURL().toString());
			response.setData(projectInfoModel);
			return   Utils.getJson(response);	
		}
		}catch(Exception e) {
			
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return null;
		
	}
	@GetMapping("/projectDataByName/{projectName}")
	public   Object getProjectInfobyName(@PathVariable String projectName,HttpServletRequest req) {
		Response response=Utils.getResponseObject("getting project details data");
		try {
		 
			
		ProjectInfoModel projectInfoModel=projectInfoService.getProjectInfobyName(projectName);
		if(projectInfoModel==null) {
			response.setStatus(StatusCode.FAILURE.name());
		}else {
			response.setStatus(StatusCode.SUCCESS.name());
			response.setUrl(req.getRequestURL().toString());
			response.setData(projectInfoModel);
			return   Utils.getJson(response);	
		}
		}catch(Exception e) {
			
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return null;
		
	}
	@GetMapping("/listOfprojects")
	public  Object getProjectListInfo(HttpServletRequest req) {
		Response response=Utils.getResponseObject("getting project details data");
		try {
		
		List<ProjectInfoModel> projectInfoModel=projectInfoService.getProjectListInfo();
		if(projectInfoModel==null) {
			response.setStatus(StatusCode.FAILURE.name());
		}else {
			response.setStatus(StatusCode.SUCCESS.name());
			response.setUrl(req.getRequestURL().toString());
			response.setData(projectInfoModel);
			return   Utils.getJson(response);	
		}
		}catch(Exception e) {
			
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return null;
	}
	
	@PutMapping("/updateProject")
	public Response updateProjectInfo(@RequestBody ProjectInfoModel projectInfoModel,HttpServletRequest req) { 
		log.info("url of the application"+req.getRequestURL().toString());
		Response response=projectInfoService.updateProjectInfo(projectInfoModel);
		response.setUrl(req.getRequestURL().toString());
		return response;
		
	}
	
	@DeleteMapping("/deleteProject/{projectId}")
	public Response deleteProjectInfo(@PathVariable String projectId,HttpServletRequest req) { 
		log.info("url of the application"+req.getRequestURL().toString());
		Response response=projectInfoService.deleteProjectInfo(projectId);
		response.setUrl(req.getRequestURL().toString());
		return response;
		
	}
}