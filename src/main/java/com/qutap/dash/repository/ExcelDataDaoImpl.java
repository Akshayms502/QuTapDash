package com.qutap.dash.repository;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.commonUtils.StatusCode;
import com.qutap.dash.commonUtils.Utils;
import com.qutap.dash.domain.ProjectInfoDomain;
import com.qutap.dash.domain.RequirementDomain;
import com.qutap.dash.domain.TestCaseDomain;
import com.qutap.dash.domain.TestScenario;
import com.qutap.dash.domain.TestStepDomain;
import com.qutap.dash.domain.TestSuite;


@Repository
@Transactional
public class ExcelDataDaoImpl implements ExcelDataDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	org.slf4j.Logger log= LoggerFactory.getLogger(ExcelDataDaoImpl.class);

	@Override
	public Response saveTestStepData(TestStepDomain testStepDomainData) {
		Response response=Utils.getResponseObject("Adding testStep Details");
		try {
		mongoTemplate.insert(testStepDomainData,"testStep");
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(testStepDomainData);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}

	@Override
	public Response saveTestcaseData(TestCaseDomain testCaseDomainData) {
		Response response=Utils.getResponseObject("Adding testcase Details");
		try {
		mongoTemplate.insert(testCaseDomainData,"testCase");
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(testCaseDomainData);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}
}
