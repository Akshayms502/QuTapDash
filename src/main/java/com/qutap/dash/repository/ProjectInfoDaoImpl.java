package com.qutap.dash.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qutap.dash.CommonUtils.ErrorObject;
import com.qutap.dash.CommonUtils.Response;
import com.qutap.dash.CommonUtils.StatusCode;
import com.qutap.dash.CommonUtils.Utils;
import com.qutap.dash.domain.ModuleDomain;
import com.qutap.dash.domain.ProjectInfoDomain;
import com.qutap.dash.model.ModuleModel;
import com.qutap.dash.model.ProjectInfoModel;
import com.qutap.dash.model.RequirementModel;
import com.qutap.dash.domain.RequirementDomain;
@Repository
@Transactional
public class ProjectInfoDaoImpl implements ProjectInfoDao{

	@Autowired
	MongoTemplate mongoTemplate;
	
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoDaoImpl.class);
	
	
	
}
