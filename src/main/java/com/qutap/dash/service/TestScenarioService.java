package com.qutap.dash.service;

import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.model.TestScenarioModel;

public interface TestScenarioService {

	Response saveTestScenarioInfo(TestScenarioModel testScenarioModel);

	TestScenarioModel getTestScenarioInfo(String testScenarioId);

	TestScenarioModel getTestScenarioInfobyName(String testScenarioName);

	List<TestScenarioModel> getTestScenarioListInfo();

	Response updateTestScenarioInfo(TestScenarioModel testScenarioModel);

	Response deleteTestScenarioInfo(String testScenarioId);

	



}
