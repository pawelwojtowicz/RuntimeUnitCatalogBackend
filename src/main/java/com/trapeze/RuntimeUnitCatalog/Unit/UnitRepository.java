package com.trapeze.RuntimeUnitCatalog.Unit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2018-03-07.
 */
public interface UnitRepository extends JpaRepository<Unit, Long> {
    Unit findByUnitId(long unitId);

    List<Unit> findBySystemModelId(long systemModelId);

    List<Unit> findBySystemModelIdAndUnitStringId( long systemModelId, String unitStringId);
}
