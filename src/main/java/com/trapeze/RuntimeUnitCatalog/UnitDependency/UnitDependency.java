package com.trapeze.RuntimeUnitCatalog.UnitDependency;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by user on 2018-03-06.
 */
@Entity
public class UnitDependency {
    @Embeddable
    static public class UnitDependencyId implements Serializable{

        public UnitDependencyId() {
            this.unitId = "";
            this.requiredUnitId = "";
        }

        public UnitDependencyId(String unitId, String requiredUnitId) {
            this.unitId = unitId;
            this.requiredUnitId = requiredUnitId;
        }

        public String getUnitId() {
            return unitId;
        }

        public void setUnitId(String unitId) {
            this.unitId = unitId;
        }

        public String getRequiredUnitId() {
            return requiredUnitId;
        }

        public void setRequiredUnitId(String requiredUnitId) {
            this.requiredUnitId = requiredUnitId;
        }

        @Column(name = "unitId", nullable = false)
        String unitId;
        @Column(name = "requiredUnitId", nullable = false)
        String requiredUnitId;
    }

    @EmbeddedId
    public UnitDependencyId unitdependencyId;

    public UnitDependency() {
        this.unitdependencyId = new UnitDependencyId();
    }

    public UnitDependency(String unitId, String requiredUnitId) {
        this.unitdependencyId = new UnitDependencyId(unitId, requiredUnitId);
    }

    public String getUnitId() {
        return this.unitdependencyId.unitId;
    }

    public void setUnitId(String unitId) {
        this.unitdependencyId.unitId = unitId;
    }

    public String getRequiredUnitId() {
        return this.unitdependencyId.requiredUnitId;
    }

    public void setRequiredUnitId(String requiredUnitId) {
        this.unitdependencyId.requiredUnitId= requiredUnitId;
    }


}
