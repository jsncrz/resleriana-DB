package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

public class TranslationId implements Serializable {

    @Id
    @Column(nullable = false, name = "id")
    private String extId;

    @Id
    @Column(nullable = false, name = "lang_code")
    private String language;

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
