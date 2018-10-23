package com.qutap.dash.repository;



import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.commonUtils.StatusCode;
import com.qutap.dash.commonUtils.Utils;
import com.qutap.dash.domain.TestCaseDomain;
import com.qutap.dash.domain.TestStepDomain;


@Repository
@Transactional
public class ExcelDataDaoImpl implements ExcelDataDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	org.slf4j.Logger log= LoggerFactory.getLogger(ExcelDataDaoImpl.class);

	@Override
	public Response saveExcelData(TestCaseDomain testCaseDomainData) {
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
	
	@Override
	public 	TestCaseDomain getTestCaseData(String testCaseId) {
		try {
			return mongoTemplate.findById(testCaseId, TestCaseDomain.class);
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	
	}

