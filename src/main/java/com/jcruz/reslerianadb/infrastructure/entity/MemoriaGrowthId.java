package com.jcruz.reslerianadb.infrastructure.entity;

import java.io.Serializable;
import java.util.Objects;

public class MemoriaGrowthId implements Serializable {

    private int extId;

    private int level;

    public int getExtId() {
        return extId;
    }

    public void setExtId(int extId) {
        this.extId = extId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemoriaGrowthId that)) return false;
        return Objects.equals(extId, that.extId) && Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extId, level);
    }
}
