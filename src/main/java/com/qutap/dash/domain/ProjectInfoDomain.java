package com.qutap.dash.domain;


import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projectInfo")
public class ProjectInfoDomain {
    @Id
	private String projectId;
	private String projectName;
	private String projDescri;
	
	
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

	public String getProjDescri() {
		return projDescri;
	}

	public void setProjDescri(String projDescri) {
		this.projDescri = projDescri;
	}

	

//	public ArrayList<Requirement> getRequirList() {
//		return requirList;
//	}
//
//	public void setRequirList(ArrayList<Requirement> requirList) {
//		this.requirList = requirList;
//	}

	
	
	
	
	
}
