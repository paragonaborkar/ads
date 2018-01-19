package com.netapp.ads.models;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(AggregatePK.class)
public class Aggregate {
    private Integer id;
    private String aggregateName;
    private Double aggregateSizeGb;
    private Byte isHybrid;
    private String aggregateType;
    private Integer controllerId;
    private Double poolAllocatedCapacityGb;
    private Double poolUsedCapacityGb;
    private Integer poolIopsCapability;
    private Integer avgIops;
    private Integer peakIops;
    private Integer assignedIops;
    private Double assignedCapacityGb;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "aggregate_name", nullable = false, length = 255)
    public String getAggregateName() {
        return aggregateName;
    }

    public void setAggregateName(String aggregateName) {
        this.aggregateName = aggregateName;
    }

    @Basic
    @Column(name = "aggregate_size_gb", nullable = false, precision = 0)
    public Double getAggregateSizeGb() {
        return aggregateSizeGb;
    }

    public void setAggregateSizeGb(Double aggregateSizeGb) {
        this.aggregateSizeGb = aggregateSizeGb;
    }

    @Basic
    @Column(name = "is_hybrid", nullable = false)
    public Byte getIsHybrid() {
        return isHybrid;
    }

    public void setIsHybrid(Byte isHybrid) {
        this.isHybrid = isHybrid;
    }

    @Basic
    @Column(name = "aggregate_type", nullable = false, length = 45)
    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    @Id
    @Column(name = "controller_id", nullable = false)
    public Integer getControllerId() {
        return controllerId;
    }

    public void setControllerId(Integer controllerId) {
        this.controllerId = controllerId;
    }

    @Basic
    @Column(name = "pool_allocated_capacity_gb", nullable = true, precision = 0)
    public Double getPoolAllocatedCapacityGb() {
        return poolAllocatedCapacityGb;
    }

    public void setPoolAllocatedCapacityGb(Double poolAllocatedCapacityGb) {
        this.poolAllocatedCapacityGb = poolAllocatedCapacityGb;
    }

    @Basic
    @Column(name = "pool_used_capacity_gb", nullable = true, precision = 0)
    public Double getPoolUsedCapacityGb() {
        return poolUsedCapacityGb;
    }

    public void setPoolUsedCapacityGb(Double poolUsedCapacityGb) {
        this.poolUsedCapacityGb = poolUsedCapacityGb;
    }

    @Basic
    @Column(name = "pool_iops_capability", nullable = true)
    public Integer getPoolIopsCapability() {
        return poolIopsCapability;
    }

    public void setPoolIopsCapability(Integer poolIopsCapability) {
        this.poolIopsCapability = poolIopsCapability;
    }

    @Basic
    @Column(name = "avg_iops", nullable = true)
    public Integer getAvgIops() {
        return avgIops;
    }

    public void setAvgIops(Integer avgIops) {
        this.avgIops = avgIops;
    }

    @Basic
    @Column(name = "peak_iops", nullable = true)
    public Integer getPeakIops() {
        return peakIops;
    }

    public void setPeakIops(Integer peakIops) {
        this.peakIops = peakIops;
    }

    @Basic
    @Column(name = "assigned_iops", nullable = false)
    public Integer getAssignedIops() {
        return assignedIops;
    }

    public void setAssignedIops(Integer assignedIops) {
        this.assignedIops = assignedIops;
    }

    @Basic
    @Column(name = "assigned_capacity_gb", nullable = false, precision = 1)
    public Double getAssignedCapacityGb() {
        return assignedCapacityGb;
    }

    public void setAssignedCapacityGb(Double assignedCapacityGb) {
        this.assignedCapacityGb = assignedCapacityGb;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aggregate aggregate = (Aggregate) o;
        return Objects.equals(id, aggregate.id) &&
                Objects.equals(aggregateName, aggregate.aggregateName) &&
                Objects.equals(aggregateSizeGb, aggregate.aggregateSizeGb) &&
                Objects.equals(isHybrid, aggregate.isHybrid) &&
                Objects.equals(aggregateType, aggregate.aggregateType) &&
                Objects.equals(controllerId, aggregate.controllerId) &&
                Objects.equals(poolAllocatedCapacityGb, aggregate.poolAllocatedCapacityGb) &&
                Objects.equals(poolUsedCapacityGb, aggregate.poolUsedCapacityGb) &&
                Objects.equals(poolIopsCapability, aggregate.poolIopsCapability) &&
                Objects.equals(avgIops, aggregate.avgIops) &&
                Objects.equals(peakIops, aggregate.peakIops) &&
                Objects.equals(assignedIops, aggregate.assignedIops) &&
                Objects.equals(assignedCapacityGb, aggregate.assignedCapacityGb) &&
                Objects.equals(createTime, aggregate.createTime) &&
                Objects.equals(updateTime, aggregate.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, aggregateName, aggregateSizeGb, isHybrid, aggregateType, controllerId, poolAllocatedCapacityGb, poolUsedCapacityGb, poolIopsCapability, avgIops, peakIops, assignedIops, assignedCapacityGb, createTime, updateTime);
    }
}
