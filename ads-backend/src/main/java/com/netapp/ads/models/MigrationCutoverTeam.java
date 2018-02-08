package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the migration_cutover_team database table.
 * 
 */
@Entity
@Table(name="migration_cutover_team")
public class MigrationCutoverTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="team_member_role", nullable=false, length=1)
	private String teamMemberRole;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="user_corporate_id", nullable=false)
	private Integer userCorporateId;

	//bi-directional one-to-one association to MigrationCutoverSrcToTgt
	@OneToOne(mappedBy="migrationCutoverTeam")
	private MigrationCutoverSrcToTgt aMigrationCutoverSrcToTgt;

	//bi-directional many-to-one association to MigrationCutoverSrcToTgt
	@ManyToOne
	@JoinColumn(name="migration_cutover_src_to_tgt_id", nullable=false)
	private MigrationCutoverSrcToTgt migrationCutoverSrcToTgt;

	public MigrationCutoverTeam() {
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

	public Integer getUserCorporateId() {
		return this.userCorporateId;
	}

	public void setUserCorporateId(Integer userCorporateId) {
		this.userCorporateId = userCorporateId;
	}

	public MigrationCutoverSrcToTgt getAMigrationCutoverSrcToTgt() {
		return this.aMigrationCutoverSrcToTgt;
	}

	public void setAMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		this.aMigrationCutoverSrcToTgt = migrationCutoverSrcToTgt;
	}

	public MigrationCutoverSrcToTgt getMigrationCutoverSrcToTgt() {
		return this.migrationCutoverSrcToTgt;
	}

	public void setMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		this.migrationCutoverSrcToTgt = migrationCutoverSrcToTgt;
	}

}