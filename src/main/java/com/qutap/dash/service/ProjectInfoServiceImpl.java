package com.qutap.dash.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qutap.dash.CommonUtils.Response;
import com.qutap.dash.controller.ProjectInfoController;
import com.qutap.dash.domain.ProjectInfoDomain;
import com.qutap.dash.model.ProjectInfoModel;
import com.qutap.dash.repository.ProjectInfoDao;

@Service
public class ProjectInfoServiceImpl implements ProjectInfoService{

	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoServiceImpl.class);

	
	@Autowired
	ProjectInfoDao projectInfoDao;

	
}
