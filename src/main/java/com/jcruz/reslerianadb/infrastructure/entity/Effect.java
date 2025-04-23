package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "effect")
public class Effect extends BaseEntityWithId implements Serializable {

    @Column(name = "effect_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "effect_description", referencedColumnName = "id", insertable = false, updatable = false)
    private TranslationKey descriptionKey;

    @OneToMany (mappedBy = "effect")
    private Set<AbilityEffect> abilityEffects;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TranslationKey getDescriptionKey() {
        return descriptionKey;
    }

    public void setDescriptionKey(TranslationKey descriptionKey) {
        this.descriptionKey = descriptionKey;
    }

    public Set<AbilityEffect> getAbilityEffects() {
        return abilityEffects;
    }

    public void setAbilityEffects(Set<AbilityEffect> abilityEffects) {
        this.abilityEffects = abilityEffects;
    }
}
