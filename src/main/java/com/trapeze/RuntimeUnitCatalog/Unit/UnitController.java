package com.trapeze.RuntimeUnitCatalog.Unit;

import com.trapeze.RuntimeUnitCatalog.Protocol.ReturnValue;
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
    public ReturnValue addUnit(@RequestBody Unit unit) {
        return unitService.addUnit(unit);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/unit")
    public void update(@RequestBody Unit unit ) {
        unitService.updateUnit(unit);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/unit")
    public List<Unit> getUnits() {
        return unitService.getAllUnits();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/unit/formodel/{systemModelId}")
    public List<Unit> getUnitsForSystemModel(@PathVariable long systemModelId){
        return unitService.getUnitsForSystemModel(systemModelId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/unit/{unitId}")
    public Unit getUnitById(@PathVariable long unitId) {
        return unitService.getUnitById(unitId);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/unit/{unitId}")
    public void deleteUnit( @PathVariable long unitId ) {
        unitService.deleteUnit(unitId);
    }
}
