package com.qutap.dash.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qutap.dash.commonUtils.ErrorObject;
import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.commonUtils.StatusCode;
import com.qutap.dash.commonUtils.Utils;
import com.qutap.dash.model.ProjectInfoModel;
import com.qutap.dash.model.TestScenarioModel;
import com.qutap.dash.service.ProjectInfoService;
import com.qutap.dash.service.TestScenarioService;
@RestController
@RequestMapping("/Qutap")
public class TestScenarioController {
org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoController.class);
	
	@Autowired
	TestScenarioService testScenarioService;

	@PostMapping("/saveTestScenario")
	public Response saveTestScenarioInfo(@RequestBody TestScenarioModel testScenarioModel,HttpServletRequest req) { 
		log.info("url of the application"+req.getRequestURL().toString());
		Response response=testScenarioService.saveTestScenarioInfo(testScenarioModel);
		response.setUrl(req.getRequestURL().toString());
		return response;		
	}

	
	@GetMapping("/testScenarioDataById/{testScenarioId}")
	public   @ResponseBody String getTestScenarioInfo(@PathVariable String testScenarioId,HttpServletRequest req) throws IOException {
		Response response=Utils.getResponseObject("getting TestScenario details data");
		try {
			TestScenarioModel testScenarioModel=testScenarioService.getTestScenarioInfo(testScenarioId);	
			if(testScenarioModel==null) {
				ErrorObject errorObject=Utils.getErrorResponse("TestScenarioData", "null testScenarioModel data");
				response.setErrors(errorObject);
				response.setStatus(StatusCode.FAILURE.name());
			}else {			
				response.setStatus(StatusCode.SUCCESS.name());
				response.setUrl(req.getRequestURL().toString());
				response.setData(testScenarioModel);
			}
		}catch(Exception e) {		
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return (String) Utils.getJson(response);		
	}
	
	
	@GetMapping("/testScenarioDataByName/{testScenarioName}")
	public   @ResponseBody String getProjectInfobyName(@PathVariable String testScenarioName,HttpServletRequest req) throws IOException {
		Response response=Utils.getResponseObject("getting TestScenario details data");
		try {		
			TestScenarioModel testScenarioModel=testScenarioService.getTestScenarioInfobyName(testScenarioName);
			if(testScenarioModel==null) {
				ErrorObject errorObject=Utils.getErrorResponse("TestScenarioData", "null testScenarioModel data");
				response.setErrors(errorObject);
				response.setStatus(StatusCode.FAILURE.name());
			}else {
				response.setStatus(StatusCode.SUCCESS.name());
				response.setUrl(req.getRequestURL().toString());
				response.setData(testScenarioModel);
			}
		}catch(Exception e) {			
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return (String) Utils.getJson(response);		
	}
	
	
	@GetMapping("/listOftestScenarios")
	public  @ResponseBody String gettestScenarioListInfo(HttpServletRequest req) throws IOException {
		Response response=Utils.getResponseObject("getting project details data");
		try {		
			List<TestScenarioModel> testScenarioModel=testScenarioService.getTestScenarioListInfo();
			if(testScenarioModel==null) {
				ErrorObject errorObject=Utils.getErrorResponse("TestScenarioData", "null testScenarioModel data");
				response.setErrors(errorObject);
				response.setStatus(StatusCode.FAILURE.name());
			}else {
				response.setStatus(StatusCode.SUCCESS.name());
				response.setUrl(req.getRequestURL().toString());
				response.setData(testScenarioModel);
			}
		}catch(Exception e) {		
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return (String) Utils.getJson(response);
	}

	
	@PutMapping("/updateTestScenario")
	public Response updateTestScenarioInfo(@RequestBody TestScenarioModel testScenarioModel,HttpServletRequest req) { 
		log.info("url of the application"+req.getRequestURL().toString());
		Response response=testScenarioService.updateTestScenarioInfo(testScenarioModel);
		response.setUrl(req.getRequestURL().toString());
		return response;	
	}
	
	@DeleteMapping("/deleteTestScenario/{testScenarioId}")
	public Response deleteTestScenarioInfo(@PathVariable String testScenarioId,HttpServletRequest req) { 
		log.info("url of the application"+req.getRequestURL().toString());
		Response response=testScenarioService.deleteTestScenarioInfo(testScenarioId);
		response.setUrl(req.getRequestURL().toString());
		return response;	
	}

}
