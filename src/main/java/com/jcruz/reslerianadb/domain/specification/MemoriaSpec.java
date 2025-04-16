package com.jcruz.reslerianadb.domain.specification;

import com.jcruz.reslerianadb.infrastructure.entity.Memoria;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class MemoriaSpec {

    public static Specification<Memoria> rarityIs(int rarity) {
        return (memoriaRoot, query, builder) -> {
            return builder.equal(memoriaRoot.get("rarity"), rarity);
        };
    }

    public static Specification<Memoria> languageIs(String language) {
        return (memoriaRoot, query, builder) -> {
            Predicate nameBuilder = builder.equal(memoriaRoot.get("name").get("language"), language);
            Predicate descriptionBuilder = builder.equal(memoriaRoot.get("description").get("language"), language);
            return builder.and(nameBuilder, descriptionBuilder);
        };
    }

}