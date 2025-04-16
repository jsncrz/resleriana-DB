package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "EFFECT")
public class Effect extends BaseEntityWithExtId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NAME", referencedColumnName = "TL_ID")
    @Filter(
            name="translationByLanguage",
            condition = "LANGUAGE = :language"
    )
    private Translation name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DESCRIPTION", referencedColumnName = "TL_ID")
    @Filter(
            name="translationByLanguage",
            condition = "LANGUAGE = :language"
    )
    private Translation description;

    @OneToMany (mappedBy = "effect")
    private Set<AbilityEffect> abilityEffects;

    public Translation getName() {
        return name;
    }

    public void setName(Translation name) {
        this.name = name;
    }

    public Translation getDescription() {
        return description;
    }

    public void setDescription(Translation description) {
        this.description = description;
    }

    public Set<AbilityEffect> getAbilityEffects() {
        return abilityEffects;
    }

    public void setAbilityEffects(Set<AbilityEffect> abilityEffects) {
        this.abilityEffects = abilityEffects;
    }
}
