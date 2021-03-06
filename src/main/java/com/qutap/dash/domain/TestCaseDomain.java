package com.qutap.dash.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.qutap.dash.model.TestStepModel;

@Document(collection="testCase")
public class TestCaseDomain  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 492713766521382860L;
	@Id
	private String testCaseId;
	private String testCaseName;
	private String testCaseDesciption;
	private String testCaseCategory;
	private String testCasePriority;
	private String testCaseTag;
	private String PositiveOrNegative;
	private List<TestStepDomain> testStepList;

	

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

	public String getTestCaseTag() {
		return testCaseTag;
	}
	public void setTestCaseTag(String testCaseTag) {
		this.testCaseTag = testCaseTag;
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
	public String getPositiveOrNegative() {
		return PositiveOrNegative;
	}
	public void setPositiveOrNegative(String positiveOrNegative) {
		PositiveOrNegative = positiveOrNegative;
	}
	public List<TestStepDomain> getTestStepList() {
		return testStepList;
	}
	public void setTestStepList(List<TestStepDomain> testStepList) {
		this.testStepList = testStepList;
	}

	
}
