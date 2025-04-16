package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MEMORIA_GROWTH")
public class MemoriaGrowth extends BaseEntityWithExtId implements Serializable {

    @Id
    @Column(nullable = false, name = "LEVEL")
    private int level;

    @Column(nullable = false, name = "STAT_VALUE")
    private int statValue;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemoriaGrowth that = (MemoriaGrowth) o;
        return level == that.level && getExtId() == that.getExtId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, getExtId());
    }
}
