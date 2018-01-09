package com.netapp.ads.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "activity")
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity {
    private Integer id;
    private Integer qtreeId;
    private String vserver;
    private String disposition;
    private Date mailingDate;
    private Byte willDelete;
    private Date deleteDate;
    private Byte willMigrate;
    private Date migrateWeek;
    private Integer migrateDay;
    private Byte callMe;
    private String bestNumber;
    private String callReason;
    private Byte archiveCandidate;
    private Byte isLatest;
    private Byte adminOverride;
    private String note;
    private String appNameList;
    private Integer mailCount;
    private Integer migrationTimeId;
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

    @Basic
    @Column(name = "qtree_id", nullable = true)
    public Integer getQtreeId() {
        return qtreeId;
    }

    public void setQtreeId(Integer qtreeId) {
        this.qtreeId = qtreeId;
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
    @Column(name = "disposition", nullable = true, length = 255)
    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    @Basic
    @Column(name = "mailing_date", nullable = true)
    public Date getMailingDate() {
        return mailingDate;
    }

    public void setMailingDate(Date mailingDate) {
        this.mailingDate = mailingDate;
    }

    @Basic
    @Column(name = "will_delete", nullable = false)
    public Byte getWillDelete() {
        return willDelete;
    }

    public void setWillDelete(Byte willDelete) {
        this.willDelete = willDelete;
    }

    @Basic
    @Column(name = "delete_date", nullable = true)
    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    @Basic
    @Column(name = "will_migrate", nullable = false)
    public Byte getWillMigrate() {
        return willMigrate;
    }

    public void setWillMigrate(Byte willMigrate) {
        this.willMigrate = willMigrate;
    }

    @Basic
    @Column(name = "migrate_week", nullable = true)
    public Date getMigrateWeek() {
        return migrateWeek;
    }

    public void setMigrateWeek(Date migrateWeek) {
        this.migrateWeek = migrateWeek;
    }

    @Basic
    @Column(name = "migrate_day", nullable = true)
    public Integer getMigrateDay() {
        return migrateDay;
    }

    public void setMigrateDay(Integer migrateDay) {
        this.migrateDay = migrateDay;
    }

    @Basic
    @Column(name = "call_me", nullable = false)
    public Byte getCallMe() {
        return callMe;
    }

    public void setCallMe(Byte callMe) {
        this.callMe = callMe;
    }

    @Basic
    @Column(name = "best_number", nullable = true, length = 100)
    public String getBestNumber() {
        return bestNumber;
    }

    public void setBestNumber(String bestNumber) {
        this.bestNumber = bestNumber;
    }

    @Basic
    @Column(name = "call_reason", nullable = true, length = 2048)
    public String getCallReason() {
        return callReason;
    }

    public void setCallReason(String callReason) {
        this.callReason = callReason;
    }

    @Basic
    @Column(name = "archive_candidate", nullable = false)
    public Byte getArchiveCandidate() {
        return archiveCandidate;
    }

    public void setArchiveCandidate(Byte archiveCandidate) {
        this.archiveCandidate = archiveCandidate;
    }

    @Basic
    @Column(name = "is_latest", nullable = false)
    public Byte getIsLatest() {
        return isLatest;
    }

    public void setIsLatest(Byte isLatest) {
        this.isLatest = isLatest;
    }

    @Basic
    @Column(name = "admin_override", nullable = false)
    public Byte getAdminOverride() {
        return adminOverride;
    }

    public void setAdminOverride(Byte adminOverride) {
        this.adminOverride = adminOverride;
    }

    @Basic
    @Column(name = "note", nullable = true, length = 1024)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "app_name_list", nullable = true, length = 1024)
    public String getAppNameList() {
        return appNameList;
    }

    public void setAppNameList(String appNameList) {
        this.appNameList = appNameList;
    }

    @Basic
    @Column(name = "mail_count", nullable = true)
    public Integer getMailCount() {
        return mailCount;
    }

    public void setMailCount(Integer mailCount) {
        this.mailCount = mailCount;
    }

    @Basic
    @Column(name = "migration_time_id", nullable = true)
    public Integer getMigrationTimeId() {
        return migrationTimeId;
    }

    public void setMigrationTimeId(Integer migrationTimeId) {
        this.migrationTimeId = migrationTimeId;
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
        Activity that = (Activity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(qtreeId, that.qtreeId) &&
                Objects.equals(vserver, that.vserver) &&
                Objects.equals(disposition, that.disposition) &&
                Objects.equals(mailingDate, that.mailingDate) &&
                Objects.equals(willDelete, that.willDelete) &&
                Objects.equals(deleteDate, that.deleteDate) &&
                Objects.equals(willMigrate, that.willMigrate) &&
                Objects.equals(migrateWeek, that.migrateWeek) &&
                Objects.equals(migrateDay, that.migrateDay) &&
                Objects.equals(callMe, that.callMe) &&
                Objects.equals(bestNumber, that.bestNumber) &&
                Objects.equals(callReason, that.callReason) &&
                Objects.equals(archiveCandidate, that.archiveCandidate) &&
                Objects.equals(isLatest, that.isLatest) &&
                Objects.equals(adminOverride, that.adminOverride) &&
                Objects.equals(note, that.note) &&
                Objects.equals(appNameList, that.appNameList) &&
                Objects.equals(mailCount, that.mailCount) &&
                Objects.equals(migrationTimeId, that.migrationTimeId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, qtreeId, vserver, disposition, mailingDate, willDelete, deleteDate, willMigrate, migrateWeek, migrateDay, callMe, bestNumber, callReason, archiveCandidate, isLatest, adminOverride, note, appNameList, mailCount, migrationTimeId, createTime, updateTime);
    }
}
