package com.qutap.dash.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class RequirementModel implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6812313138564800129L;
	private String requirementId;
	private String requirementName;
	private String requirementCases;
	private String requirDescri;
	private String moduleId;
	
	public String getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}
	public String getRequirementName() {
		return requirementName;
	}
	public void setRequirementName(String requirementName) {
		this.requirementName = requirementName;
	}
	public String getRequirementCases() {
		return requirementCases;
	}
	public void setRequirementCases(String requirementCases) {
		this.requirementCases = requirementCases;
	}
	public String getRequirDescri() {
		return requirDescri;
	}
	public void setRequirDescri(String requirDescri) {
		this.requirDescri = requirDescri;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	

}
