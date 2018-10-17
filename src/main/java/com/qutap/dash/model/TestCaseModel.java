package com.qutap.dash.model;

import java.io.Serializable;

public class TestCaseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6503807222820347515L;
	private String testCaseId;
	private String testCaseName;
	private String testCaseDesciption;
	private String testCaseCategory;
	private String testCasePriority;
	private String testCaseTag;
	private String PositiveOrNegative;
	public String getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	public String getTestCaseDesciption() {
		return testCaseDesciption;
	}
	public void setTestCaseDesciption(String testCaseDesciption) {
		this.testCaseDesciption = testCaseDesciption;
	}
	public String getTestCaseCategory() {
		return testCaseCategory;
	}
	public void setTestCaseCategory(String testCaseCategory) {
		this.testCaseCategory = testCaseCategory;
	}
	public String getTestCasePriority() {
		return testCasePriority;
	}
	public void setTestCasePriority(String testCasePriority) {
		this.testCasePriority = testCasePriority;
	}
	public String getTestCaseTag() {
		return testCaseTag;
	}
	public void setTestCaseTag(String testCaseTag) {
		this.testCaseTag = testCaseTag;
	}
	public String getPositiveOrNegative() {
		return PositiveOrNegative;
	}
	public void setPositiveOrNegative(String positiveOrNegative) {
		PositiveOrNegative = positiveOrNegative;
	}
	
	


}
