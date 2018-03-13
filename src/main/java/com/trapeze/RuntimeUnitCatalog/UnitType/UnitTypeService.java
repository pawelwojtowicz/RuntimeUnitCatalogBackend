package com.trapeze.RuntimeUnitCatalog.UnitType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by user on 2018-03-06.
 */
@Service
public class UnitTypeService {
    @Autowired
    UnitTypeRepository unitTypeRepository;

    public void addUnitType(UnitType unitType) {
        unitTypeRepository.save(unitType);
    }

    public void updateUnitType(UnitType unitType) {
        unitTypeRepository.save(unitType);
    }

    public List<UnitType> getUnitTypes() {
        return unitTypeRepository.findAll();
    }

    public UnitType getUnitTypeById( long unitTypeId ) {
        return unitTypeRepository.findByUnitTypeId(unitTypeId);
    }

    public void deleteUnitType(long unittypeid) {
        unitTypeRepository.delete(unittypeid);
    }

    public List<UnitType> getUnitTypesForSystemModel(long systemModelId) {
        return unitTypeRepository.findBySystemModelId(systemModelId);
    }
}
