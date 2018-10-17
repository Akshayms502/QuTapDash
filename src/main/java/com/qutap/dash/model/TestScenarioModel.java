package com.qutap.dash.model;

import java.io.Serializable;

public class TestScenarioModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2242211755971443861L;
	private String testScenarioId;
	private String projectId;
	private String testScenario;
	private String description;
	public String getTestScenarioId() {
		return testScenarioId;
	}
	public void setTestScenarioId(String testScenarioId) {
		this.testScenarioId = testScenarioId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTestScenario() {
		return testScenario;
	}
	public void setTestScenario(String testScenario) {
		this.testScenario = testScenario;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
