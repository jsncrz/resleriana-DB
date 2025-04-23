package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MEMORIA_GROWTH")
@IdClass(MemoriaGrowthId.class)
public class MemoriaGrowth extends BaseEntity implements Serializable {

    @Id
    @Column(nullable = false, name = "id")
    private int extId;

    @Id
    @Column(nullable = false, name = "memoria_level")
    private int level;

    @Column(nullable = false, name = "stat_value")
    private int statValue;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private MemoriaGrowthKey memoriaGrowthKey;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatValue() {
        return statValue;
    }

    public void setStatValue(int statValue) {
        this.statValue = statValue;
    }

    public int getExtId() {
        return extId;
    }

    public void setExtId(int extId) {
        this.extId = extId;
    }

    public MemoriaGrowthKey getMemoriaGrowthKey() {
        return memoriaGrowthKey;
    }

    public void setMemoriaGrowthKey(MemoriaGrowthKey memoriaGrowthKey) {
        this.memoriaGrowthKey = memoriaGrowthKey;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemoriaGrowth that = (MemoriaGrowth) o;
        return level == that.level && extId == that.extId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, extId);
    }
}
