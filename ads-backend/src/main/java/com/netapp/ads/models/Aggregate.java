package com.netapp.ads.models;


import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the aggregate database table.
 * 
 */
@Entity
@Table(name="aggregate")
public class Aggregate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="aggregate_name", nullable=false, length=255)
	private String aggregateName;

	@Column(name="aggregate_size_gb", nullable=false)
	private float aggregateSizeGb;

	@Column(name="aggregate_type", nullable=false, length=45)
	private String aggregateType;

	@Column(name="assigned_capacity_gb")
	private float assignedCapacityGb;

	@Column(name="assigned_iops")
	private Integer assignedIops;

	@Column(name="avg_iops")
	private Integer avgIops;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="is_hybrid", nullable=false)
	private boolean isHybrid;

	@Column(name="peak_iops")
	private Integer peakIops;

	@Column(name="pool_allocated_capacity_gb")
	private float poolAllocatedCapacityGb;

	@Column(name="pool_iops_capability")
	private Integer poolIopsCapability;

	@Column(name="pool_used_capacity_gb")
	private float poolUsedCapacityGb;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to Controller
	@ManyToOne
	@JoinColumn(name="controller_id", nullable=false)
	private Controller controller;

	//bi-directional many-to-one association to AggregatePurpose
	@OneToMany(mappedBy="aggregate")
	private List<AggregatePurpose> aggregatePurposes;

	//bi-directional many-to-one association to NasVolume
	@OneToMany(mappedBy="aggregate")
	private List<NasVolume> nasVolumes;

	//bi-directional many-to-one association to Replication
	@OneToMany(mappedBy="targetVaultAggregate")
	private List<Replication> targetVaultAggregateReplications;

	//bi-directional many-to-one association to Replication
	@OneToMany(mappedBy="targetMirrorAggregate")
	private List<Replication> targetMirrorAggregateReplications;

	public Aggregate() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAggregateName() {
		return this.aggregateName;
	}

	public void setAggregateName(String aggregateName) {
		this.aggregateName = aggregateName;
	}

	public float getAggregateSizeGb() {
		return this.aggregateSizeGb;
	}

	public void setAggregateSizeGb(float aggregateSizeGb) {
		this.aggregateSizeGb = aggregateSizeGb;
	}

	public String getAggregateType() {
		return this.aggregateType;
	}

	public void setAggregateType(String aggregateType) {
		this.aggregateType = aggregateType;
	}

	public float getAssignedCapacityGb() {
		return this.assignedCapacityGb;
	}

	public void setAssignedCapacityGb(float assignedCapacityGb) {
		this.assignedCapacityGb = assignedCapacityGb;
	}

	public Integer getAssignedIops() {
		return this.assignedIops;
	}

	public void setAssignedIops(Integer assignedIops) {
		this.assignedIops = assignedIops;
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

	public boolean getIsHybrid() {
		return this.isHybrid;
	}

	public void setIsHybrid(boolean isHybrid) {
		this.isHybrid = isHybrid;
	}

	public Integer getPeakIops() {
		return this.peakIops;
	}

	public void setPeakIops(Integer peakIops) {
		this.peakIops = peakIops;
	}

	public float getPoolAllocatedCapacityGb() {
		return this.poolAllocatedCapacityGb;
	}

	public void setPoolAllocatedCapacityGb(float poolAllocatedCapacityGb) {
		this.poolAllocatedCapacityGb = poolAllocatedCapacityGb;
	}

	public Integer getPoolIopsCapability() {
		return this.poolIopsCapability;
	}

	public void setPoolIopsCapability(Integer poolIopsCapability) {
		this.poolIopsCapability = poolIopsCapability;
	}

	public float getPoolUsedCapacityGb() {
		return this.poolUsedCapacityGb;
	}

	public void setPoolUsedCapacityGb(float poolUsedCapacityGb) {
		this.poolUsedCapacityGb = poolUsedCapacityGb;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Controller getController() {
		return this.controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public List<AggregatePurpose> getAggregatePurposes() {
		return this.aggregatePurposes;
	}

	public void setAggregatePurposes(List<AggregatePurpose> aggregatePurposes) {
		this.aggregatePurposes = aggregatePurposes;
	}

	public AggregatePurpose addAggregatePurpos(AggregatePurpose aggregatePurpos) {
		getAggregatePurposes().add(aggregatePurpos);
		aggregatePurpos.setAggregate(this);

		return aggregatePurpos;
	}

	public AggregatePurpose removeAggregatePurpos(AggregatePurpose aggregatePurpos) {
		getAggregatePurposes().remove(aggregatePurpos);
		aggregatePurpos.setAggregate(null);

		return aggregatePurpos;
	}

	public List<NasVolume> getNasVolumes() {
		return this.nasVolumes;
	}

	public void setNasVolumes(List<NasVolume> nasVolumes) {
		this.nasVolumes = nasVolumes;
	}

	public NasVolume addNasVolume(NasVolume nasVolume) {
		getNasVolumes().add(nasVolume);
		nasVolume.setAggregate(this);

		return nasVolume;
	}

	public NasVolume removeNasVolume(NasVolume nasVolume) {
		getNasVolumes().remove(nasVolume);
		nasVolume.setAggregate(null);

		return nasVolume;
	}

	public List<Replication> getTargetVaultAggregateReplications() {
		return this.targetVaultAggregateReplications;
	}

	public void setTargetVaultAggregateReplications(List<Replication> targetVaultAggregateReplications) {
		this.targetVaultAggregateReplications = targetVaultAggregateReplications;
	}

	public Replication addTargetVaultAggregateReplications(Replication replications) {
		getTargetVaultAggregateReplications().add(replications);
		replications.setTargetVaultAggregate(this);

		return replications;
	}

	public Replication removeTargetVaultAggregateReplications(Replication replications) {
		getTargetVaultAggregateReplications().remove(replications);
		replications.setTargetVaultAggregate(null);

		return replications;
	}

	public List<Replication> getTargetMirrorAggregateReplications() {
		return this.targetMirrorAggregateReplications;
	}

	public void setTargetMirrorAggregateReplications(List<Replication> targetMirrorAggregateReplications) {
		this.targetMirrorAggregateReplications = targetMirrorAggregateReplications;
	}

	public Replication addTargetMirrorReplications(Replication replications) {
		getTargetMirrorAggregateReplications().add(replications);
		replications.setTargetMirrorAggregate(this);

		return replications;
	}

	public Replication removeTargetMirrorAggregateReplications(Replication replications) {
		getTargetMirrorAggregateReplications().remove(replications);
		replications.setTargetMirrorAggregate(null);

		return replications;
	}

}
