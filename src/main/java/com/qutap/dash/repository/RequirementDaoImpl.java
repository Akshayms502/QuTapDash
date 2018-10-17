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
import org.springframework.transaction.annotation.Transactional;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.commonUtils.StatusCode;
import com.qutap.dash.commonUtils.Utils;
import com.qutap.dash.domain.RequirementDomain;



@Repository
@Transactional
public class RequirementDaoImpl implements RequirementDao {
	org.slf4j.Logger log= LoggerFactory.getLogger(RequirementDaoImpl.class);
	
	@Autowired 
	MongoTemplate mongoTemplate;
	
	@Override
	public Response saveRequirement(RequirementDomain requirementDomain) {
		
			Response response=Utils.getResponseObject("Adding project Details");
			try {
			mongoTemplate.insert(requirementDomain);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(requirementDomain);
			return response;
			}catch (Exception e) {
				log.info(e.getMessage());
				response.setStatus(StatusCode.FAILURE.name());
				response.setErrors(e.getMessage());
				return response;		
		}
	}
	
	@Override
	public RequirementDomain getRequirementById(String requirementId) {
		try {	
			return mongoTemplate.findById(requirementId, RequirementDomain.class);		
			}
		catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}
	
	
	@Override
	public List<RequirementDomain> getRequirementList() {
		try {
			return mongoTemplate.findAll(RequirementDomain.class);
			}
		catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}
	

	 @Override
	 public Response updateRequirement(RequirementDomain requirementDomain) {
		 Response response=Utils.getResponseObject("updating project Details");
		 try {
			 Query query=new Query(Criteria.where("requirementId").is(requirementDomain.getRequirementId()));
			 Document doc=new Document();
			 mongoTemplate.getConverter().write(requirementDomain, doc); 
			 Update update=new Update();
			 for(String key:doc.keySet()) {
				 Object value=doc.get(key);
				 if(value!=null) {
					 update.set(key, value);
				 	}
			 	}	     
			 requirementDomain= mongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true), RequirementDomain.class);//it will return New Updated Data     
			 response.setStatus(StatusCode.SUCCESS.name());
			 response.setData(requirementDomain);
			 return response;
		 }catch (Exception e) {
			 log.info(e.getMessage());
			 response.setStatus(StatusCode.FAILURE.name());
			 response.setErrors(e.getMessage());
			 return response;		 
		 }
	}

	@Override
	public Response deleteRequirement(RequirementDomain requirementDomain) {	
		Response response=Utils.getResponseObject("Deleting project Details");
		try {
				mongoTemplate.remove(requirementDomain);
				response.setStatus(StatusCode.SUCCESS.name());
				response.setData(requirementDomain);
				return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;	
		}
	}
	
}
