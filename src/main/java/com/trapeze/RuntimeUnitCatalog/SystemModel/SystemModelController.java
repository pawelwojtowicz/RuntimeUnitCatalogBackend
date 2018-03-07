package com.trapeze.RuntimeUnitCatalog.SystemModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2018-03-06.
 */
@RestController
public class SystemModelController {
    @Autowired
    SystemModelService systemModelService;

    @RequestMapping( method= RequestMethod.POST, value = "/systemmodel")
    public void addSystemModel(@RequestBody SystemModel module)
    {
        systemModelService.addSystemModel(module);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/systemmodel")
    public void updateSystemModel(@RequestBody SystemModel module)
    {
        systemModelService.updateSystemModel(module);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/systemmodel")
    public List<SystemModel> getSystemModels()
    {
        return systemModelService.getSystemModels();
    }

    @RequestMapping( method = RequestMethod.GET , value= "/systemmodel/{systemModelId}")
    public SystemModel getSystemModelById( @PathVariable long systemModelId ) {
        SystemModel newOne = systemModelService.getSystemModelById( systemModelId);
        return newOne;
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/systemmodel/{systemModelId}")
    public void deleteSystemModel( @PathVariable long systemModelId)
    {
        systemModelService.deleteSystemModel(systemModelId);
    }

}
