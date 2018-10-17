package com.qutap.dash.domain;

import java.util.ArrayList;

public class TestExecution {

	private String exeFlag;
	private String requirementId;
	private String testSuiteName;
	private TestCaseDomain testCaseList;
	private String actualResult;
	private String execStatus;
	public String getExeFlag() {
		return exeFlag;
	}
	public void setExeFlag(String exeFlag) {
		this.exeFlag = exeFlag;
	}
	public String getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}
	public String getTestSuiteName() {
		return testSuiteName;
	}
	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}
	public TestCaseDomain getTestCaseList() {
		return testCaseList;
	}
	public void setTestCaseList(TestCaseDomain testCaseList) {
		this.testCaseList = testCaseList;
	}
	public String getActualResult() {
		return actualResult;
	}
	public void setActualResult(String actualResult) {
		this.actualResult = actualResult;
	}
	public String getExecStatus() {
		return execStatus;
	}
	public void setExecStatus(String execStatus) {
		this.execStatus = execStatus;
	}
	
	
	
}
