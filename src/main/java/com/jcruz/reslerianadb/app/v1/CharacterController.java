package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.CharacterResponse;
import com.jcruz.reslerianadb.domain.service.implementation.CharacterServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    private final CharacterServiceImpl characterService;

    public CharacterController(CharacterServiceImpl characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<CharacterResponse> getCharacters(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String locale) {
        return this.characterService.getCharactersByLocale(locale);
    }

    @GetMapping(value="/{id}")
    public CharacterResponse getCharacter(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String locale, @PathVariable("id") int id) {
        return this.characterService.getCharacter(id, locale);
    }
}
