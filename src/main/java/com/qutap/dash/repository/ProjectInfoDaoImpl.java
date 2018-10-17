package com.qutap.dash.repository;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class ProjectInfoDaoImpl implements ProjectInfoDao{

	@Autowired
	MongoTemplate mongoTemplate;
	
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoDaoImpl.class);
	
	
	
}
