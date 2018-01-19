package com.netapp.ads.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class NasVolumePK implements Serializable {
    private Integer id;
    private Integer controlledId;
    private Integer aggregateId;

    @Column(name = "id", nullable = false)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "controlled_id", nullable = false)
    @Id
    public Integer getControlledId() {
        return controlledId;
    }

    public void setControlledId(Integer controlledId) {
        this.controlledId = controlledId;
    }

    @Column(name = "aggregate_id", nullable = false)
    @Id
    public Integer getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(Integer aggregateId) {
        this.aggregateId = aggregateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NasVolumePK that = (NasVolumePK) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(controlledId, that.controlledId) &&
                Objects.equals(aggregateId, that.aggregateId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, controlledId, aggregateId);
    }
}
