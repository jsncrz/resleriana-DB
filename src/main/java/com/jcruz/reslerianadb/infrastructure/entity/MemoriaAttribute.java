package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "memoria_attribute")
public class MemoriaAttribute extends BaseEntity implements Serializable {

    @EmbeddedId
    private MemoriaKey id;

    @ManyToOne
    @MapsId("memoriaId")
    @JoinColumn(name = "memoria_id", referencedColumnName = "id")
    private Memoria memoria;

    @Column(nullable = false, name = "memoria_attribute")
    private String attribute;

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }


    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public MemoriaKey getId() {
        return id;
    }

    public void setId(MemoriaKey id) {
        this.id = id;
    }
}
