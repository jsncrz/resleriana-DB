package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.exception.NotFoundException;
import com.jcruz.reslerianadb.common.util.TranslationHelper;
import com.jcruz.reslerianadb.domain.model.TagResponse;
import com.jcruz.reslerianadb.domain.specification.CharacterSpec;
import com.jcruz.reslerianadb.infrastructure.entity.Character;
import com.jcruz.reslerianadb.infrastructure.entity.Tag;
import com.jcruz.reslerianadb.infrastructure.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class TagService {

    @Autowired
    private final CharacterRepository repository;

    @Autowired
    private final TranslationHelper translationHelper;

    public TagService(CharacterRepository repository, TranslationHelper helper) {
        this.repository = repository;
        this.translationHelper = helper;
    }

    public List<TagResponse> getTagsByCharacterIdAndLanguage(Integer id, String language) {
        Character character;
        Set<Tag> tags;
        Specification<Character> spec = where(CharacterSpec.idIs(id));
        spec.and(CharacterSpec.tagLanguageIs(language));
        try {
            Optional<Character> optC = this.repository.findOne(spec);
            if (optC.isEmpty()) {
                throw new NotFoundException(Character.class.getName(), id);
            }
            character = optC.get();
            tags = character.getCharacterTags();
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }

        return tags.stream().sorted(Comparator.comparingInt(Tag::getPriority)).map(tag -> new TagResponse.Builder()
                .id(tag.getExtId())
                .name(translationHelper.getTextForLang(tag.getTagName(), language))
                .build()).collect(Collectors.toList());
    }

}
