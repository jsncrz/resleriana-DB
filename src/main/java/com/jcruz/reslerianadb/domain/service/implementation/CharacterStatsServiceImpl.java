package com.jcruz.reslerianadb.domain.service.implementation;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.exception.NotFoundException;
import com.jcruz.reslerianadb.domain.model.CharacterStatsResponse;
import com.jcruz.reslerianadb.domain.service.CharacterStatsService;
import com.jcruz.reslerianadb.infrastructure.entity.Character;
import com.jcruz.reslerianadb.infrastructure.entity.CharacterStats;
import com.jcruz.reslerianadb.infrastructure.repository.CharacterStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterStatsServiceImpl implements CharacterStatsService {

    @Autowired
    private final CharacterStatsRepository characterStatRepository;

    public CharacterStatsServiceImpl(CharacterStatsRepository characterStatRepository) {
        this.characterStatRepository = characterStatRepository;
    }


    @Override
    public CharacterStatsResponse getCharacterStat(int id) {
        CharacterStats c;
        try {
            Optional<CharacterStats> optC = this.characterStatRepository.findById(id);
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
