package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.exception.NotFoundException;
import com.jcruz.reslerianadb.domain.model.DetailedCharacterResponse;
import com.jcruz.reslerianadb.domain.model.SimpleCharacterResponse;
import com.jcruz.reslerianadb.infrastructure.entity.Character;
import com.jcruz.reslerianadb.infrastructure.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<SimpleCharacterResponse> getCharacters() {
        List<Character> characters;
        try {
            characters = this.characterRepository.findAll();
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }

        List<SimpleCharacterResponse> res = new ArrayList<>();
        for (Character c : characters) {
            res.add(new SimpleCharacterResponse.Builder()
                    .name(c.getName().getText())
                    .anotherName(c.getAnotherName().getText())
                    .initialRarity(c.getInitialRarity())
                    .attackAttribute(c.getAttackAttribute())
                    .alchemist(c.isAlchemist())
                    .build());
        }
        return res;
    }

    @Override
    public DetailedCharacterResponse getCharacter(int id) {
        Character c;
        try {
            Optional<Character> optC = this.characterRepository.findById(id);
            if (optC.isEmpty()) {
                throw new NotFoundException(Character.class.getName(), id);
            } else {
                c = optC.get();
            }
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
        return new DetailedCharacterResponse.Builder()
                        .name(c.getName().getText())
                        .anotherName(c.getAnotherName().getText())
                        .fullName(c.getFullName().getText())
                        .description(c.getDescription().getText())
                        .acquisitionText(c.getAcquisitionText().getText())
                        .alchemist(c.isAlchemist())
                        .build();
    }
}
