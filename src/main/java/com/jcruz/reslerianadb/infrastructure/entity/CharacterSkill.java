package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "character_skill")
public class CharacterSkill extends BaseEntity implements Serializable {

    @EmbeddedId
    private CharacterSkillKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("characterId")
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skill skill;

    @Column(name = "skill_type", nullable = false)
    private String skillType;

    public CharacterSkillKey getId() {
        return id;
    }

    public void setId(CharacterSkillKey id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
