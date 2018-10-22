package com.qutap.dash.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class ModuleDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1437529900797636670L;
	@Id
	private String moduleId;
	private String moduleName;
	private List<RequirementDomain> requirementList;

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
	public List<RequirementDomain> getRequirementList() {
		return requirementList;
	}
	public void setRequirementList(List<RequirementDomain> requirementList) {
		this.requirementList = requirementList;
	}
	
	
				
}
