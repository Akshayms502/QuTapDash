package com.qutap.dash.repository;

import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.domain.RequirementDomain;


public interface RequirementDao {
	public Response saveRequirement(RequirementDomain requirementDomain);
	
	public RequirementDomain getRequirementById(String requirementId);
	
	public List<RequirementDomain> getRequirementList();
	
	public Response updateRequirement(RequirementDomain requirementDomain);
	
	public Response deleteRequirement(RequirementDomain requirementDomain);

	
}
