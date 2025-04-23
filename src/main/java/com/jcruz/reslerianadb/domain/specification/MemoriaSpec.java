package com.jcruz.reslerianadb.domain.specification;

import com.jcruz.reslerianadb.common.util.TranslationHelper;
import com.jcruz.reslerianadb.infrastructure.entity.Memoria;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public class MemoriaSpec {

    public static Specification<Memoria> idsIn(List<Integer> ids) {
        return (memoriaRoot, query, builder)
                -> builder.in(memoriaRoot.get("extId")).value(ids);
    }


    public static Specification<Memoria> idIs(int id) {
        return (memoriaRoot, query, builder)
                -> builder.equal(memoriaRoot.get("extId"), id);
    }

    public static Specification<Memoria> rarityIs(int rarity) {
        return (memoriaRoot, query, builder)
                -> builder.equal(memoriaRoot.get("rarity"), rarity);
    }

    public static Specification<Memoria> fetchTranslations() {
        return (memoriaRoot, query, builder) -> {
            if (query != null && Long.class != query.getResultType()) {
                TranslationHelper.fetchTranslations(memoriaRoot, "name");
                TranslationHelper.fetchTranslations(memoriaRoot, "description");
                query.distinct(true);
            }
            return builder.conjunction();
        };
    }

    @SuppressWarnings("unchecked")
    public static Specification<Memoria> fetchAbilities() {
        return (memoriaRoot, query, builder) -> {
            if (query != null && Long.class != query.getResultType()) {
                Join<Object, Object> ability = (Join<Object, Object>) memoriaRoot.fetch("memoriaAbility", JoinType.INNER);
                TranslationHelper.fetchTranslations(ability, "name");
                TranslationHelper.fetchTranslations(ability, "description");
                ability.fetch("abilityEffects", JoinType.INNER);

                query.distinct(true);
            }
            return builder.conjunction();
        };
    }

}