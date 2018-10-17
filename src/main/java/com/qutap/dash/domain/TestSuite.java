package com.qutap.dash.domain;



import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TestSuite")
public class TestSuite {

	private String testSuiteName;
	private String testSuiteId;
	private String testSuiteDesc;
	private ArrayList<TestCaseDomain> testCaseList;
	
	public String getTestSuiteName() {
		return testSuiteName;
	}
	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}
	public String getTestSuiteId() {
		return testSuiteId;
	}
	public void setTestSuiteId(String testSuiteId) {
		this.testSuiteId = testSuiteId;
	}
	public String getTestSuiteDesc() {
		return testSuiteDesc;
	}
	public void setTestSuiteDesc(String testSuiteDesc) {
		this.testSuiteDesc = testSuiteDesc;
	}
	
	public ArrayList<TestCaseDomain> getTestCaseList() {
		return testCaseList;
	}
	public void setTestCaseList(ArrayList<TestCaseDomain> testCaseList) {
		this.testCaseList = testCaseList;
	}
	
}
