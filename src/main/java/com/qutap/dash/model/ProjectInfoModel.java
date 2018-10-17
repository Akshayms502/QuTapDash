package com.qutap.dash.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.qutap.dash.domain.ModuleDomain;

public class ProjectInfoModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -704552328314642587L;
	private String projectId;
	private String projectName;
	private String description;
	
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

	

}
