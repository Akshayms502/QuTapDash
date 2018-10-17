package com.qutap.dash.domain;



import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="testScenario")
public class TestScenario implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1203441579510190923L;
	
	@Id
	private String testScenId;
	private String testScenName;
	private String testScenarioDescription;
	
	public String getTestScenId() {
		return testScenId;
	}
	public void setTestScenId(String testScenId) {
		this.testScenId = testScenId;
	}
	public String getTestScenName() {
		return testScenName;
	}
	public void setTestScenName(String testScenName) {
		this.testScenName = testScenName;
	}
	public String getTestScenarioDescription() {
		return testScenarioDescription;
	}
	public void setTestScenarioDescription(String testScenarioDescription) {
		this.testScenarioDescription = testScenarioDescription;
	}
	
	
	
	
	
	
	
}
