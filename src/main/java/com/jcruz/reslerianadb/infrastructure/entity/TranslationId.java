package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TranslationId that = (TranslationId) o;
        return Objects.equals(extId, that.extId) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extId, language);
    }
}
