package com.trapeze.RuntimeUnitCatalog.Module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trapeze.RuntimeUnitCatalog.SystemModel.SystemModel;
import com.trapeze.RuntimeUnitCatalog.Unit.Unit;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2018-03-06.
 */
@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long moduleId;

    String name;

    String description;

    @OneToMany(mappedBy = "module", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="module")
    Set<Unit> units;

    @ManyToOne( )
    @JoinColumn( name = "systemModelId",  insertable = false, updatable = false)
    SystemModel systemModel;

    public Module() {
        this.moduleId = 0;
        this.name = "";
        this.description = "";
    }

    public Module(long moduleId, String name, String description) {
        this.moduleId = moduleId;
        this.name = name;
        this.description = description;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Unit> getUnits() {
        return units;
    }

    public void setUnits(Set<Unit> units) {
        this.units = units;
    }

    public SystemModel getSystemModel() {
        return systemModel;
    }

    public void setSystemModel(SystemModel systemModel) {
        this.systemModel = systemModel;
    }


}
