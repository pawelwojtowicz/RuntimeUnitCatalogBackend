package com.trapeze.RuntimeUnitCatalog.UnitType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2018-03-06.
 */
public interface UnitTypeRepository extends JpaRepository<UnitType, Long> {
    UnitType findByUnitTypeId(long unitTypeId);

    List<UnitType> findBySystemModelId(long systemModelId);
}
