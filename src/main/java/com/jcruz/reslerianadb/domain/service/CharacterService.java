package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.exception.NotFoundException;
import com.jcruz.reslerianadb.domain.model.CharacterResponse;
import com.jcruz.reslerianadb.infrastructure.entity.Character;
import com.jcruz.reslerianadb.infrastructure.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterResponse> getCharactersByLanguage(String language) {
        List<Character> characters;
        try {
            characters = this.characterRepository.findSimpleByLanguage(language);
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }

        List<CharacterResponse> res = new ArrayList<>();
        for (Character c : characters) {
            res.add(new CharacterResponse.Builder()
                    .id(c.getExtId())
//                    .name(c.getName().getText())
//                    .anotherName(c.getAnotherName().getText())
                    .initialRarity(c.getInitialRarity())
                    .attackAttribute(c.getAttackAttribute())
                    .role(c.getRole())
                    .alchemist(c.isAlchemist())
                    .build());
        }
        return res;
    }

    public CharacterResponse getCharacter(int id, String language) {
        Character c;
        try {
            Optional<Character> optC = this.characterRepository.findByExtIdAndLanguage(id, language);
            if (optC.isEmpty()) {
                optC = this.characterRepository.findByExtIdAndLanguage(id, "jp");
                if (optC.isEmpty()) {
                    throw new NotFoundException(Character.class.getName(), id);
                }
            }
            c = optC.get();
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
        return new CharacterResponse.Builder()
                .id(c.getExtId())
//                .name(c.getName().getText())
//                .anotherName(c.getAnotherName().getText())
//                .fullName(c.getFullName().getText())
//                .description(c.getDescription().getText())
//                .acquisitionText(c.getAcquisitionText().getText())
                .initialRarity(c.getInitialRarity())
                .attackAttribute(c.getAttackAttribute())
                .role(c.getRole())
                .alchemist(c.isAlchemist())
                .build();
    }
}
