package com.netapp.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the data_center database table.
 * 
 */
@Entity
@Table(name="data_center")
public class DataCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="data_center_name", nullable=false, length=255)
	private String dataCenterName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to Host
	@OneToMany(mappedBy="dataCenter")
	private List<Host> hosts;

	public DataCenter() {
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

	public String getDataCenterName() {
		return this.dataCenterName;
	}

	public void setDataCenterName(String dataCenterName) {
		this.dataCenterName = dataCenterName;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<Host> getHosts() {
		return this.hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}

	public Host addHost(Host host) {
		getHosts().add(host);
		host.setDataCenter(this);

		return host;
	}

	public Host removeHost(Host host) {
		getHosts().remove(host);
		host.setDataCenter(null);

		return host;
	}

}