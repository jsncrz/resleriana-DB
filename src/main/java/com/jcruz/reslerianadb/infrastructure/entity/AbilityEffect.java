package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;

import java.io.Serializable;

@Entity
@Table(name = "ability_effect")
public class AbilityEffect extends BaseEntity implements Serializable {

    @EmbeddedId
    private AbilityEffectKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("abilityId")
    @JoinColumn(name = "ability_id", referencedColumnName = "id")
    private Ability ability;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("effectId")
    @JoinColumn(name = "effect_id", referencedColumnName = "id")
    private Effect effect;

    @Column(nullable = false, name = "number_value")
    private int value;

    public AbilityEffectKey getId() {
        return id;
    }

    public void setId(AbilityEffectKey id) {
        this.id = id;
    }

    public int getEffectId() {
        return getId().getEffectID();
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
