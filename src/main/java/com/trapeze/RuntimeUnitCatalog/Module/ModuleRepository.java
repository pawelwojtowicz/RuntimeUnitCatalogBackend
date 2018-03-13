package com.trapeze.RuntimeUnitCatalog.Module;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2018-03-06.
 */
public interface ModuleRepository  extends JpaRepository<Module,Long> {
    public Module findByModuleId(long moduleId);

    List<Module> findBySystemModelId(long systemModelId);
}
