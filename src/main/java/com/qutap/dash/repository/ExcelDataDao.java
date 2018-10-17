package com.qutap.dash.repository;



import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.domain.TestCaseDomain;
import com.qutap.dash.domain.TestStepDomain;


public interface ExcelDataDao {

	public Response saveTestStepData(TestStepDomain testStepDomainData);

	public Response saveTestcaseData(TestCaseDomain testCaseDomainData);

	public TestCaseDomain getTestCaseData(String testCaseId);

	public List<TestStepDomain> getTestStepList(String testCaseId);

	
	
}
