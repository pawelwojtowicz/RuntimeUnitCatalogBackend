package com.trapeze.RuntimeUnitCatalog.Unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2018-03-07.
 */
@RestController
public class UnitController {
    @Autowired
    UnitService unitService;

    @RequestMapping( method= RequestMethod.POST, value = "/unit")
    public void addUnit(@RequestBody Unit unit) {
        unitService.addUnit(unit);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/unit")
    public void update(@RequestBody Unit unit ) {
        unitService.updateUnit(unit);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/unit")
    public List<Unit> getUnits() {
        return unitService.getAllUnits();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/unit/{unitId}")
    public Unit getUnitById(@PathVariable String unitId) {
        return unitService.getUnitById(unitId);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/unit/{unitId}")
    public void deleteUnit( @PathVariable String unitId ) {
        unitService.deleteUnit(unitId);
    }
}