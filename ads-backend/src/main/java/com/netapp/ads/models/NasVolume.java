package com.netapp.ads.models;

<<<<<<< HEAD
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
=======
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the nas_volume database table.
 * 
 */
@Entity
@Table(name="nas_volume")
public class NasVolume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="allocated_capacity_gb")
	private Integer allocatedCapacityGb;

	@Column(name="avg_iops")
	private Integer avgIops;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(length=1024)
	private String disposition;

	@Column(length=1024)
	private String justification;

	@Column(name="peak_iops")
	private Integer peakIops;

	@Column(name="qtree_tally", nullable=false)
	private Integer qtreeTally;

	@Column(name="snap_destination_volume", length=255)
	private String snapDestinationVolume;

	@Column(name="snap_src_volume_id")
	private Integer snapSrcVolumeId;

	@Column(name="snap_tally")
	private Integer snapTally;

	@Column(name="snap_tgt_volume_id")
	private Integer snapTgtVolumeId;

	@Column(name="snap_type", length=255)
	private String snapType;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="used_capacity_gb")
	private Integer usedCapacityGb;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="volume_last_accessed")
	private Date volumeLastAccessed;

	@Column(name="volume_name", nullable=false, length=255)
	private String volumeName;

	@Column(name="volume_status", length=255)
	private String volumeStatus;

	@Column(length=255)
	private String vserver;

	//bi-directional many-to-one association to Aggregate
	@ManyToOne
	@JoinColumn(name="aggregate_id", nullable=false)
	private Aggregate aggregate;

	//bi-directional many-to-one association to Controller
	@ManyToOne
	@JoinColumn(name="controlled_id", nullable=false)
	private Controller controller;

	//bi-directional many-to-one association to Qtree
	@OneToMany(mappedBy="nasVolume")
	private List<Qtree> qtrees;

	public NasVolume() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAllocatedCapacityGb() {
		return this.allocatedCapacityGb;
	}

	public void setAllocatedCapacityGb(Integer allocatedCapacityGb) {
		this.allocatedCapacityGb = allocatedCapacityGb;
	}

	public Integer getAvgIops() {
		return this.avgIops;
	}

	public void setAvgIops(Integer avgIops) {
		this.avgIops = avgIops;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDisposition() {
		return this.disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public String getJustification() {
		return this.justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Integer getPeakIops() {
		return this.peakIops;
	}

	public void setPeakIops(Integer peakIops) {
		this.peakIops = peakIops;
	}

	public Integer getQtreeTally() {
		return this.qtreeTally;
	}

	public void setQtreeTally(Integer qtreeTally) {
		this.qtreeTally = qtreeTally;
	}

	public String getSnapDestinationVolume() {
		return this.snapDestinationVolume;
	}

	public void setSnapDestinationVolume(String snapDestinationVolume) {
		this.snapDestinationVolume = snapDestinationVolume;
	}

	public Integer getSnapSrcVolumeId() {
		return this.snapSrcVolumeId;
	}

	public void setSnapSrcVolumeId(Integer snapSrcVolumeId) {
		this.snapSrcVolumeId = snapSrcVolumeId;
	}

	public Integer getSnapTally() {
		return this.snapTally;
	}

	public void setSnapTally(Integer snapTally) {
		this.snapTally = snapTally;
	}

	public Integer getSnapTgtVolumeId() {
		return this.snapTgtVolumeId;
	}

	public void setSnapTgtVolumeId(Integer snapTgtVolumeId) {
		this.snapTgtVolumeId = snapTgtVolumeId;
	}

	public String getSnapType() {
		return this.snapType;
	}

	public void setSnapType(String snapType) {
		this.snapType = snapType;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUsedCapacityGb() {
		return this.usedCapacityGb;
	}

	public void setUsedCapacityGb(Integer usedCapacityGb) {
		this.usedCapacityGb = usedCapacityGb;
	}

	public Date getVolumeLastAccessed() {
		return this.volumeLastAccessed;
	}

	public void setVolumeLastAccessed(Date volumeLastAccessed) {
		this.volumeLastAccessed = volumeLastAccessed;
	}

	public String getVolumeName() {
		return this.volumeName;
	}

	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}

	public String getVolumeStatus() {
		return this.volumeStatus;
	}

	public void setVolumeStatus(String volumeStatus) {
		this.volumeStatus = volumeStatus;
	}

	public String getVserver() {
		return this.vserver;
	}

	public void setVserver(String vserver) {
		this.vserver = vserver;
	}

	public Aggregate getAggregate() {
		return this.aggregate;
	}

	public void setAggregate(Aggregate aggregate) {
		this.aggregate = aggregate;
	}

	public Controller getController() {
		return this.controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public List<Qtree> getQtrees() {
		return this.qtrees;
	}

	public void setQtrees(List<Qtree> qtrees) {
		this.qtrees = qtrees;
	}

	public Qtree addQtree(Qtree qtree) {
		getQtrees().add(qtree);
		qtree.setNasVolume(this);

		return qtree;
	}

	public Qtree removeQtree(Qtree qtree) {
		getQtrees().remove(qtree);
		qtree.setNasVolume(null);

		return qtree;
	}

}
>>>>>>> b_models_repos
