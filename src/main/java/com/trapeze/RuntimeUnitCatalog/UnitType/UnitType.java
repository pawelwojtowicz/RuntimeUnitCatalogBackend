package com.trapeze.RuntimeUnitCatalog.UnitType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trapeze.RuntimeUnitCatalog.SystemModel.SystemModel;
import com.trapeze.RuntimeUnitCatalog.Unit.Unit;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2018-03-06.
 */
@Entity
public class UnitType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long unitTypeId;

    String name;

    String description;

    @OneToMany(mappedBy = "unitType", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="unitType")
    Set<Unit> units;

    @ManyToOne( )
    @JoinColumn( name = "systemModelId",  insertable = false, updatable = false)
    SystemModel systemModel;


    public UnitType() {
        this.unitTypeId = 0;
        this.name = "";
        this.description = "";
    }

    public UnitType(long unitTypeId, String name, String description) {
        this.unitTypeId = unitTypeId;
        this.name = name;
        this.description = description;
    }

    public long getUnitTypeId() {
        return unitTypeId;
    }

    public void setUnitTypeId(long unitTypeId) {
        this.unitTypeId = unitTypeId;
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
