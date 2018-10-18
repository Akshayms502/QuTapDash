package com.qutap.dash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.domain.ProjectInfoDomain;
import com.qutap.dash.domain.TestScenarioDomain;
import com.qutap.dash.model.ProjectInfoModel;
import com.qutap.dash.model.TestScenarioModel;
import com.qutap.dash.repository.ProjectInfoDao;
import com.qutap.dash.repository.TestScenarioDao;

@Service
public class TestScenarioServiceImpl implements TestScenarioService {

	
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoServiceImpl.class);

	@Autowired
TestScenarioDao  testScenarioDao;

	@Override
	public Response saveTestScenarioInfo(TestScenarioModel testScenarioModel) {
		try {
			TestScenarioDomain testScenarioDomain=new TestScenarioDomain();
			BeanUtils.copyProperties(testScenarioModel, testScenarioDomain);
			testScenarioDomain.setRequirementId(UUID.randomUUID().toString());
			Response response=testScenarioDao.saveTestScenarioInfo(testScenarioDomain);
			return response;
			}catch (Exception e) {	
				log.info(e.getMessage());
			}
			return null;
	}

	@Override
	public TestScenarioModel getTestScenarioInfo(String testScenarioId) {
		try {
			TestScenarioModel testScenarioModel=new TestScenarioModel();
			TestScenarioDomain testScenarioDomain=testScenarioDao.getTestScenarioInfo(testScenarioId);	
			BeanUtils.copyProperties(testScenarioDomain, testScenarioModel);	
			return testScenarioModel;
			}catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

	@Override
	public TestScenarioModel getTestScenarioInfobyName(String testScenarioName) {
		try {
			TestScenarioModel testScenarioModel=new TestScenarioModel();
			TestScenarioDomain testScenarioDomain=testScenarioDao.getTestScenarioInfobyName(testScenarioName);
			BeanUtils.copyProperties(testScenarioDomain, testScenarioModel);
			return testScenarioModel;
			}catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

	@Override
	public List<TestScenarioModel> getTestScenarioListInfo() {
		try {
			List<TestScenarioModel> testScenarioModelList=new ArrayList<TestScenarioModel>();
			List<TestScenarioDomain> testScenarioDomainList=testScenarioDao.getTestScenarioListInfo();
			for(TestScenarioDomain testScenarioDomain:testScenarioDomainList)
			{
				TestScenarioModel testScenarioModel=new TestScenarioModel();
				 BeanUtils.copyProperties(testScenarioDomain, testScenarioModel);
				 testScenarioModelList.add(testScenarioModel);
			}
			 return testScenarioModelList;
		 }catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	
	}

	@Override
	public Response updateTestScenarioInfo(TestScenarioModel testScenarioModel) {
		try {
			TestScenarioDomain testScenarioDomain=new TestScenarioDomain();
			BeanUtils.copyProperties(testScenarioModel, testScenarioDomain);
			Response response=testScenarioDao.updateTestScenarioInfo(testScenarioDomain);
			return response;
			}catch (Exception e) {	
				log.info(e.getMessage());
			}return null;
	}

	@Override
	public Response deleteTestScenarioInfo(String testScenarioId) {
		try {			
			Response response=testScenarioDao.deleteTestScenarioInfo(testScenarioId);
			return response;
		}catch (Exception e) {	
				log.info(e.getMessage());
		}
		return null;
	}

}
