package com.qutap.dash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.domain.ModuleDomain;
import com.qutap.dash.model.ModuleModel;
import com.qutap.dash.repository.ModuleDao;
import com.qutap.dash.repository.ProjectInfoDao;

@Service
public class ModuleServiceImpl implements ModuleService {

	org.slf4j.Logger log = LoggerFactory.getLogger(ModuleServiceImpl.class);

	@Autowired
	ModuleDao moduleDao;
	
	@Autowired
	ProjectInfoDao projectInfoDao;

	@Override
	public Response saveModuleModel(ModuleModel moduleModel) {
		try {
			ModuleDomain moduleDomain = new ModuleDomain();
			moduleModel.setModuleId(UUID.randomUUID().toString().substring(0, 5));
//			moduleDomain.setProjectId(projectInfoDao.getProjectInfo(moduleModel.getProjectId()).getProjectId());
			BeanUtils.copyProperties(moduleModel, moduleDomain);		
			Response response = moduleDao.saveModuleModel(moduleDomain);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public ModuleModel getModuleModel(String moduleId) {
		try {
			ModuleModel moduleModel = new ModuleModel();
			ModuleDomain moduleDomain = moduleDao.getModuleInfo(moduleId);
			BeanUtils.copyProperties(moduleDomain, moduleModel);
			return moduleModel;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public List<ModuleModel> getModuleListInfo() {
		try {
			List<ModuleModel> moduleList = new ArrayList<>();
			List<ModuleDomain> moduleDomainList = moduleDao.getModuleListInfo();
			for (ModuleDomain moduleDomain : moduleDomainList) {
				ModuleModel moduleModel = new ModuleModel();
				BeanUtils.copyProperties(moduleDomain, moduleModel);
				moduleList.add(moduleModel);
			}
			return moduleList;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public Response updateModuleModel(ModuleModel ModuleModel) {
		try {
			ModuleDomain moduleDomain = new ModuleDomain();
			BeanUtils.copyProperties(ModuleModel, moduleDomain);
			Response response = moduleDao.updateModuleInfo(moduleDomain);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public Response deleteModuleModel(String moduleId) {
		try {
			Response response = moduleDao.deleteModuleInfo(moduleId);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public List<ModuleModel> getModuleModelList(String projectId) {
		try {
			List<ModuleModel> moduleList = new ArrayList<>();
		List<ModuleDomain> moduleDomainList = moduleDao.getModuleModelList(projectId);
			for (ModuleDomain moduleDomain : moduleDomainList) {
				ModuleModel moduleModel = new ModuleModel();
				BeanUtils.copyProperties(moduleDomain, moduleModel);
				moduleList.add(moduleModel);
			}
			return moduleList;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	} 

}
