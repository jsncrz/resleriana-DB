package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.CharacterResponse;
import com.jcruz.reslerianadb.domain.service.CharacterService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<CharacterResponse> getCharacters(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language) {
        return this.characterService.getCharactersByLanguage(language);
    }

    @GetMapping(value="/{id}")
    public CharacterResponse getCharacter(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language, @PathVariable("id") int id) {
        return this.characterService.getCharacter(id, language);
    }
}
