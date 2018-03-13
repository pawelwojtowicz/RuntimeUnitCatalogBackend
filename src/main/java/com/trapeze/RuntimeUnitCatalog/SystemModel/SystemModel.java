package com.trapeze.RuntimeUnitCatalog.SystemModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trapeze.RuntimeUnitCatalog.Module.Module;
import com.trapeze.RuntimeUnitCatalog.Unit.Unit;
import com.trapeze.RuntimeUnitCatalog.UnitType.UnitType;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2018-03-06.
 */
@Entity
public class SystemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long systemModelId;

    String name;

    String Description;

    @OneToMany(mappedBy = "systemModel", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="systemModel")
    Set<Unit> units;

    @OneToMany(mappedBy = "systemModel", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="systemModel")
    Set<Module> modules;

    @OneToMany(mappedBy = "systemModel", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="systemModel")
    Set<UnitType> unitTypes;

    public SystemModel() {
        this.systemModelId = 0;
        this.name = "";
        Description = "";
    }

    public SystemModel(long systemModelId, String name, String description) {
        this.systemModelId = systemModelId;
        this.name = name;
        Description = description;
    }

    public long getSystemModelId() {
        return systemModelId;
    }

    public void setSystemModelId(long systemModelId) {
        this.systemModelId = systemModelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Set<Unit> getUnits() {
        return units;
    }

    public void setUnits(Set<Unit> units) {
        this.units = units;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public Set<UnitType> getUnitTypes() {
        return unitTypes;
    }

    public void setUnitTypes(Set<UnitType> unitTypes) {
        this.unitTypes = unitTypes;
    }

}
