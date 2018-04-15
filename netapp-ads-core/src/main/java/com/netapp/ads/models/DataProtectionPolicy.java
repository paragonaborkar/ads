package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the data_protection_policy database table.
 * 
 */
@Entity
@Table(name="data_protection_policy")
public class DataProtectionPolicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="data_protection_policy_name", length=45)
	private String dataProtectionPolicyName;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to MigrationCutoverSrcToTgt
	@OneToMany(mappedBy="dataProtectionPolicy")
	private List<MigrationCutoverSrcToTgt> migrationCutoverSrcToTgts;

	public DataProtectionPolicy() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDataProtectionPolicyName() {
		return this.dataProtectionPolicyName;
	}

	public void setDataProtectionPolicyName(String dataProtectionPolicyName) {
		this.dataProtectionPolicyName = dataProtectionPolicyName;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<MigrationCutoverSrcToTgt> getMigrationCutoverSrcToTgts() {
		return this.migrationCutoverSrcToTgts;
	}

	public void setMigrationCutoverSrcToTgts(List<MigrationCutoverSrcToTgt> migrationCutoverSrcToTgts) {
		this.migrationCutoverSrcToTgts = migrationCutoverSrcToTgts;
	}

	public MigrationCutoverSrcToTgt addMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		getMigrationCutoverSrcToTgts().add(migrationCutoverSrcToTgt);
		migrationCutoverSrcToTgt.setDataProtectionPolicy(this);

		return migrationCutoverSrcToTgt;
	}

	public MigrationCutoverSrcToTgt removeMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		getMigrationCutoverSrcToTgts().remove(migrationCutoverSrcToTgt);
		migrationCutoverSrcToTgt.setDataProtectionPolicy(null);

		return migrationCutoverSrcToTgt;
	}

}