package com.trapeze.RuntimeUnitCatalog.UnitDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2018-03-07.
 */
@Service
public class UnitDependencyService {
    @Autowired
    UnitDependencyRepository repository;

    void addUnitDependency(String unitId, String requiredUnitId) {
        UnitDependency unitDependency = new UnitDependency(unitId, requiredUnitId);

        repository.save(unitDependency);
    }

    public void deleteUnitDependency(String unitId, String requiredUnitId) {
        UnitDependency.UnitDependencyId id = new UnitDependency.UnitDependencyId(unitId, requiredUnitId);

        repository.delete(id);
    }
}
