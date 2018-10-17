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

import com.exilant.CommonUtils.ErrorObject;
import com.exilant.CommonUtils.Response;
import com.exilant.CommonUtils.StatusCode;
import com.exilant.CommonUtils.Utils;
import com.qutap.dash.domain.ModuleDomain;


@Repository
@Transactional
public class ModuleDaoImpl implements ModuleDao {

	org.slf4j.Logger log = LoggerFactory.getLogger(ModuleDaoImpl.class);
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Response saveModuleModel(ModuleDomain moduleDomain) {
		Response response = Utils.getResponseObject("Adding project Details");
		try {

			mongoTemplate.insert(moduleDomain, "ModuleInfo");
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(moduleDomain);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}

	@Override
	public ModuleDomain getModuleInfo(String moduleId) {
		try {
			return mongoTemplate.findById(moduleId, ModuleDomain.class);
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public List<ModuleDomain> getModuleListInfo() {
		try {
			return mongoTemplate.findAll(ModuleDomain.class, "ModuleInfo");
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public Response updateModuleInfo(ModuleDomain moduleDomain) {
		Response response = Utils.getResponseObject("updating project Details");
		try {
			//ModuleDomain modelDomain = getModuleInfo(moduleDomain.getModuleId());

			 Query query=new Query(Criteria.where("moduleId").is(moduleDomain.getModuleId()));
			 Document doc=new Document();

			 mongoTemplate.getConverter().write(moduleDomain, doc); 
			 Update update=new Update();
			 for(String key:doc.keySet()) {

			 Object value=doc.get(key);
			 if(value!=null) {
			 update.set(key, value);
			 }
			 }

			 moduleDomain   = mongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true), ModuleDomain.class);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(moduleDomain);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}

	@Override
	public Response deleteModuleInfo(String moduleId) {
		Response response = Utils.getResponseObject("deleting project Details");
		ErrorObject err = Utils.getErrorResponse("deleting project", "project id  not found");
		try {
			ModuleDomain moduleDomain = getModuleInfo(moduleId);
			mongoTemplate.remove(moduleDomain);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(moduleDomain);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(err);
			return response;
		}
	}

}
