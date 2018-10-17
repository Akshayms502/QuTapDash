package com.qutap.dash.service;

import java.util.List;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.model.ModuleModel;

public interface ModuleService {

	public Response saveModuleModel(ModuleModel ModuleModel);

	public ModuleModel getModuleModel(String moduleId);

	public List<ModuleModel> getModuleListInfo();

	public Response updateModuleModel(ModuleModel ModuleModel);

	public Response deleteModuleModel(String moduleId);

}
