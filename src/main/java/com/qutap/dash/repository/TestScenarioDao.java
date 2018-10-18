package com.qutap.dash.repository;

import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.domain.TestScenarioDomain;


public interface TestScenarioDao {

	Response saveTestScenarioInfo(TestScenarioDomain testScenarioDomain);

	TestScenarioDomain getTestScenarioInfo(String testScenarioId);

	TestScenarioDomain getTestScenarioInfobyName(String testScenarioName);

	List<TestScenarioDomain> getTestScenarioListInfo();

	Response updateTestScenarioInfo(TestScenarioDomain testScenarioDomain);

	Response deleteTestScenarioInfo(String testScenarioId);


}
