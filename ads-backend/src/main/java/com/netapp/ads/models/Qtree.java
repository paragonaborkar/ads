package com.netapp.ads.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(QtreePK.class)
public class Qtree {
    private Integer id;
    private Integer nasVolumeId;
    private String qtreeName;
    private Long quotaHardCapacityLimitMb;
    private Long quotaSoftCapacityLimitMb;
    private Long quotaUsedCapacityLimitMb;
    private String qtreeType;
    private String securityStyle;
    private String qtreeStatus;
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

    @Id
    @Column(name = "nas_volume_id", nullable = false)
    public Integer getNasVolumeId() {
        return nasVolumeId;
    }

    public void setNasVolumeId(Integer nasVolumeId) {
        this.nasVolumeId = nasVolumeId;
    }

    @Basic
    @Column(name = "qtree_name", nullable = true, length = 225)
    public String getQtreeName() {
        return qtreeName;
    }

    public void setQtreeName(String qtreeName) {
        this.qtreeName = qtreeName;
    }

    @Basic
    @Column(name = "quota_hard_capacity_limit_mb", nullable = true)
    public Long getQuotaHardCapacityLimitMb() {
        return quotaHardCapacityLimitMb;
    }

    public void setQuotaHardCapacityLimitMb(Long quotaHardCapacityLimitMb) {
        this.quotaHardCapacityLimitMb = quotaHardCapacityLimitMb;
    }

    @Basic
    @Column(name = "quota_soft_capacity_limit_mb", nullable = true)
    public Long getQuotaSoftCapacityLimitMb() {
        return quotaSoftCapacityLimitMb;
    }

    public void setQuotaSoftCapacityLimitMb(Long quotaSoftCapacityLimitMb) {
        this.quotaSoftCapacityLimitMb = quotaSoftCapacityLimitMb;
    }

    @Basic
    @Column(name = "quota_used_capacity_limit_mb", nullable = true)
    public Long getQuotaUsedCapacityLimitMb() {
        return quotaUsedCapacityLimitMb;
    }

    public void setQuotaUsedCapacityLimitMb(Long quotaUsedCapacityLimitMb) {
        this.quotaUsedCapacityLimitMb = quotaUsedCapacityLimitMb;
    }

    @Basic
    @Column(name = "qtree_type", nullable = true)
    public String getQtreeType() {
        return qtreeType;
    }

    public void setQtreeType(String qtreeType) {
        this.qtreeType = qtreeType;
    }

    @Basic
    @Column(name = "security_style", nullable = true)
    public String getSecurityStyle() {
        return securityStyle;
    }

    public void setSecurityStyle(String securityStyle) {
        this.securityStyle = securityStyle;
    }

    @Basic
    @Column(name = "qtree_status", nullable = true, length = 225)
    public String getQtreeStatus() {
        return qtreeStatus;
    }

    public void setQtreeStatus(String qtreeStatus) {
        this.qtreeStatus = qtreeStatus;
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
        Qtree qtree = (Qtree) o;
        return Objects.equals(id, qtree.id) &&
                Objects.equals(nasVolumeId, qtree.nasVolumeId) &&
                Objects.equals(qtreeName, qtree.qtreeName) &&
                Objects.equals(quotaHardCapacityLimitMb, qtree.quotaHardCapacityLimitMb) &&
                Objects.equals(quotaSoftCapacityLimitMb, qtree.quotaSoftCapacityLimitMb) &&
                Objects.equals(quotaUsedCapacityLimitMb, qtree.quotaUsedCapacityLimitMb) &&
                Objects.equals(qtreeType, qtree.qtreeType) &&
                Objects.equals(securityStyle, qtree.securityStyle) &&
                Objects.equals(qtreeStatus, qtree.qtreeStatus) &&
                Objects.equals(createTime, qtree.createTime) &&
                Objects.equals(updateTime, qtree.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nasVolumeId, qtreeName, quotaHardCapacityLimitMb, quotaSoftCapacityLimitMb, quotaUsedCapacityLimitMb, qtreeType, securityStyle, qtreeStatus, createTime, updateTime);
    }
}
