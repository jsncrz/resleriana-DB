package com.jcruz.reslerianadb.domain.specification;

import com.jcruz.reslerianadb.infrastructure.entity.AbilityEffect;
import com.jcruz.reslerianadb.infrastructure.entity.Memoria;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class AbilityEffectSpec {

    public static Specification<AbilityEffect> idIs(int id) {
        return (memoriaRoot, query, builder)
                -> builder.equal(memoriaRoot.get("extId"), id);
    }

}