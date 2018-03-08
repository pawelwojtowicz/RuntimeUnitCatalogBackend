package com.trapeze.RuntimeUnitCatalog.Unit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trapeze.RuntimeUnitCatalog.Module.Module;
import com.trapeze.RuntimeUnitCatalog.SystemModel.SystemModel;
import com.trapeze.RuntimeUnitCatalog.UnitType.UnitType;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2018-03-06.
 */
@Entity
public class Unit {

    @Id
    @Column(name = "unitId",unique=true,columnDefinition="VARCHAR(24)")
    String unitId;

    @ManyToOne( )
    @JoinColumn( name = "systemModelId",  insertable = false, updatable = false)
    @JsonIgnoreProperties(value={"units","modules", "unitTypes"})
    SystemModel systemModel;


    long unitTypeId;

    @ManyToOne( )
    @JoinColumn( name = "unitTypeId",  insertable = false, updatable = false)
    @JsonIgnoreProperties(value={"units","systemModel"})
    UnitType unitType;

    long moduleId;

    @ManyToOne()
    @JoinColumn( name = "moduleId", insertable =  false, updatable = false )
    @JsonIgnoreProperties(value={"units","systemModel", "units"})
    Module module;

    @ManyToMany( cascade = CascadeType.MERGE)
    @JoinTable( name = "UnitDependency",
            joinColumns = @JoinColumn(name = "unitId", referencedColumnName = "unitId"),
            inverseJoinColumns = @JoinColumn( name ="requiredUnitId", referencedColumnName = "unitId"))
    @JsonIgnoreProperties(value="dependentUnits")
    Set<Unit> unitDependencies;

    @ManyToMany( mappedBy = "unitDependencies", fetch = FetchType.LAZY )
    @JsonIgnore
    private Set<Unit> dependentUnits;

    String description;

    public Unit(String unitId) {
        this.unitId = unitId;
    }

    public Unit() {
        this.unitId = "";
        this.systemModel = null;
        this.unitTypeId = 0;
        this.unitType = null;
        this.moduleId = 0;
        this.module = null;
        this.unitDependencies = null;
        this.dependentUnits = null;
        this.description = "";
    }

    public Unit(String unitId, SystemModel systemModel, long unitTypeId, UnitType unitType, long moduleId, Module module, Set<Unit> unitDependencies, Set<Unit> dependentUnits) {
        this.unitId = unitId;
        this.systemModel = systemModel;
        this.unitTypeId = unitTypeId;
        this.unitType = unitType;
        this.moduleId = moduleId;
        this.module = module;
        this.unitDependencies = unitDependencies;
        this.dependentUnits = dependentUnits;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public Set<Unit> getUnitDependencies() {
        return unitDependencies;
    }

    public void setUnitDependencies(Set<Unit> unitDependencies) {
        this.unitDependencies = unitDependencies;
    }

    public Set<Unit> getDependentUnits() {
        return dependentUnits;
    }

    public void setDependentUnits(Set<Unit> dependentUnits) {
        this.dependentUnits = dependentUnits;
    }

    public SystemModel getSystemModel() {
        return systemModel;
    }

    public void setSystemModel(SystemModel systemModel) {
        this.systemModel = systemModel;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public long getUnitTypeId() {
        return unitTypeId;
    }

    public void setUnitTypeId(long unitTypeId) {
        this.unitTypeId = unitTypeId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
