package com.jcruz.reslerianadb.domain.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import com.jcruz.reslerianadb.infrastructure.entity.Character;

import static com.jcruz.reslerianadb.common.util.TranslationHelper.fetchTranslations;

public class CharacterSpec {

    public static Specification<Character> idIs(int id) {
        return (charaRoot, query, builder)
                -> builder.equal(charaRoot.get("extId"), id);
    }

    public static Specification<Character> initialRarityIs(int rarity) {
        return (charaRoot, query, builder)
                -> builder.equal(charaRoot.get("initialRarity"), rarity);
    }

    @SuppressWarnings("unchecked")
    public static Specification<Character> languageIs(String language) {
        return (charaRoot, query, builder) -> {
            if (query != null && Long.class != query.getResultType()) {
                fetchTranslations(charaRoot, "name");
                fetchTranslations(charaRoot, "description");
                fetchTranslations(charaRoot, "acquisitionText");
                fetchTranslations(charaRoot, "anotherName");
                fetchTranslations(charaRoot, "fullName");
                query.distinct(true);
            }
            return builder.conjunction();
        };
    }

    @SuppressWarnings("unchecked")
    public static Specification<Character> tagLanguageIs(String language) {
        return (charaRoot, query, builder) -> {
            if (query != null && Long.class != query.getResultType()) {
                Join<Object, Object> tags = (Join<Object, Object>)charaRoot.fetch("characterTags", JoinType.INNER);
                fetchTranslations(tags, "tagName");
                query.distinct(true);
            }
            return null;
        };
    }

}