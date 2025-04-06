package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.domain.model.CharacterStatsResponse;

public interface CharacterStatsService {
    CharacterStatsResponse getCharacterStat(int id);
}
