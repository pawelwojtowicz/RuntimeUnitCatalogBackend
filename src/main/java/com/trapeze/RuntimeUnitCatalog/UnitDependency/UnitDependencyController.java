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

    @RequestMapping( method= RequestMethod.POST, value = "/unitdependency")
    public void addDependency(@RequestBody UnitDependency dependency ) {
        unitDependencyService.addUnitDependency( dependency);
    }

    @RequestMapping( method= RequestMethod.DELETE, value = "/unitdependency")
    public void deleteDependency(@RequestBody UnitDependency dependency) {
        unitDependencyService.deleteUnitDependency( dependency);
    }
}
