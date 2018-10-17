package com.qutap.dash.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.model.ModuleModel;
import com.qutap.dash.model.ProjectInfoModel;

public interface ModuleService {

	Response saveModuleModel(ModuleModel ModuleModel);

	public ModuleModel getModuleModel(String moduleId);

	public List<ModuleModel> getModuleListInfo();

	Response updateModuleModel(ModuleModel ModuleModel);

	Response deleteModuleModel(String moduleId);

}
