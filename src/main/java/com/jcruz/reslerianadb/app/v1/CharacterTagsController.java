package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.TagResponse;
import com.jcruz.reslerianadb.domain.service.TagService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters/{id}/tags")
public class CharacterTagsController {

    private final TagService tagService;

    public CharacterTagsController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<TagResponse> getCharacterTags(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language, @PathVariable("id") int id) {
        return this.tagService.getTagsByCharacterIdAndLanguage(id, language);
    }
}
