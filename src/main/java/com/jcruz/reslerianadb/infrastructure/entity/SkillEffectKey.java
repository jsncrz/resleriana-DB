package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SkillEffectKey implements Serializable {

    @Column(name = "skill_id")
    private int skillId;

    @Column(name = "effect_id")
    private int effectID;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
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
        SkillEffectKey that = (SkillEffectKey) o;
        return skillId == that.skillId && effectID == that.effectID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId, effectID);
    }
}
