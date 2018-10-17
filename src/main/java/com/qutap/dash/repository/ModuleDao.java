package com.qutap.dash.repository;

import java.util.List;

import com.exilant.CommonUtils.Response;
import com.qutap.dash.domain.ModuleDomain;
import com.qutap.dash.domain.ProjectInfoDomain;

public interface ModuleDao {
	Response saveModuleModel(ModuleDomain moduleDomain);

	ModuleDomain getModuleInfo(String moduleId);

	public List<ModuleDomain> getModuleListInfo();

	Response updateModuleInfo(ModuleDomain moduleDomain);

	Response deleteModuleInfo(String modelId);

}
