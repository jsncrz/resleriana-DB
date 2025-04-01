package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.domain.model.DetailedCharacterResponse;
import com.jcruz.reslerianadb.domain.model.SimpleCharacterResponse;

import java.util.List;

public interface CharacterService {
    List<SimpleCharacterResponse> getCharacters();
    DetailedCharacterResponse getCharacter(int id);
}
