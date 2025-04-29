package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill extends BaseEntityWithId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "skill_name", referencedColumnName = "id", insertable = false, updatable = false)
    private TranslationKey name;

    @ManyToOne
    @JoinColumn(name = "skill_description", referencedColumnName = "id", insertable = false, updatable = false)
    private TranslationKey description;

    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private Set<SkillEffect> skillEffects;

    @ManyToOne
    @JoinColumn(name = "linked_skill", referencedColumnName = "id", insertable = false, updatable = false)
    private Skill linkedSkill;

    @Column(name="skill_power")
    private Integer power;

    @Column(name="skill_break_power")
    private Integer breakPower;

    @Column(name="skill_wait")
    private Integer skillWait;

    @Column(name="skill_attribute")
    private String attribute;

    @Column(name="skill_effect_type")
    private String effectType;

    @Column(name="skill_target_type")
    private String targetType;

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

    public Set<SkillEffect> getSkillEffects() {
        return skillEffects;
    }

    public void setSkillEffects(Set<SkillEffect> skillEffects) {
        this.skillEffects = skillEffects;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getBreakPower() {
        return breakPower;
    }

    public void setBreakPower(Integer breakPower) {
        this.breakPower = breakPower;
    }

    public Integer getSkillWait() {
        return skillWait;
    }

    public void setSkillWait(Integer skillWait) {
        this.skillWait = skillWait;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getEffectType() {
        return effectType;
    }

    public void setEffectType(String effectType) {
        this.effectType = effectType;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public Skill getLinkedSkill() {
        return linkedSkill;
    }

    public void setLinkedSkill(Skill linkedSkill) {
        this.linkedSkill = linkedSkill;
    }
}
