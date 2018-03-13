package com.trapeze.RuntimeUnitCatalog.UnitType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by user on 2018-03-06.
 */
@RestController
public class UnitTypeController {
    @Autowired
    UnitTypeService unitTypeService;

    @RequestMapping( method= RequestMethod.POST, value = "/unittype")
    public void addUnitType( @RequestBody UnitType unitType) {
        unitTypeService.addUnitType(unitType);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/unittype")
    public void updateUnitType(@RequestBody UnitType unitType) {
        unitTypeService.updateUnitType( unitType);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/unittype")
    public List<UnitType> getUnitTypes()
    {
        return unitTypeService.getUnitTypes();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/unittype/formodel/{systemModelId}")
    public List<UnitType> getUnitTypesForModel(@PathVariable long systemModelId) {
        return unitTypeService.getUnitTypesForSystemModel(systemModelId);
    }

    @RequestMapping( method = RequestMethod.GET , value= "/unittype/{unittypeid}")
    public UnitType getSystemModelById( @PathVariable long unittypeid ) {
        UnitType newOne = unitTypeService.getUnitTypeById( unittypeid);
        return newOne;
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/unittype/{unittypeid}")
    public void deleteSystemModel( @PathVariable long unittypeid)
    {
        unitTypeService.deleteUnitType(unittypeid);
    }

}
