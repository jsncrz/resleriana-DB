package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.io.Serializable;

@Entity
@Table(name = "\"TRANSLATION\"")
@FilterDef(name = "translationByLanguage",
        parameters = @ParamDef(name = "language", type = String.class),
        defaultCondition = "language = 'jp'")
public class Translation extends BaseEntity implements Serializable {

    @Id
    @Column(nullable = false, name = "TL_ID")
    private String tlId;

    @Filter(
            name="translationByLanguage",
            condition = "LANGUAGE = :language"
    )
    @Column(nullable = false, name = "LANGUAGE")
    private String language;

    @Column(nullable = false, name = "TEXT")
    private String text;

    public String getTlId() {
        return tlId;
    }

    public void setTlId(String tlId) {
        this.tlId = tlId;
    }

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
}
