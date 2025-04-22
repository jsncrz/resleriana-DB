package com.jcruz.reslerianadb.domain.specification;

import com.jcruz.reslerianadb.infrastructure.entity.Memoria;
import com.jcruz.reslerianadb.infrastructure.entity.Translation;
import com.jcruz.reslerianadb.infrastructure.entity.TranslationKey;
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

    @SuppressWarnings("unchecked")
    public static Specification<Memoria> languageIs(String language) {
        return (memoriaRoot, query, builder) -> {
            if (query != null && Long.class != query.getResultType()) {
                Join<Object, Object> name = (Join<Object, Object>)memoriaRoot.fetch("name", JoinType.INNER);
                Join<Object, Object> nameTlJoin = (Join<Object, Object>)name.fetch("translations", JoinType.LEFT);
                nameTlJoin.on(builder.equal(nameTlJoin.get("language"), language));
                Join<Object, Object> description  = (Join<Object, Object>)memoriaRoot.fetch("description", JoinType.INNER);
                Join<Object, Object> descriptionTlJoin = (Join<Object, Object>)description.fetch("translations", JoinType.LEFT);
                descriptionTlJoin.on(builder.equal(descriptionTlJoin.get("language"), language));
                query.distinct(true);

            }
            return builder.conjunction();
        };
    }

}