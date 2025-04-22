package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "memoria_growth_key")
public class MemoriaGrowthKey implements Serializable {

    @Id
    @Column(nullable = false, name = "id")
    private int extId;

    @OneToMany(mappedBy = "memoriaGrowthKey")
    private Set<MemoriaGrowth> growths;

    public Set<MemoriaGrowth> getGrowths() {
        return growths;
    }

    public void setGrowths(Set<MemoriaGrowth> growths) {
        this.growths = growths;
    }

    public int getExtId() {
        return extId;
    }

    public void setExtId(int extId) {
        this.extId = extId;
    }

}
