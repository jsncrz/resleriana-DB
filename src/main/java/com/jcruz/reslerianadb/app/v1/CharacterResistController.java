package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.CharacterResistResponse;
import com.jcruz.reslerianadb.domain.service.CharacterResistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/characters/{id}/resist")
public class CharacterResistController {

    private final CharacterResistService characterResistService;

    public CharacterResistController(CharacterResistService characterResistService) {
        this.characterResistService = characterResistService;
    }

    @GetMapping
    public CharacterResistResponse getCharacterResist(@PathVariable("id") Integer id) {
        return this.characterResistService.getCharacterResist(id);
    }
}
