package com.qutap.dash.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class ModuleModel {
	private String moduleId;
	private String moduleName;
	private String projectId;

	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
			
}
