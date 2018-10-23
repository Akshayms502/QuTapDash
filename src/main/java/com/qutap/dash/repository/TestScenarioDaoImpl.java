package com.qutap.dash.repository;

import java.util.List;

import org.bson.Document;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.qutap.dash.commonUtils.ErrorObject;
import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.commonUtils.StatusCode;
import com.qutap.dash.commonUtils.Utils;
import com.qutap.dash.domain.ProjectInfoDomain;
import com.qutap.dash.domain.TestScenarioDomain;

@Repository
public class TestScenarioDaoImpl implements TestScenarioDao{

	
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoDaoImpl.class);
	@Autowired 
	MongoTemplate mongoTemplate;
	
	
	@Override
	public Response saveTestScenarioInfo(TestScenarioDomain testScenarioDomain) {
		Response response=Utils.getResponseObject("Adding TestScenario Details");
		try {
		mongoTemplate.insert(testScenarioDomain,"testScenario");
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(testScenarioDomain);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
		
	}

	@Override
	public TestScenarioDomain getTestScenarioInfo(String testScenarioId) {
		try {	
			return mongoTemplate.findById(testScenarioId, TestScenarioDomain.class);
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

	@Override
	public TestScenarioDomain getTestScenarioInfobyName(String testScenarioName) {
		try {
			Query query=new Query();
			query.addCriteria(Criteria.where("projectInfoDomain.moduleList.requirementList.testScenarioList.testScenarioName").is(testScenarioName));			
			return mongoTemplate.findOne(query, TestScenarioDomain.class, "projectInfo");				
		}
		catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public List<TestScenarioDomain> getTestScenarioListInfo() {
		try {
			return mongoTemplate.findAll(TestScenarioDomain.class, "testScenario");
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

	@Override
	public Response updateTestScenarioInfo(TestScenarioDomain testScenarioDomain) {
		Response response=Utils.getResponseObject("updating TestScenario Details");
		try {
			Query query=new Query(Criteria.where("testScenarioId").is(testScenarioDomain.getTestScenarioId()));
			Document doc=new Document();		
			mongoTemplate.getConverter().write(testScenarioDomain, doc);	
			Update update=new Update();
			for(String key:doc.keySet()) {		
				Object value=doc.get(key);
				if(value!=null) {
					update.set(key, value);
				}
			} 
			testScenarioDomain= mongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true), TestScenarioDomain.class);//it will return New Updated Data
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(testScenarioDomain);  
			return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}	
	}

	@Override
	public Response deleteTestScenarioInfo(String testScenarioId) {
		Response response=Utils.getResponseObject("deleting TestScenario Details");
		ErrorObject err=Utils.getErrorResponse("deleting TestScenario", "TestScenario id  not found");
		try {
			TestScenarioDomain testScenarioDomain=getTestScenarioInfo(testScenarioId);
			mongoTemplate.remove(testScenarioDomain);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(testScenarioDomain);
			return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(err);
			return response;
		}
	}

	
}
