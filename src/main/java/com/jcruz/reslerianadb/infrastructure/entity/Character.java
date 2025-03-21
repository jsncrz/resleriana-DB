package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "\"CHARACTER\"")
public class Character extends BaseEntity implements Serializable {

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(nullable = false, name = "ANOTHER_NAME")
    private String anotherName;

    @Column(nullable = false, name = "FULL_NAME")
    private String fullName;

    @Column(nullable = false, name = "ACQUISITION_TEXT")
    private String acquisitionText;

    @Column(nullable = false, name = "DESCRIPTION")
    private String description;

    @Column(nullable = false, name = "IS_ALCHEMIST")
    private boolean alchemist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String anotherName) {
        this.anotherName = anotherName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAcquisitionText() {
        return acquisitionText;
    }

    public void setAcquisitionText(String acquisitionText) {
        this.acquisitionText = acquisitionText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAlchemist() {
        return alchemist;
    }

    public void setAlchemist(boolean alchemist) {
        this.alchemist = alchemist;
    }
}
