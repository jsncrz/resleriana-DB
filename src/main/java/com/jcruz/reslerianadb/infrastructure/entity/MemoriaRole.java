package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "MEMORIA_ROLE")
public class MemoriaRole extends BaseEntity implements Serializable {

    @EmbeddedId
    private MemoriaKey id;

    @ManyToOne
    @MapsId("memoriaId")
    @JoinColumn(name = "MEMORIA_ID", referencedColumnName = "EXT_ID")
    private Memoria memoria;

    @Column(nullable = false, name = "ROLE")
    private String role;

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MemoriaKey getId() {
        return id;
    }

    public void setId(MemoriaKey id) {
        this.id = id;
    }
}
