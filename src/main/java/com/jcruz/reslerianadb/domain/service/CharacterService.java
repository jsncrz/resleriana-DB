package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.exception.NotFoundException;
import com.jcruz.reslerianadb.common.util.TranslationHelper;
import com.jcruz.reslerianadb.domain.model.CharacterResponse;
import com.jcruz.reslerianadb.domain.specification.CharacterSpec;
import com.jcruz.reslerianadb.domain.specification.MemoriaSpec;
import com.jcruz.reslerianadb.infrastructure.entity.Character;
import com.jcruz.reslerianadb.infrastructure.entity.Memoria;
import com.jcruz.reslerianadb.infrastructure.repository.CharacterRepository;
import com.jcruz.reslerianadb.infrastructure.repository.MemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class CharacterService {

    @Autowired
    private final CharacterRepository characterRepository;

    @Autowired
    private final TranslationHelper translationHelper;

    public CharacterService(CharacterRepository characterRepository, TranslationHelper translationHelper) {
        this.characterRepository = characterRepository;
        this.translationHelper = translationHelper;
    }

    public List<CharacterResponse> getCharactersByLanguage(String language) {
        List<Character> characters;
        Specification<Character> spec = where(CharacterSpec.languageIs(language));
        try {
            characters = this.characterRepository.findAll(spec, Sort.by(Sort.Direction.DESC, "releaseDate"));
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }

        List<CharacterResponse> res = new ArrayList<>();
        for (Character c : characters) {
            res.add(new CharacterResponse.Builder()
                    .id(c.getExtId())
                    .name(translationHelper.getTextForLang(c.getName(), language))
                    .anotherName(translationHelper.getTextForLang(c.getAnotherName(), language))
                    .initialRarity(c.getInitialRarity())
                    .attackAttribute(c.getAttackAttribute())
                    .role(c.getRole())
                    .alchemist(c.isAlchemist())
                    .build());
        }
        return res;
    }

    public CharacterResponse getCharacter(int id, String language) {
        Character chara;
        try {
            Specification<Character> spec = where(CharacterSpec.idIs(id));
            spec = spec.and(CharacterSpec.languageIs(language));
            Optional<Character> optC = this.characterRepository.findOne(spec);
            if (optC.isEmpty()) {
                throw new NotFoundException(Character.class.getName(), id);
            }
            chara = optC.get();
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
        return new CharacterResponse.Builder()
                .id(chara.getExtId())
                .name(translationHelper.getTextForLang(chara.getName(), language))
                .anotherName(translationHelper.getTextForLang(chara.getAnotherName(), language))
                .fullName(translationHelper.getTextForLang(chara.getFullName(), language))
                .description(translationHelper.getTextForLang(chara.getDescription(), language))
                .acquisitionText(translationHelper.getTextForLang(chara.getAcquisitionText(), language))
                .initialRarity(chara.getInitialRarity())
                .attackAttribute(chara.getAttackAttribute())
                .role(chara.getRole())
                .alchemist(chara.isAlchemist())
                .build();
    }
}
