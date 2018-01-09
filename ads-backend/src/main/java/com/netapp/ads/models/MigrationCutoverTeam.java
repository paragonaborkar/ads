package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the migration_cutover_team database table.
 * 
 */
@Entity
@Table(name="migration_cutover_team")
@NamedQuery(name="MigrationCutoverTeam.findAll", query="SELECT m FROM MigrationCutoverTeam m")
public class MigrationCutoverTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="migration_cutover_src_to_tgt_id")
	private int migrationCutoverSrcToTgtId;

	@Column(name="team_member_role")
	private String teamMemberRole;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="user_corporate_id")
	private int userCorporateId;

	//bi-directional many-to-one association to MigrationCutoverSrcToTgt
	@OneToMany(mappedBy="migrationCutoverTeam")
	private List<MigrationCutoverSrcToTgt> migrationCutoverSrcToTgts;

	public MigrationCutoverTeam() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getMigrationCutoverSrcToTgtId() {
		return this.migrationCutoverSrcToTgtId;
	}

	public void setMigrationCutoverSrcToTgtId(int migrationCutoverSrcToTgtId) {
		this.migrationCutoverSrcToTgtId = migrationCutoverSrcToTgtId;
	}

	public String getTeamMemberRole() {
		return this.teamMemberRole;
	}

	public void setTeamMemberRole(String teamMemberRole) {
		this.teamMemberRole = teamMemberRole;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getUserCorporateId() {
		return this.userCorporateId;
	}

	public void setUserCorporateId(int userCorporateId) {
		this.userCorporateId = userCorporateId;
	}

	public List<MigrationCutoverSrcToTgt> getMigrationCutoverSrcToTgts() {
		return this.migrationCutoverSrcToTgts;
	}

	public void setMigrationCutoverSrcToTgts(List<MigrationCutoverSrcToTgt> migrationCutoverSrcToTgts) {
		this.migrationCutoverSrcToTgts = migrationCutoverSrcToTgts;
	}

	public MigrationCutoverSrcToTgt addMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		getMigrationCutoverSrcToTgts().add(migrationCutoverSrcToTgt);
		migrationCutoverSrcToTgt.setMigrationCutoverTeam(this);

		return migrationCutoverSrcToTgt;
	}

	public MigrationCutoverSrcToTgt removeMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		getMigrationCutoverSrcToTgts().remove(migrationCutoverSrcToTgt);
		migrationCutoverSrcToTgt.setMigrationCutoverTeam(null);

		return migrationCutoverSrcToTgt;
	}

}