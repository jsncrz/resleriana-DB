package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.exception.NotFoundException;
import com.jcruz.reslerianadb.domain.model.CharacterResistResponse;
import com.jcruz.reslerianadb.infrastructure.entity.Character;
import com.jcruz.reslerianadb.infrastructure.entity.CharacterResist;
import com.jcruz.reslerianadb.infrastructure.repository.CharacterResistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterResistService {

    @Autowired
    private final CharacterResistRepository characterResistRepository;

    public CharacterResistService(CharacterResistRepository characterResistRepository) {
        this.characterResistRepository = characterResistRepository;
    }

    public CharacterResistResponse getCharacterResist(Integer id) {
        CharacterResist c;
        try {
            Optional<CharacterResist> optC = this.characterResistRepository.findById(id);
            if (optC.isEmpty()) {
                throw new NotFoundException(Character.class.getName(), id);
            } else {
                c = optC.get();
            }
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
        return new CharacterResistResponse.Builder()
                .fire(c.getFire())
                .ice(c.getIce())
                .bolt(c.getBolt())
                .air(c.getAir())
                .slash(c.getSlash())
                .strike(c.getStrike())
                .stab(c.getStab())
                .build();
    }
}
