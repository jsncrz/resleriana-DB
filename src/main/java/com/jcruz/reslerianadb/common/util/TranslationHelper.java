package com.jcruz.reslerianadb.common.util;

import com.jcruz.reslerianadb.infrastructure.entity.Translation;
import com.jcruz.reslerianadb.infrastructure.entity.TranslationKey;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

@Component
public class TranslationHelper {

    public String getTextForLang(TranslationKey key, String langCode) {
        return key.getTranslations().stream()
                .filter(t -> t.getLanguage().equals(langCode))
                .map(Translation::getText)
                .findFirst()
                .orElseGet(() -> key.getTranslations().stream()
                        .filter(t -> t.getLanguage().equals("jp"))
                        .map(Translation::getText)
                        .findFirst().orElse(""));
    }

    @SuppressWarnings("unchecked")
    public static void fetchTranslations(Root<?> root, String name) {
        Join<Object, Object> translatable = (Join<Object, Object>) root.fetch(name, JoinType.INNER);
        translatable.fetch("translations", JoinType.LEFT);
    }

    @SuppressWarnings("unchecked")
    public static void fetchTranslations(Join<?, ?> join, String name) {
        Join<Object, Object> translatable = (Join<Object, Object>) join.fetch(name, JoinType.INNER);
        translatable.fetch("translations", JoinType.LEFT);
    }
}