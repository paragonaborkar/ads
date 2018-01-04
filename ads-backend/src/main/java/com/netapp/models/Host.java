package com.netapp.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the host database table.
 * 
 */
@Entity
@Table(name="host")
public class Host implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="host_name", nullable=false, length=255)
	private String hostName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to DataCenter
	@ManyToOne
	@JoinColumn(name="data_center_id", nullable=false)
	private DataCenter dataCenter;

	//bi-directional many-to-one association to SourceStorage
	@OneToMany(mappedBy="host")
	private List<SourceStorage> sourceStorages;

	public Host() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getHostName() {
		return this.hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public DataCenter getDataCenter() {
		return this.dataCenter;
	}

	public void setDataCenter(DataCenter dataCenter) {
		this.dataCenter = dataCenter;
	}

	public List<SourceStorage> getSourceStorages() {
		return this.sourceStorages;
	}

	public void setSourceStorages(List<SourceStorage> sourceStorages) {
		this.sourceStorages = sourceStorages;
	}

	public SourceStorage addSourceStorage(SourceStorage sourceStorage) {
		getSourceStorages().add(sourceStorage);
		sourceStorage.setHost(this);

		return sourceStorage;
	}

	public SourceStorage removeSourceStorage(SourceStorage sourceStorage) {
		getSourceStorages().remove(sourceStorage);
		sourceStorage.setHost(null);

		return sourceStorage;
	}

}