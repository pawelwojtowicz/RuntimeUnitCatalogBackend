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

    void addUnitDependency(UnitDependency unitDependency) {
        repository.save(unitDependency);
    }

    public void deleteUnitDependency(UnitDependency unitDependency){
        repository.delete(unitDependency.unitdependencyId);
    }
}
