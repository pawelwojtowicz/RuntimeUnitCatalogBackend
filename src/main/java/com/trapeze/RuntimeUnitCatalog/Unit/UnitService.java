package com.trapeze.RuntimeUnitCatalog.Unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2018-03-07.
 */
@Service
public class UnitService {
    @Autowired
    UnitRepository unitRepository;

    public void addUnit(Unit unit) {
        unitRepository.save(unit);
    }

    public void updateUnit(Unit unit) {
        unitRepository.save(unit);
    }


    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public Unit getUnitById(long unitId) {
        return unitRepository.findByUnitId(unitId);
    }

    public void deleteUnit(long unitId) {
        unitRepository.delete(unitId);
    }

    public List<Unit> getUnitsForSystemModel(long systemModelId) {
        return unitRepository.findBySystemModelId(systemModelId);
    }
}
