package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.CharacterSkillResponse;
import com.jcruz.reslerianadb.domain.service.CharacterSkillService;
import com.jcruz.reslerianadb.domain.service.CharacterStatsService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/characters/{id}/skills")
public class CharacterSkillsController {

    private final CharacterSkillService characterSkillService;

    public CharacterSkillsController(CharacterSkillService characterSkillService) {
        this.characterSkillService = characterSkillService;
    }

    @GetMapping
    public CharacterSkillResponse getCharacterSkills(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language, @PathVariable("id") int id) {
        return this.characterSkillService.getCharacterSkills(id, language);
    }
}
