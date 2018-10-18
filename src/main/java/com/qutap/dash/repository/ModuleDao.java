package com.qutap.dash.repository;

import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.domain.ModuleDomain;

public interface ModuleDao {
	public Response saveModuleModel(ModuleDomain moduleDomain);

	public ModuleDomain getModuleInfo(String moduleId);

	public List<ModuleDomain> getModuleListInfo();

	public Response updateModuleInfo(ModuleDomain moduleDomain);

	public Response deleteModuleInfo(String modelId);

public List<ModuleDomain> getModuleModelList(String projectId);

}
