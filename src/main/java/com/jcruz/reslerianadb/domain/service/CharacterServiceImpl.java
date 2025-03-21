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
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterResponse> getCharacters() {
        List<Character> characters;
        try {
            characters = this.characterRepository.findAll();
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }

        List<CharacterResponse> res = new ArrayList<>();
        for (Character c : characters) {
            res.add(new CharacterResponse.Builder()
                    .name(c.getName())
                    .anotherName(c.getAnotherName())
                    .fullName(c.getFullName())
                    .description(c.getDescription())
                    .acquisitionText(c.getAcquisitionText())
                    .alchemist(c.isAlchemist())
                    .build());
        }
        return res;
    }

    @Override
    public CharacterResponse getCharacter(int id) {
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
        return new CharacterResponse.Builder()
                        .name(c.getName())
                        .anotherName(c.getAnotherName())
                        .fullName(c.getFullName())
                        .description(c.getDescription())
                        .acquisitionText(c.getAcquisitionText())
                        .alchemist(c.isAlchemist())
                        .build();
    }
}
