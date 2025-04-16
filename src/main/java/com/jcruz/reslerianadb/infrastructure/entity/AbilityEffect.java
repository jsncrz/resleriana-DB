package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;

import java.io.Serializable;

@Entity
@Table(name = "ABILITY_EFFECT")
public class AbilityEffect extends BaseEntity implements Serializable {

    @EmbeddedId
    private AbilityEffectKey id;

    @ManyToOne
    @MapsId("abilityId")
    @JoinColumn(name = "ABILITY_ID", referencedColumnName = "EXT_ID")
    private Ability ability;

    @ManyToOne
    @MapsId("effectId")
    @JoinColumn(name = "EFFECT_ID", referencedColumnName = "EXT_ID")
    private Effect effect;

    @Column(nullable = false, name = "VALUE")
    private int value;

    public AbilityEffectKey getId() {
        return id;
    }

    public void setId(AbilityEffectKey id) {
        this.id = id;
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
