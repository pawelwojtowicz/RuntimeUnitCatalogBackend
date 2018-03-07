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
    SystemModel systemModel;

    @ManyToOne( )
    @JoinColumn( name = "unitTypeId",  insertable = false, updatable = false)
    UnitType unitType;

    @ManyToOne()
    @JoinColumn( name = "moduleId", insertable =  false, updatable = false )
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

    public Unit(String unitId) {
        this.unitId = unitId;
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
}
