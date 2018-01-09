package com.netapp.ads.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "host")
public class Host {
    private Integer id;
    private String hostName;
    private String ipAddr;
    private Integer hostOwnerUserCorporateId;
    private String note;
    private Integer systemAdminId;
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
    @Column(name = "host_name", nullable = true, length = 255)
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Basic
    @Column(name = "ip_addr", nullable = true, length = 255)
    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    @Basic
    @Column(name = "host_owner_user_corporate_id", nullable = true)
    public Integer getHostOwnerUserCorporateId() {
        return hostOwnerUserCorporateId;
    }

    public void setHostOwnerUserCorporateId(Integer hostOwnerUserCorporateId) {
        this.hostOwnerUserCorporateId = hostOwnerUserCorporateId;
    }

    @Basic
    @Column(name = "note", nullable = true, length = 255)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "system_admin_id", nullable = true)
    public Integer getSystemAdminId() {
        return systemAdminId;
    }

    public void setSystemAdminId(Integer systemAdminId) {
        this.systemAdminId = systemAdminId;
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
        Host that = (Host) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(hostName, that.hostName) &&
                Objects.equals(ipAddr, that.ipAddr) &&
                Objects.equals(hostOwnerUserCorporateId, that.hostOwnerUserCorporateId) &&
                Objects.equals(note, that.note) &&
                Objects.equals(systemAdminId, that.systemAdminId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, hostName, ipAddr, hostOwnerUserCorporateId, note, systemAdminId, createTime, updateTime);
    }
}
