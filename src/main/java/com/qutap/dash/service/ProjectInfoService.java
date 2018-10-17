package com.qutap.dash.service;

import java.util.List;

import com.qutap.dash.CommonUtils.Response;
import com.qutap.dash.model.ProjectInfoModel;


public interface ProjectInfoService {

	Response saveProjectInfo(ProjectInfoModel projectInfoModel) ;
	
	public ProjectInfoModel getProjectInfo(String projectId);
	public ProjectInfoModel getProjectInfobyName(String projectId);

	public List<ProjectInfoModel> getProjectListInfo();

	Response updateProjectInfo(ProjectInfoModel projectInfoModel);

	Response deleteProjectInfo(String projectId);

	 

}