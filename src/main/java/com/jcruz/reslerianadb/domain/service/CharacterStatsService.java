package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.exception.NotFoundException;
import com.jcruz.reslerianadb.domain.model.CharacterStatsResponse;
import com.jcruz.reslerianadb.infrastructure.entity.Character;
import com.jcruz.reslerianadb.infrastructure.entity.CharacterStatus;
import com.jcruz.reslerianadb.infrastructure.repository.CharacterStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterStatsService {

    @Autowired
    private final CharacterStatsRepository characterStatRepository;

    public CharacterStatsService(CharacterStatsRepository characterStatRepository) {
        this.characterStatRepository = characterStatRepository;
    }

    public CharacterStatsResponse getCharacterStat(int id) {
        CharacterStatus c;
        try {
            Optional<CharacterStatus> optC = this.characterStatRepository.findById(id);
            if (optC.isEmpty()) {
                throw new NotFoundException(Character.class.getName(), id);
            } else {
                c = optC.get();
            }
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
        return new CharacterStatsResponse.Builder()
                .attack(c.getAttack())
                .magic(c.getMagic())
                .hp(c.getHp())
                .defense(c.getDefense())
                .mental(c.getMental())
                .speed(c.getSpeed())
                .build();
    }
}
