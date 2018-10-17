package com.qutap.dash.service;

import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.model.RequirementModel;
import com.qutap.dash.domain.RequirementDomain;

public interface RequirementService {
	Response saveRequirement(RequirementModel RequirementModel);
	RequirementModel getRequirementById(String requirementId);
	
	public List<RequirementModel> getRequirementList();
	
	Response updateRequirement(RequirementModel requirementModel);
	Response deleteRequirement(String requirementId);

}
