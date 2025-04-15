package com.jcruz.reslerianadb.domain.service.implementation;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.domain.model.TagResponse;
import com.jcruz.reslerianadb.domain.service.TagService;
import com.jcruz.reslerianadb.infrastructure.dto.ItemTranslationDTO;
import com.jcruz.reslerianadb.infrastructure.entity.Tag;
import com.jcruz.reslerianadb.infrastructure.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TagResponse> getTagsByCharacterIdAndLocale(Integer id, String locale) {
        List<ItemTranslationDTO> tags;
        try {
            tags = this.tagRepository.findTagsByCharacterIdAndLocale(id, locale);
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
