package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "translation_keys")
public class TranslationKey implements Serializable {

    @Id
    @Column(nullable = false, name = "id")
    private String extId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "translationKey")
    private Set<Translation> translations;

    public Set<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Translation> translations) {
        this.translations = translations;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }
}
