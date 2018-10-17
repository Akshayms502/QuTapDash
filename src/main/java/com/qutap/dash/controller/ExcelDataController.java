package com.qutap.dash.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qutap.dash.commonUtils.ErrorObject;
import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.commonUtils.StatusCode;
import com.qutap.dash.commonUtils.Utils;
import com.qutap.dash.model.TestCaseModel;
import com.qutap.dash.model.TestStepModel;
import com.qutap.dash.service.ExcelDataService;


@RestController
@RequestMapping("/Qutap")
public class ExcelDataController {
	
	Logger log= LoggerFactory.getLogger(ExcelDataController.class);
	
	@Autowired
	ExcelDataService excelDataService;
	
	
	@PostMapping("/excel")
	public Response readExcelData(@RequestParam("file") MultipartFile multipartFile,HttpServletRequest req) throws IOException { 
		log.info("url of the application"+req.getRequestURL().toString());
		Response response=excelDataService.readExcelData(multipartFile);
		response.setUrl(req.getRequestURL().toString());
		return response;		
	}

	
	@GetMapping("/TestcaseData/{testCaseId}")
	public @ResponseBody String getTestCaseData(@PathVariable String testCaseId, HttpServletRequest req) throws IOException {
		Response response = Utils.getResponseObject("getting testcase data");
		try {
			 TestCaseModel  testCaseModel= excelDataService.getTestCaseData(testCaseId);
			if (testCaseModel == null) {
				ErrorObject errorObject=Utils.getErrorResponse("TestCase", "null testCaseModel data");
				response.setErrors(errorObject);
				response.setStatus(StatusCode.FAILURE.name());
			} else {
				response.setStatus(StatusCode.SUCCESS.name());
				response.setUrl(req.getRequestURL().toString());
				response.setData(testCaseModel);
			}
		} catch (Exception e) {
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return (String) Utils.getJson(response);
	}

	
	@GetMapping("/testStepList/{testCaseId}")
	public  @ResponseBody String getTestStepList(@PathVariable String testCaseId,HttpServletRequest req) throws IOException {
		Response response=Utils.getResponseObject("getting project details data");
		try {
		
		List<TestStepModel> testStepModel=excelDataService.getTestStepList(testCaseId);
		if(testStepModel==null) {
			ErrorObject errorObject=Utils.getErrorResponse("TestStep", "null testStepModel data");
			response.setErrors(errorObject);
			response.setStatus(StatusCode.FAILURE.name());
		}else {
			response.setStatus(StatusCode.SUCCESS.name());
			response.setUrl(req.getRequestURL().toString());
			response.setData(testStepModel);		   	
		}
		}catch(Exception e) {			
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return (String) Utils.getJson(response);
	}
/*
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
*/

}
