package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.CharacterResponse;
import com.jcruz.reslerianadb.domain.service.CharacterServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    private final CharacterServiceImpl characterService;

    public CharacterController(CharacterServiceImpl characterService) {
        this.characterService = characterService;
    }

    @GetMapping()
    public List<CharacterResponse> getCharacters() {
        return this.characterService.getCharacters();
    }

    @GetMapping(value="/{id}")
    public CharacterResponse getCharacter(@PathVariable("id") int id) {
        return this.characterService.getCharacter(id);
    }
}
