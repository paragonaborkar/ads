package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The persistent class for the application database table.
 * 
 */
@Entity
@Table(name="application")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="application_code", nullable=false, length=255)
	private String applicationCode;

	@Column(name="application_name", nullable=false, length=255)
	private String applicationName;

	@Column(length=255)
	private String archtype;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="information_owner", length=60)
	private String informationOwner;

	@Column(name="owner_user_corporate_id", nullable=false)
	private Integer ownerUserCorporateId;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-many association to Host
	@ManyToMany(mappedBy="applications")
	private List<Host> hosts = new ArrayList<Host>();

	//bi-directional many-to-many association to LineOfBusiness
	@ManyToMany(mappedBy="applications")
	private List<LineOfBusiness> lineOfBusinesses = new ArrayList<LineOfBusiness>();

	public Application() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApplicationCode() {
		return this.applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getArchtype() {
		return this.archtype;
	}

	public void setArchtype(String archtype) {
		this.archtype = archtype;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getInformationOwner() {
		return this.informationOwner;
	}

	public void setInformationOwner(String informationOwner) {
		this.informationOwner = informationOwner;
	}

	public Integer getOwnerUserCorporateId() {
		return this.ownerUserCorporateId;
	}

	public void setOwnerUserCorporateId(Integer ownerUserCorporateId) {
		this.ownerUserCorporateId = ownerUserCorporateId;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Host> getHosts() {
		return this.hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}
	
	public Host addHost(Host host) {
		getHosts().add(host);
		host.addApplication(this);

		return host;
	}

	public Host removeHost(Host host) {
		getHosts().remove(host);
		host.removeApplication(this);

		return host;
	}	

	public List<LineOfBusiness> getLineOfBusinesses() {
		return this.lineOfBusinesses;
	}

	public void setLineOfBusinesses(List<LineOfBusiness> lineOfBusinesses) {
		this.lineOfBusinesses = lineOfBusinesses;
	}

	public LineOfBusiness addLineOfBusinesses(LineOfBusiness lineOfBusinesses) {
		getLineOfBusinesses().add(lineOfBusinesses);
		lineOfBusinesses.addApplication(this);
		return lineOfBusinesses;
	}

	public LineOfBusiness removeLineOfBusinesses(LineOfBusiness lineOfBusinesses) {
		getLineOfBusinesses().remove(lineOfBusinesses);
		lineOfBusinesses.removeApplication(this);
		return lineOfBusinesses;
	}
}