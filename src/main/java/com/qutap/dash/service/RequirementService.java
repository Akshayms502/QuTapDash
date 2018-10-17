package com.qutap.dash.service;

import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.model.RequirementModel;

public interface RequirementService {
	public Response saveRequirement(RequirementModel RequirementModel);
	
	public RequirementModel getRequirementById(String requirementId);
	
	public List<RequirementModel> getRequirementList();
	
	public Response updateRequirement(RequirementModel requirementModel);
	
	public Response deleteRequirement(String requirementId);

	
}
