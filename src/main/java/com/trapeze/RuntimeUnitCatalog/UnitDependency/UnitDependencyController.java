package com.trapeze.RuntimeUnitCatalog.UnitDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 2018-03-07.
 */
@RestController
public class UnitDependencyController {
    @Autowired
    UnitDependencyService unitDependencyService;

    @RequestMapping( method= RequestMethod.POST, value = "/unitdependency/{unitId}/{requiredUnitId}")
    public void addDependency(@PathVariable String unitId, @PathVariable String requiredUnitId ) {
        unitDependencyService.addUnitDependency( unitId,requiredUnitId);
    }

    public void deleteDependency(@PathVariable String unitId, @PathVariable String requiredUnitId ) {
        unitDependencyService.deleteUnitDependency( unitId, requiredUnitId);
    }
}
