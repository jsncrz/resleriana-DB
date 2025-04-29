package com.jcruz.reslerianadb.domain.specification;

import com.jcruz.reslerianadb.infrastructure.entity.CharacterSkill;
import org.springframework.data.jpa.domain.Specification;

public class CharacterSkillSpec {

    public static Specification<CharacterSkill> characterIdIs(int id) {
        return (characterSkillRoot, query, builder)
                -> builder.equal(characterSkillRoot.get("id").get("characterId"), id);
    }

}