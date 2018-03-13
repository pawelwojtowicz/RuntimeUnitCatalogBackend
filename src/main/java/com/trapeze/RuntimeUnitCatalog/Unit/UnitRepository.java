package com.trapeze.RuntimeUnitCatalog.Unit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2018-03-07.
 */
public interface UnitRepository extends JpaRepository<Unit, String> {
    Unit findByUnitId(String unitId);

    List<Unit> findBySystemModelId(long systemModelId);
}
