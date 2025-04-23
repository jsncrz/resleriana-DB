package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TAG")
public class Tag extends BaseEntityWithId implements Serializable {

    @Column(nullable = false, name = "PRIORITY")
    private int priority;

    @ManyToOne
    @JoinColumn(name = "tag_name", referencedColumnName = "id", insertable = false, updatable = false)
    private TranslationKey tagName;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TranslationKey getTagName() {
        return tagName;
    }

    public void setTagName(TranslationKey tagName) {
        this.tagName = tagName;
    }
}
