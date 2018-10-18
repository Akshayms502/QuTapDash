package com.qutap.dash.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class ModuleDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1437529900797636670L;
	@Id
	private String moduleId;
	private String moduleName;
	private String projectId;
	private List<RequirementDomain> requirementDomain;

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
	public List<RequirementDomain> getRequirementDomain() {
		return requirementDomain;
	}
	public void setRequirementDomain(List<RequirementDomain> requirementDomain) {
		this.requirementDomain = requirementDomain;
	}
	
	
			
}
