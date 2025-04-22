package com.jcruz.reslerianadb.domain.specification;

import com.jcruz.reslerianadb.infrastructure.entity.Memoria;
import com.jcruz.reslerianadb.infrastructure.entity.Translation;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class MemoriaSpec {

    public static Specification<Memoria> idIs(int id) {
        return (memoriaRoot, query, builder)
                -> builder.equal(memoriaRoot.get("extId"), id);
    }

    public static Specification<Memoria> rarityIs(int rarity) {
        return (memoriaRoot, query, builder)
                -> builder.equal(memoriaRoot.get("rarity"), rarity);
    }

    public static Specification<Memoria> languageIs(String language) {
        return (memoriaRoot, query, builder) -> {
            if (query != null && Long.class != query.getResultType()) {
                // Need to cast Fetch to Join to use it in conditions
                @SuppressWarnings("unchecked") Join<Object, Object> name
                        = (Join<Object, Object>) memoriaRoot.fetch("name", JoinType.LEFT);
                @SuppressWarnings("unchecked") Join<Object, Object> description
                        = (Join<Object, Object>) memoriaRoot.fetch("description", JoinType.LEFT);
                Predicate nameBuilder = builder.equal(name.get("language"), language);
                Predicate descriptionBuilder = builder.equal(description.get("language"), language);
                return builder.and(nameBuilder, descriptionBuilder);
            }
            return null;
        };
    }

}