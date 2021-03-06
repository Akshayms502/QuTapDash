package com.qutap.dash.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.qutap.dash.model.ModuleModel;

@Document(collection="projectInfo")
public class ProjectInfoDomain implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2337752672975163839L;
	@Id
	@Field("projectId")
	private String projectId;
	private String projectName;
	private String projectDescription;
	private List<ModuleDomain> moduleList;
	
	
	

	public List<ModuleDomain> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<ModuleDomain> moduleList) {
		this.moduleList = moduleList;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}	
}
