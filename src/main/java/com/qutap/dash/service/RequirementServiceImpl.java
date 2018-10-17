package com.qutap.dash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.repository.RequirementDao;
import com.qutap.dash.model.RequirementModel;
import com.qutap.dash.domain.RequirementDomain;

@Service
public class RequirementServiceImpl implements RequirementService {
	org.slf4j.Logger log= LoggerFactory.getLogger(RequirementServiceImpl.class);
	@Autowired
	RequirementDao requirementDao;
	
	@Override
	public Response saveRequirement(RequirementModel requirementModel) {
		
		try {
			RequirementDomain requirementDomain=new RequirementDomain();
			//requirementModel.setRequirementId(UUID.randomUUID().toString().substring(0, 8));
		 BeanUtils.copyProperties(requirementModel, requirementDomain);
		  Response response=requirementDao.saveRequirement(requirementDomain);
		  return response;
		}catch (Exception e) {	
			log.info(e.getMessage());
		}return null;
	}

	@Override
	public RequirementModel getRequirementById(String requirementId) {
		try {
			RequirementModel requirementModel=new RequirementModel();
			RequirementDomain requirementDomain=requirementDao.getRequirementById(requirementId);
			BeanUtils.copyProperties(requirementDomain, requirementModel);
			return requirementModel;
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

	@Override
	public List<RequirementModel> getRequirementList() {
		try {
			List<RequirementModel> requirementModelList=new ArrayList<>();
			
			 List<RequirementDomain> requirementDomainList=requirementDao.getRequirementList();
			 for(RequirementDomain requirementDomain:requirementDomainList)
			 {
				 RequirementModel requirementModel=new RequirementModel();
			BeanUtils.copyProperties(requirementDomain, requirementModel);
			requirementModelList.add(requirementModel);
			
			}
			 
			 return requirementModelList;
		}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	
	}

	@Override
	public Response updateRequirement(RequirementModel requirementModel) {
		try {
			RequirementDomain requirementDomain=new RequirementDomain();
			BeanUtils.copyProperties(requirementModel, requirementDomain);
		  Response response=requirementDao.updateRequirement(requirementDomain);
		  return response;
		}catch (Exception e) {	
			log.info(e.getMessage());
		}return null;
	}

	@Override
	public Response deleteRequirement(String requirementId) {
		
		try {
			RequirementModel requirementModel=new RequirementModel();
			RequirementDomain requirementDomain=requirementDao.getRequirementById(requirementId);
			BeanUtils.copyProperties(requirementDomain, requirementModel);
			 Response response=requirementDao.deleteRequirement(requirementDomain);
			return response;
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	
	
}
}
