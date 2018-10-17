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

import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/Qutap")
public class ProjectInfoController {
	
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoController.class);
	
	@Autowired
	ProjectInfoService projectInfoService; 
	
	

}
