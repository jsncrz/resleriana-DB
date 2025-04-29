package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CharacterSkillKey implements Serializable {

    @Column(name = "character_id")
    private int characterId;

    @Column(name = "skill_id")
    private int skillId;

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CharacterSkillKey that = (CharacterSkillKey) o;
        return characterId == that.characterId && skillId == that.skillId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, skillId);
    }
}
