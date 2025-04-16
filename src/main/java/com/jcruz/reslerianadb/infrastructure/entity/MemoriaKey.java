package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MemoriaKey implements Serializable {

    @Column(name = "MEMORIA_ID")
    private int memoriaId;

    public int getMemoriaId() {
        return memoriaId;
    }
    public void setMemoriaId(int memoriaId) {
        this.memoriaId = memoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemoriaKey that = (MemoriaKey) o;
        return memoriaId == that.memoriaId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(memoriaId);
    }
}
