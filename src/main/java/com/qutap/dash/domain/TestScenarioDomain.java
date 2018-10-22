package com.qutap.dash.domain;



import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class TestScenarioDomain implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1203441579510190923L;
	@Id
	private String testScenarioId;
	private String testScenarioName;
	private String testScenarioDescription;
	public String getTestScenarioId() {
		return testScenarioId;
	}
	public void setTestScenarioId(String testScenarioId) {
		this.testScenarioId = testScenarioId;
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
