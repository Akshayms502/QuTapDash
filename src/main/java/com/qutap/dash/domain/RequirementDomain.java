package com.qutap.dash.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="RequirmentInfo")
public class RequirementDomain {
	
	@Id
	private String requirementId;
	private String moduleId;
	private String requirementName;
	private String requirementCases;
	private String requirDescri;
	
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
