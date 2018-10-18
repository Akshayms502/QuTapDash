package com.qutap.dash.model;

import java.io.Serializable;

public class TestScenarioModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2242211755971443861L;
	private String testScenarioId;
	private String requirementId;
	private String testScenarioName;
	private String testScenarioDescription;
	public String getTestScenarioId() {
		return testScenarioId;
	}
	public void setTestScenarioId(String testScenarioId) {
		this.testScenarioId = testScenarioId;
	}
	public String getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}
	public String getTestScenarioName() {
		return testScenarioName;
	}
	public void setTestScenarioName(String testScenarioName) {
		this.testScenarioName = testScenarioName;
	}
	public String getTestScenarioDescription() {
		return testScenarioDescription;
	}
	public void setTestScenarioDescription(String testScenarioDescription) {
		this.testScenarioDescription = testScenarioDescription;
	}
	
	

}
