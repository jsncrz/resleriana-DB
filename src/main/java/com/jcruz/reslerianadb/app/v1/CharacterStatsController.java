package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.CharacterStatsResponse;
import com.jcruz.reslerianadb.domain.service.CharacterStatsServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/characters/{id}/stat")
public class CharacterStatsController {

    private final CharacterStatsServiceImpl characterStatService;

    public CharacterStatsController(CharacterStatsServiceImpl characterStatService) {
        this.characterStatService = characterStatService;
    }

    @GetMapping
    public CharacterStatsResponse getCharacterStat(@PathVariable("id") int id) {
        return this.characterStatService.getCharacterStat(id);
    }
}
