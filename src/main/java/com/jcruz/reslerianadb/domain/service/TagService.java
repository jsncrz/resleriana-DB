package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.domain.model.TagResponse;
import com.jcruz.reslerianadb.infrastructure.dto.ItemTranslationDTO;
import com.jcruz.reslerianadb.infrastructure.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagResponse> getTagsByCharacterIdAndLanguage(Integer id, String language) {
        List<ItemTranslationDTO> tags;
        try {
            tags = this.tagRepository.findTagsByCharacterIdAndLanguage(id, language);
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }

        List<TagResponse> res = new ArrayList<>();
        for (ItemTranslationDTO t : tags) {
            res.add(new TagResponse.Builder()
                    .id(t.id())
                    .name(t.text())
                    .build());
        }
        return res;
    }

}
