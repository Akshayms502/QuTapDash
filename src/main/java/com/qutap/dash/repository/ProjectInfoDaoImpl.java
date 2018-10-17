
package com.qutap.dash.repository;



import java.lang.annotation.Annotation;

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
import org.springframework.transaction.annotation.Transactional;

import com.qutap.dash.commonUtils.ErrorObject;
import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.commonUtils.StatusCode;
import com.qutap.dash.commonUtils.Utils;
import com.qutap.dash.domain.ProjectInfoDomain;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProjectInfoDaoImpl implements ProjectInfoDao{

	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoDaoImpl.class);
	@Autowired 
	MongoTemplate mongoTemplate;
	
	@Override
	public Response saveProjectInfo(ProjectInfoDomain projectInfoDomain) {
		Response response=Utils.getResponseObject("Adding project Details");
		try {
		mongoTemplate.insert(projectInfoDomain,"projectInfo");
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(projectInfoDomain);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
		
	}
	
	public ProjectInfoDomain getProjectInfo(String projectId) {
		try {
			
		
		return mongoTemplate.findById(projectId, ProjectInfoDomain.class);
		}
		catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}
	@Override
	public ProjectInfoDomain getProjectInfobyName(String projectName) {
		try {
			Query query=new Query();
			query.addCriteria(Criteria.where("projectName").is(projectName));
			
		return mongoTemplate.findOne(query, ProjectInfoDomain.class, "projectInfo");
				
		}
		catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}
	public List<ProjectInfoDomain> getProjectListInfo() {
		try {
		return mongoTemplate.findAll(ProjectInfoDomain.class, "projectInfo");
		}
		catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}
	
	@Override
	public Response updateProjectInfo(ProjectInfoDomain projectInfoDomain) {
		Response response=Utils.getResponseObject("updating project Details");
		try {
		
		Query query=new Query(Criteria.where("projectId").is(projectInfoDomain.getProjectId()));
		Document doc=new Document();
		
		mongoTemplate.getConverter().write(projectInfoDomain, doc);	
		Update update=new Update();
		for(String key:doc.keySet()) {
			
			Object value=doc.get(key);
			if(value!=null) {
				update.set(key, value);
			}
		}
		
	   // mongoTemplate.updateMulti(query, update, ProjectInfoDomain.class, "projectInfo");//it will return UpdateResult
	    
		 projectInfoDomain= mongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true), ProjectInfoDomain.class);//it will return New Updated Data
	    
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(projectInfoDomain);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
		
	}

	@Override
	public Response deleteProjectInfo(String projectId) {
		Response response=Utils.getResponseObject("deleting project Details");
		ErrorObject err=Utils.getErrorResponse("deleting project", "project id  not found");
		try {
			ProjectInfoDomain projectInfoDomain=getProjectInfo(projectId);
			mongoTemplate.remove(projectInfoDomain);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(projectInfoDomain);
			return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(err);
			return response;
		}
	}
}
