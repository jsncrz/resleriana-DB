package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;

import java.io.Serializable;

@Entity
@Table(name = "TAG")
public class Tag extends BaseEntityWithExtId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NAME", referencedColumnName = "TL_ID")
    @Filter(
            name="translationByLocale",
            condition = "LANGUAGE = :locale"
    )
    private Translation name;

    @Column(nullable = false, name = "PRIORITY")
    private int priority;

    public Translation getName() {
        return name;
    }

    public void setName(Translation name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
