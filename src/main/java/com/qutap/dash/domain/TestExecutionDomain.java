package com.qutap.dash.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


public class TestExecutionDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3881844091137034444L;
	
	private List<TestCaseDomain> testCaseDomain;
	private List<TestStepDomain> testStepDomain;
	
	public List<TestCaseDomain> getTestCaseDomain() {
		return testCaseDomain;
	}
	public void setTestCaseDomain(List<TestCaseDomain> testCaseDomain) {
		this.testCaseDomain = testCaseDomain;
	}
	public List<TestStepDomain> getTestStepDomain() {
		return testStepDomain;
	}
	public void setTestStepDomain(List<TestStepDomain> testStepDomain) {
		this.testStepDomain = testStepDomain;
	}
	
	
	
	

}
