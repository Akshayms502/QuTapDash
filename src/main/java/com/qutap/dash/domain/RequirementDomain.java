package com.qutap.dash.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class RequirementDomain implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1019240821095658694L;
	@Id
	private String requirementId;
	private String requirementName;
	private String requirementCases;
	private String requirementDescription;
	private List<TestScenarioDomain> testScenarioList;
	
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
	public String getRequirementDescription() {
		return requirementDescription;
	}
	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}
	public List<TestScenarioDomain> getTestScenarioList() {
		return testScenarioList;
	}
	public void setTestScenarioList(List<TestScenarioDomain> testScenarioList) {
		this.testScenarioList = testScenarioList;
	}
	

}
