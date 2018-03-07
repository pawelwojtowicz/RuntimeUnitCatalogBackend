package com.trapeze.RuntimeUnitCatalog.SystemModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2018-03-06.
 */
@Service
public class SystemModelService {
    @Autowired
    SystemModelRepository systemModelRepository;

    public void addSystemModel(SystemModel module)
    {
        systemModelRepository.save(module);
    }

    public void updateSystemModel(SystemModel module)
    {
        systemModelRepository.save(module);
    }

    public List<SystemModel> getSystemModels()
    {
        return systemModelRepository.findAll();
    }

    public SystemModel getSystemModelById( long systemModelId ) {
        return systemModelRepository.findBySystemModelId(systemModelId);
    }

    public void deleteSystemModel( long moduleId) {
        systemModelRepository.delete(moduleId);
    }
}
