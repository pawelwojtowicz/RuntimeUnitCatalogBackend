package com.trapeze.RuntimeUnitCatalog.SystemModel;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2018-03-06.
 */
public interface SystemModelRepository extends JpaRepository<SystemModel, Long> {
    SystemModel findBySystemModelId( long systemModelId);
}
