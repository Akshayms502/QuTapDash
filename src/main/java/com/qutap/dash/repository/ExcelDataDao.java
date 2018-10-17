package com.qutap.dash.repository;



import java.util.List;

import com.qutap.dash.commonUtils.*;
import com.qutap.dash.domain.ProjectInfoDomain;
import com.qutap.dash.domain.RequirementDomain;
import com.qutap.dash.domain.TestCaseDomain;
import com.qutap.dash.domain.TestExecutionDomain;
import com.qutap.dash.domain.TestScenario;
import com.qutap.dash.domain.TestStepDomain;
import com.qutap.dash.domain.TestSuite;


public interface ExcelDataDao {

	


	Response saveTestStepData(TestStepDomain testStepDomainData);

	Response saveTestcaseData(TestCaseDomain testCaseDomainData);

	TestCaseDomain getTestCaseData(String testCaseId);

	List<TestStepDomain> getTestStepList(String testCaseId);

	
	
}
