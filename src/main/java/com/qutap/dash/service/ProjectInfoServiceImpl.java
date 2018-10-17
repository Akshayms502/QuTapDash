package com.qutap.dash.service;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.controller.ProjectInfoController;
import com.qutap.dash.domain.ProjectInfoDomain;
import com.qutap.dash.model.ProjectInfoModel;
import com.qutap.dash.repository.ProjectInfoDao;


@Service
public class ProjectInfoServiceImpl implements ProjectInfoService{
	
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoServiceImpl.class);

	@Autowired
	ProjectInfoDao projectInfoDao;

	@Override
	public Response saveProjectInfo(ProjectInfoModel projectInfoModel) {	
		try {
		ProjectInfoDomain projectInfoDomain=new ProjectInfoDomain();
		BeanUtils.copyProperties(projectInfoModel, projectInfoDomain);
		Response response=projectInfoDao.saveProjectInfo(projectInfoDomain);
		return response;
		}catch (Exception e) {	
			log.info(e.getMessage());
		}
		return null;
	}
	
	@Override
	public ProjectInfoModel getProjectInfo(String projectId) {
		try {
		ProjectInfoModel projectInfoModel=new ProjectInfoModel();
		ProjectInfoDomain projectInfoDomain=projectInfoDao.getProjectInfo(projectId);	
		BeanUtils.copyProperties(projectInfoDomain, projectInfoModel);	
		return projectInfoModel;
		}catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}
	
	@Override
	public ProjectInfoModel getProjectInfobyName(String projectName) {
		try {
		ProjectInfoModel projectInfoModel=new ProjectInfoModel();
		ProjectInfoDomain projectInfoDomain=projectInfoDao.getProjectInfobyName(projectName);
		BeanUtils.copyProperties(projectInfoDomain, projectInfoModel);
		return projectInfoModel;
		}catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public List<ProjectInfoModel> getProjectListInfo() {
		try {
			List<ProjectInfoModel> projectInfoModelList=new ArrayList<ProjectInfoModel>();
			List<ProjectInfoDomain> projectInfoDomainList=projectInfoDao.getProjectListInfo();
			for(ProjectInfoDomain projectInfoDomain:projectInfoDomainList)
			{
				 ProjectInfoModel projectInfoModel=new ProjectInfoModel();
				 BeanUtils.copyProperties(projectInfoDomain, projectInfoModel);
				 projectInfoModelList.add(projectInfoModel);
			}
			 return projectInfoModelList;
		 }catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	
	}

	@Override
	public Response updateProjectInfo(ProjectInfoModel projectInfoModel) {
		try {
			ProjectInfoDomain projectInfoDomain=new ProjectInfoDomain();
			BeanUtils.copyProperties(projectInfoModel, projectInfoDomain);
			Response response=projectInfoDao.updateProjectInfo(projectInfoDomain);
			return response;
			}catch (Exception e) {	
				log.info(e.getMessage());
			}return null;
	}

	@Override
	public Response deleteProjectInfo(String projectId) {
		try {
			
			Response response=projectInfoDao.deleteProjectInfo(projectId);
			return response;
		}catch (Exception e) {	
				log.info(e.getMessage());
		}
		return null;
	}

	
	
	
}