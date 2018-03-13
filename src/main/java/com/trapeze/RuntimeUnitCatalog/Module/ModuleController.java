package com.trapeze.RuntimeUnitCatalog.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2018-03-06.
 */
@RestController
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @RequestMapping( method= RequestMethod.POST, value = "/modules")
    public void addModule(@RequestBody Module module)
    {
        moduleService.addModule(module);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/modules")
    public void updateModule(@RequestBody Module module)
    {
        moduleService.updateModule(module);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/modules")
    public List<Module> getModules()
    {
        return moduleService.getModules();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/modules/formodel/{systemModelId}")
    public List<Module> getModulesForSystemMode(@PathVariable long systemModelId ) {
        return moduleService.getModulesForSystemModel(systemModelId);
    }

    @RequestMapping( method = RequestMethod.GET , value= "/modules/{moduleId}")
    public Module getModuleById( @PathVariable long moduleId ) {
        Module newOne = moduleService.getModuleById( moduleId );
        return newOne;
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/modules/{moduleId}")
    public void deleteModule( @PathVariable long moduleId)
    {
        moduleService.deleteModule(moduleId);
    }
}
