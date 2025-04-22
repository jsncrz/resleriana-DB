package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ability")
public class Ability extends BaseEntityWithId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ability_name", referencedColumnName = "id", insertable = false, updatable = false)
    private TranslationKey name;

    @ManyToOne
    @JoinColumn(name = "ability_description", referencedColumnName = "id", insertable = false, updatable = false)
    private TranslationKey description;

    @OneToMany(mappedBy = "ability")
    private Set<AbilityEffect> abilityEffects;

    public TranslationKey getName() {
        return name;
    }

    public void setName(TranslationKey name) {
        this.name = name;
    }

    public TranslationKey getDescription() {
        return description;
    }

    public void setDescription(TranslationKey description) {
        this.description = description;
    }

    public Set<AbilityEffect> getAbilityEffects() {
        return abilityEffects;
    }

    public void setAbilityEffects(Set<AbilityEffect> abilityEffects) {
        this.abilityEffects = abilityEffects;
    }
}
