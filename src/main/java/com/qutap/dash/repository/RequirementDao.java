package com.qutap.dash.repository;

import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.domain.RequirementDomain;


public interface RequirementDao {
	Response saveRequirement(RequirementDomain requirementDomain);
	RequirementDomain getRequirementById(String requirementId);
	
	public List<RequirementDomain> getRequirementList();
	
	Response updateRequirement(RequirementDomain requirementDomain);
	Response deleteRequirement(RequirementDomain requirementDomain);

}
