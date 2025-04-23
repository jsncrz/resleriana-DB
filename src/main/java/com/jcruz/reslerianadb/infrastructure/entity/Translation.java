package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "translations")
@IdClass(TranslationId.class)
public class Translation extends BaseEntityWithStringId implements Serializable {

    @Id
    @Column(nullable = false, name = "lang_code")
    private String language;

    @Column(nullable = false, name = "translated_text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private TranslationKey translationKey;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TranslationKey getTranslationKey() {
        return translationKey;
    }

    public void setTranslationKey(TranslationKey translationKey) {
        this.translationKey = translationKey;
    }
}
