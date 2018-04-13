package com.netapp.ads.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
@Embeddable
public class AggregatePK implements Serializable {
    private Integer id;
    private Integer controllerId;

    @Column(name = "id", nullable = false)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "controller_id", nullable = false)
    @Id
    public Integer getControllerId() {
        return controllerId;
    }

    public void setControllerId(Integer controllerId) {
        this.controllerId = controllerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AggregatePK that = (AggregatePK) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(controllerId, that.controllerId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, controllerId);
    }
}
