package com.qutap.dash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.UuidRepresentation;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.customException.ProjectInfoException;
import com.qutap.dash.domain.ProjectInfoDomain;
import com.qutap.dash.model.ProjectInfoModel;
import com.qutap.dash.repository.ProjectInfoDao;

@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

	Logger log = LoggerFactory.getLogger(ProjectInfoServiceImpl.class);

	@Autowired
	ProjectInfoDao projectInfoDao;

	@Override
	public Response saveProjectInfo(ProjectInfoModel projectInfoModel) {
		try {
			ProjectInfoDomain projectInfoDomain = new ProjectInfoDomain();
			projectInfoModel.getModuleList().stream().forEach(
					tmp->{
						tmp.setModuleId(new ObjectId().toString());
					tmp.getRequirementList().stream().forEach(temp->{
						temp.setRequirementId(new ObjectId().toString());
						temp.getTestScenarioList().stream().forEach(temps->temps.setTestScenarioId(new ObjectId().toString()));
						});					
					});		
			BeanUtils.copyProperties(projectInfoModel, projectInfoDomain);
			
			Response response = projectInfoDao.saveProjectInfo(projectInfoDomain);
			return response;
		} catch (Exception e) {
			log.error("error in saving project detail", e);
			throw new ProjectInfoException("error in saving project detail");
		}

	}

	@Override
	public ProjectInfoModel getProjectInfo(String projectId) {
		try {
			ProjectInfoModel projectInfoModel = new ProjectInfoModel();
			ProjectInfoDomain projectInfoDomain = projectInfoDao.getProjectInfo(projectId);
			BeanUtils.copyProperties(projectInfoDomain, projectInfoModel);
			return projectInfoModel;
		} catch (Exception e) {
			log.error("error in getting project detail when searching by Id", e);
			throw new ProjectInfoException("error in getting project detail when searching by Id");

		}
	}

	@Override
	public ProjectInfoModel getProjectInfobyName(String projectName) {
		try {
			ProjectInfoModel projectInfoModel = new ProjectInfoModel();
			ProjectInfoDomain projectInfoDomain = projectInfoDao.getProjectInfobyName(projectName);
			BeanUtils.copyProperties(projectInfoDomain, projectInfoModel);
			return projectInfoModel;
		} catch (Exception e) {
			log.error("error in getting project detail when searching by name", e);
			throw new ProjectInfoException("error in getting project detail when searching by Name");
		}
	}

	@Override
	public List<ProjectInfoModel> getProjectListInfo() {
		try {
			List<ProjectInfoModel> projectInfoModelList = new ArrayList<ProjectInfoModel>();
			List<ProjectInfoDomain> projectInfoDomainList = projectInfoDao.getProjectListInfo();
			for (ProjectInfoDomain projectInfoDomain : projectInfoDomainList) {
				ProjectInfoModel projectInfoModel = new ProjectInfoModel();
				BeanUtils.copyProperties(projectInfoDomain, projectInfoModel);
				projectInfoModelList.add(projectInfoModel);
			}
			return projectInfoModelList;
		} catch (Exception e) {
			log.error("error in getting list of project details", e);
			throw new ProjectInfoException("error in getting list of project details");
		}

	}

	@Override
	public Response updateProjectInfo(ProjectInfoModel projectInfoModel) {
		try {
			ProjectInfoDomain projectInfoDomain = new ProjectInfoDomain();
			BeanUtils.copyProperties(projectInfoModel, projectInfoDomain);
			Response response = projectInfoDao.updateProjectInfo(projectInfoDomain);
			return response;
		} catch (Exception e) {
			log.error("error in updating project details",e);
			throw new ProjectInfoException("error in updating project details");
		}		
	}

	@Override
	public Response deleteProjectInfo(String projectId) {
		try {

			Response response = projectInfoDao.deleteProjectInfo(projectId);
			return response;
		} catch (Exception e) {
			log.error("error in deleting project details",e);
			throw new ProjectInfoException("error in deleting project details");
		}
	}

}