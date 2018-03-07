package com.trapeze.RuntimeUnitCatalog.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2018-03-06.
 */
@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    public void addModule(Module module)
    {
        moduleRepository.save(module);
    }

    public void updateModule(Module module)
    {
        moduleRepository.save(module);
    }

    public List<Module> getModules()
    {
        return moduleRepository.findAll();
    }

    public Module getModuleById( long moduleId ) {
        return moduleRepository.findByModuleId(moduleId);
    }

    public void deleteModule( long moduleId)
    {
        moduleRepository.delete(moduleId);
    }

}
