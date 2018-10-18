package com.qutap.dash.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.qutap.dash.domain.ModuleDomain;

public class ProjectInfoModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -704552328314642587L;
	private String projectId;
	private String projectName;
	private String projectDescription;
	private List<ModuleModel> moduleModel;
	
	public List<ModuleModel> getModuleModel() {
		return moduleModel;
	}
	public void setModuleModel(List<ModuleModel> moduleModel) {
		this.moduleModel = moduleModel;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

	

}
