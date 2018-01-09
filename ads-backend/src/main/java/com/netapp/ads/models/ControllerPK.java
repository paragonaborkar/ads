package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the controller database table.
 */
@Embeddable
public class ControllerPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;
    
    @Column(name = "id", insertable = false, updatable = false)
    private int id;

    @Column(name = "storage_id", insertable = false, updatable = false)
    private int storageId;

    @Column(name = "data_center_id", insertable = false, updatable = false)
    private int dataCenterId;

    public ControllerPK() {
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStorageId() {
        return this.storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public int getDataCenterId() {
        return this.dataCenterId;
    }

    public void setDataCenterId(int dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ControllerPK)) {
            return false;
        }
        ControllerPK castOther = (ControllerPK) other;
        return (this.id == castOther.id) &&
                (this.storageId == castOther.storageId)
                        && (this.dataCenterId == castOther.dataCenterId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.id;
        hash = hash * prime + this.storageId;
        hash = hash * prime + this.dataCenterId;

        return hash;
    }
}