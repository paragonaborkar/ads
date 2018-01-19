package com.netapp.ads.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(NasVolumePK.class)
public class NasVolume {
    private Integer id;
    private Integer controlledId;
    private Integer aggregateId;
    private String vserver;
    private String volumeName;
    private Integer allocatedCapacityGb;
    private Integer usedCapacityGb;
    private String snapType;
    private Integer snapSrcVolumeId;
    private Integer snapTgtVolumeId;
    private String snapDestinationVolume;
    private String volumeStatus;
    private Timestamp volumeLastAccessed;
    private String disposition;
    private String justification;
    private Integer avgIops;
    private Integer peakIops;
    private Integer qtreeTally;
    private Integer snapTally;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "controlled_id", nullable = false)
    public Integer getControlledId() {
        return controlledId;
    }

    public void setControlledId(Integer controlledId) {
        this.controlledId = controlledId;
    }

    @Id
    @Column(name = "aggregate_id", nullable = false)
    public Integer getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(Integer aggregateId) {
        this.aggregateId = aggregateId;
    }

    @Basic
    @Column(name = "vserver", nullable = true, length = 255)
    public String getVserver() {
        return vserver;
    }

    public void setVserver(String vserver) {
        this.vserver = vserver;
    }

    @Basic
    @Column(name = "volume_name", nullable = false, length = 255)
    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    @Basic
    @Column(name = "allocated_capacity_gb", nullable = true)
    public Integer getAllocatedCapacityGb() {
        return allocatedCapacityGb;
    }

    public void setAllocatedCapacityGb(Integer allocatedCapacityGb) {
        this.allocatedCapacityGb = allocatedCapacityGb;
    }

    @Basic
    @Column(name = "used_capacity_gb", nullable = true)
    public Integer getUsedCapacityGb() {
        return usedCapacityGb;
    }

    public void setUsedCapacityGb(Integer usedCapacityGb) {
        this.usedCapacityGb = usedCapacityGb;
    }

    @Basic
    @Column(name = "snap_type", nullable = true, length = 255)
    public String getSnapType() {
        return snapType;
    }

    public void setSnapType(String snapType) {
        this.snapType = snapType;
    }

    @Basic
    @Column(name = "snap_src_volume_id", nullable = true)
    public Integer getSnapSrcVolumeId() {
        return snapSrcVolumeId;
    }

    public void setSnapSrcVolumeId(Integer snapSrcVolumeId) {
        this.snapSrcVolumeId = snapSrcVolumeId;
    }

    @Basic
    @Column(name = "snap_tgt_volume_id", nullable = true)
    public Integer getSnapTgtVolumeId() {
        return snapTgtVolumeId;
    }

    public void setSnapTgtVolumeId(Integer snapTgtVolumeId) {
        this.snapTgtVolumeId = snapTgtVolumeId;
    }

    @Basic
    @Column(name = "snap_destination_volume", nullable = true, length = 255)
    public String getSnapDestinationVolume() {
        return snapDestinationVolume;
    }

    public void setSnapDestinationVolume(String snapDestinationVolume) {
        this.snapDestinationVolume = snapDestinationVolume;
    }

    @Basic
    @Column(name = "volume_status", nullable = true, length = 255)
    public String getVolumeStatus() {
        return volumeStatus;
    }

    public void setVolumeStatus(String volumeStatus) {
        this.volumeStatus = volumeStatus;
    }

    @Basic
    @Column(name = "volume_last_accessed", nullable = true)
    public Timestamp getVolumeLastAccessed() {
        return volumeLastAccessed;
    }

    public void setVolumeLastAccessed(Timestamp volumeLastAccessed) {
        this.volumeLastAccessed = volumeLastAccessed;
    }

    @Basic
    @Column(name = "disposition", nullable = true, length = 1024)
    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    @Basic
    @Column(name = "justification", nullable = true, length = 1024)
    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
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
    @Column(name = "qtree_tally", nullable = false)
    public Integer getQtreeTally() {
        return qtreeTally;
    }

    public void setQtreeTally(Integer qtreeTally) {
        this.qtreeTally = qtreeTally;
    }

    @Basic
    @Column(name = "snap_tally", nullable = true)
    public Integer getSnapTally() {
        return snapTally;
    }

    public void setSnapTally(Integer snapTally) {
        this.snapTally = snapTally;
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
        NasVolume nasVolume = (NasVolume) o;
        return Objects.equals(id, nasVolume.id) &&
                Objects.equals(controlledId, nasVolume.controlledId) &&
                Objects.equals(aggregateId, nasVolume.aggregateId) &&
                Objects.equals(vserver, nasVolume.vserver) &&
                Objects.equals(volumeName, nasVolume.volumeName) &&
                Objects.equals(allocatedCapacityGb, nasVolume.allocatedCapacityGb) &&
                Objects.equals(usedCapacityGb, nasVolume.usedCapacityGb) &&
                Objects.equals(snapType, nasVolume.snapType) &&
                Objects.equals(snapSrcVolumeId, nasVolume.snapSrcVolumeId) &&
                Objects.equals(snapTgtVolumeId, nasVolume.snapTgtVolumeId) &&
                Objects.equals(snapDestinationVolume, nasVolume.snapDestinationVolume) &&
                Objects.equals(volumeStatus, nasVolume.volumeStatus) &&
                Objects.equals(volumeLastAccessed, nasVolume.volumeLastAccessed) &&
                Objects.equals(disposition, nasVolume.disposition) &&
                Objects.equals(justification, nasVolume.justification) &&
                Objects.equals(avgIops, nasVolume.avgIops) &&
                Objects.equals(peakIops, nasVolume.peakIops) &&
                Objects.equals(qtreeTally, nasVolume.qtreeTally) &&
                Objects.equals(snapTally, nasVolume.snapTally) &&
                Objects.equals(createTime, nasVolume.createTime) &&
                Objects.equals(updateTime, nasVolume.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, controlledId, aggregateId, vserver, volumeName, allocatedCapacityGb, usedCapacityGb, snapType, snapSrcVolumeId, snapTgtVolumeId, snapDestinationVolume, volumeStatus, volumeLastAccessed, disposition, justification, avgIops, peakIops, qtreeTally, snapTally, createTime, updateTime);
    }
}
