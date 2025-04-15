package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.CharacterStatsResponse;
import com.jcruz.reslerianadb.domain.model.TagResponse;
import com.jcruz.reslerianadb.domain.service.implementation.CharacterStatsServiceImpl;
import com.jcruz.reslerianadb.domain.service.implementation.TagServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters/{id}/tags")
public class CharacterTagsController {

    private final TagServiceImpl tagService;

    public CharacterTagsController(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<TagResponse> getCharacterTags(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String locale, @PathVariable("id") int id) {
        return this.tagService.getTagsByCharacterIdAndLocale(id, locale);
    }
}
