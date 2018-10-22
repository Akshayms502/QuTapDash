package com.qutap.dash.model;

import java.io.Serializable;
import java.util.List;

public class TestScenarioModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2242211755971443861L;
	private String testScenarioId;
	private String testScenarioName;
	private String testScenarioDescription;
	private List<TestCaseModel> testCaseList;

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

	public List<TestCaseModel> getTestCaseList() {
		return testCaseList;
	}

	public void setTestCaseList(List<TestCaseModel> testCaseList) {
		this.testCaseList = testCaseList;
	}

}
