package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntityWithId extends BaseEntity {

    @Id
    @Column(nullable = false, name = "id")
    private int extId;

    public int getExtId() {
        return extId;
    }

    public void setExtId(int extId) {
        this.extId = extId;
    }
}
