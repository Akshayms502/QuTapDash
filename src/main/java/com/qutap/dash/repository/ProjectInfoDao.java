
package com.qutap.dash.repository;

import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.domain.ProjectInfoDomain;


public interface ProjectInfoDao {

	Response saveProjectInfo(ProjectInfoDomain projectInfoDomain);

	ProjectInfoDomain getProjectInfo(String projectId);
	ProjectInfoDomain getProjectInfobyName(String pName);
	
	public List<ProjectInfoDomain> getProjectListInfo();

	Response updateProjectInfo(ProjectInfoDomain projectInfoDomain);

	Response deleteProjectInfo(String projectId);

}