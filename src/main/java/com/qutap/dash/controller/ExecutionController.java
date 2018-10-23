package com.qutap.dash.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.service.ExecutionService;

@RestController
@RequestMapping("/Qutap")
public class ExecutionController {
	
	Logger log = LoggerFactory.getLogger(ExecutionController.class);

	@Autowired
	ExecutionService executionService;

	
	
	@PostMapping("/execution/{testCaseId}")
	public Response executeData(@PathVariable String testCaseId, HttpServletRequest req) {
		log.info("url of the application" + req.getRequestURL().toString());
		Response response = executionService.executeData(testCaseId);
		response.setUrl(req.getRequestURL().toString());
		return response;
	}

}
