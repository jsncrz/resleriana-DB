package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "skill_effect")
public class SkillEffect extends BaseEntity implements Serializable {

    @EmbeddedId
    private SkillEffectKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("skillId")
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skill skill;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("effectId")
    @JoinColumn(name = "effect_id", referencedColumnName = "id")
    private Effect effect;

    @Column(nullable = false, name = "number_value")
    private int value;

    @Column(name = "skill_effect_index")
    private Integer skillEffectIndex;

    public SkillEffectKey getId() {
        return id;
    }

    public void setId(SkillEffectKey id) {
        this.id = id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
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

    public Integer getSkillEffectIndex() {
        return skillEffectIndex;
    }

    public void setSkillEffectIndex(Integer skillEffectIndex) {
        this.skillEffectIndex = skillEffectIndex;
    }
}
