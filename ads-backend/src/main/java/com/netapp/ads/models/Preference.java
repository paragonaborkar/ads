package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the preferences database table.
 * 
 */
@Entity
@Table(name="preferences")
@NamedQuery(name="Preference.findAll", query="SELECT p FROM Preference p")
public class Preference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="page_name")
	private String pageName;

	@Column(name="preference_type")
	private String preferenceType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to PreferenceDetail
	@OneToMany(mappedBy="preference")
	private List<PreferenceDetail> preferenceDetails;

	public Preference() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPreferenceType() {
		return this.preferenceType;
	}

	public void setPreferenceType(String preferenceType) {
		this.preferenceType = preferenceType;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<PreferenceDetail> getPreferenceDetails() {
		return this.preferenceDetails;
	}

	public void setPreferenceDetails(List<PreferenceDetail> preferenceDetails) {
		this.preferenceDetails = preferenceDetails;
	}

	public PreferenceDetail addPreferenceDetail(PreferenceDetail preferenceDetail) {
		getPreferenceDetails().add(preferenceDetail);
		preferenceDetail.setPreference(this);

		return preferenceDetail;
	}

	public PreferenceDetail removePreferenceDetail(PreferenceDetail preferenceDetail) {
		getPreferenceDetails().remove(preferenceDetail);
		preferenceDetail.setPreference(null);

		return preferenceDetail;
	}

}