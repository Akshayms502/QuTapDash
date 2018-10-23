package com.qutap.dash.repository;



import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.domain.TestCaseDomain;
import com.qutap.dash.domain.TestStepDomain;


public interface ExcelDataDao {

	public Response saveExcelData(TestCaseDomain testCaseDomain);

	public TestCaseDomain getTestCaseData(String testCaseId);

	
	
}
