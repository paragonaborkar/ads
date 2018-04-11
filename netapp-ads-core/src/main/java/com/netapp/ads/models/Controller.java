package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the controller database table.
 * 
 */
@Entity
@Table(name="controller")
public class Controller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="controller_name", nullable=false, length=255)
	private String controllerName;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Temporal(TemporalType.DATE)
	@Column(name="date_available")
	private Date dateAvailable;

	@Column(name="serial_number", length=255)
	private String serialNumber;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Column(name="volume_tally")
	private Integer volumeTally;

	//bi-directional many-to-one association to Aggregate
	@OneToMany(mappedBy="controller")
	private List<Aggregate> aggregates;

	//bi-directional many-to-one association to DataCenter
	@ManyToOne
	@JoinColumn(name="data_center_id", nullable=false)
	private DataCenter dataCenter;

	//bi-directional many-to-one association to Export
	@ManyToOne
	@JoinColumn(name="exports_id")
	private Export export;

	//bi-directional many-to-one association to Storage
	@ManyToOne
	@JoinColumn(name="storage_id", nullable=false)
	private Storage storage;

	//bi-directional many-to-one association to NasVolume
	@OneToMany(mappedBy="controller")
	private List<NasVolume> nasVolumes;

	//bi-directional many-to-one association to WfaOcumControllerData
	@OneToMany(mappedBy="controller")
	private List<WfaOcumControllerData> wfaOcumControllerData;

	//bi-directional one-to-one association to ControllerRelease
	@OneToOne(mappedBy="srcController")
	private ControllerRelease controllerRelease;
	
	//bi-directional one-to-one association to ControllerTargetsAvailable
	@OneToOne(mappedBy="controller")
	private ControllerWorkPackage controllerWorkPackage;
	
	public Controller() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getControllerName() {
		return this.controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Date getDateAvailable() {
		return this.dateAvailable;
	}

	public void setDateAvailable(Date dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getVolumeTally() {
		return this.volumeTally;
	}

	public void setVolumeTally(Integer volumeTally) {
		this.volumeTally = volumeTally;
	}

	public List<Aggregate> getAggregates() {
		return this.aggregates;
	}

	public void setAggregates(List<Aggregate> aggregates) {
		this.aggregates = aggregates;
	}

	public Aggregate addAggregate(Aggregate aggregate) {
		getAggregates().add(aggregate);
		aggregate.setController(this);

		return aggregate;
	}

	public Aggregate removeAggregate(Aggregate aggregate) {
		getAggregates().remove(aggregate);
		aggregate.setController(null);

		return aggregate;
	}

	public DataCenter getDataCenter() {
		return this.dataCenter;
	}

	public void setDataCenter(DataCenter dataCenter) {
		this.dataCenter = dataCenter;
	}

	// FIXME: There can be multiple exports for 1 controller.
	public Export getExport() {
		return this.export;
	}

	// FIXME: There can be multiple exports for 1 controller.
	public void setExport(Export export) {
		this.export = export;
	}

	public ControllerRelease getControllerRelease() {
		return this.controllerRelease;
	}

	public void setControllerRelease(ControllerRelease controllerRelease) {
		this.controllerRelease = controllerRelease;
	}
	
	public Storage getStorage() {
		return this.storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public List<NasVolume> getNasVolumes() {
		return this.nasVolumes;
	}

	public void setNasVolumes(List<NasVolume> nasVolumes) {
		this.nasVolumes = nasVolumes;
	}

	public NasVolume addNasVolume(NasVolume nasVolume) {
		getNasVolumes().add(nasVolume);
		nasVolume.setController(this);

		return nasVolume;
	}

	public NasVolume removeNasVolume(NasVolume nasVolume) {
		getNasVolumes().remove(nasVolume);
		nasVolume.setController(null);

		return nasVolume;
	}

	public List<WfaOcumControllerData> getWfaOcumControllerData() {
		return this.wfaOcumControllerData;
	}

	public void setWfaOcumControllerData(List<WfaOcumControllerData> wfaOcumControllerData) {
		this.wfaOcumControllerData = wfaOcumControllerData;
	}

	public WfaOcumControllerData addWfaOcumControllerData(WfaOcumControllerData wfaOcumControllerData) {
		getWfaOcumControllerData().add(wfaOcumControllerData);
		wfaOcumControllerData.setController(this);

		return wfaOcumControllerData;
	}

	public WfaOcumControllerData removeWfaOcumControllerData(WfaOcumControllerData wfaOcumControllerData) {
		getWfaOcumControllerData().remove(wfaOcumControllerData);
		wfaOcumControllerData.setController(null);

		return wfaOcumControllerData;
	}
	
	
	public ControllerWorkPackage getControllerWorkPackage() {
		return this.controllerWorkPackage;
	}

	public void setControllerWorkPackage(ControllerWorkPackage controllerWorkPackage) {
		this.controllerWorkPackage = controllerWorkPackage;
	}
	

}