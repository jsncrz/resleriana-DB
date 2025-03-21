package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.domain.model.CharacterResponse;

import java.util.List;

public interface CharacterService {
    List<CharacterResponse> getCharacters();
    CharacterResponse getCharacter(int id);
}
