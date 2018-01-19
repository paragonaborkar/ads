package com.netapp.ads.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class QtreePK implements Serializable {
    private Integer id;
    private Integer nasVolumeId;

    @Column(name = "id", nullable = false)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nas_volume_id", nullable = false)
    @Id
    public Integer getNasVolumeId() {
        return nasVolumeId;
    }

    public void setNasVolumeId(Integer nasVolumeId) {
        this.nasVolumeId = nasVolumeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QtreePK qtreePK = (QtreePK) o;
        return Objects.equals(id, qtreePK.id) &&
                Objects.equals(nasVolumeId, qtreePK.nasVolumeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nasVolumeId);
    }
}
