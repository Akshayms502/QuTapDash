package com.qutap.dash.repository;



import com.qutap.dash.CommonUtils.Response;
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

	
	
}
