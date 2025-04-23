package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AbilityEffectKey implements Serializable {

    @Column(name = "ability_id")
    private int abilityId;

    @Column(name = "effect_id")
    private int effectID;

    public int getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(int abilityId) {
        this.abilityId = abilityId;
    }

    public int getEffectID() {
        return effectID;
    }

    public void setEffectID(int effectID) {
        this.effectID = effectID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbilityEffectKey that = (AbilityEffectKey) o;
        return abilityId == that.abilityId && effectID == that.effectID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abilityId, effectID);
    }
}
