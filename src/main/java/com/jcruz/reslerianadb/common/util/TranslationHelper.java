package com.jcruz.reslerianadb.common.util;

import com.jcruz.reslerianadb.infrastructure.entity.Translation;
import com.jcruz.reslerianadb.infrastructure.entity.TranslationKey;
import org.springframework.stereotype.Component;

@Component
public class TranslationHelper {

    public String getTextForLang(TranslationKey key, String langCode) {
        return key.getTranslations().stream()
                .filter(t -> t.getLanguage().equals(langCode))
                .map(Translation::getText)
                .findFirst()
                .orElse("");
    }
}