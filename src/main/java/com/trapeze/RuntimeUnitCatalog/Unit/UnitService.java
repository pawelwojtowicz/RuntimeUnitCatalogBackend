package com.trapeze.RuntimeUnitCatalog.Unit;

import com.trapeze.RuntimeUnitCatalog.Protocol.ReturnValue;
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

    public ReturnValue addUnit(Unit unit) {

        ReturnValue retVal = new ReturnValue( 0, "OK");

        List<Unit> existingUnits = unitRepository.findBySystemModelIdAndUnitStringId( unit.getSystemModelId(), unit.getUnitStringId() );

        if ( !existingUnits.isEmpty() ) {
            if ( existingUnits.get(0).getUnitId() != unit.getUnitId() ) {
                retVal.setStatus(100);
                retVal.setMessage("The unit with given name already exists");
                return retVal;
            }
        }

        unitRepository.save(unit);
        return retVal;
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
