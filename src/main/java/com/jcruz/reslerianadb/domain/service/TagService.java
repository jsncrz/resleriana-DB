package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.domain.model.TagResponse;

import java.util.List;

public interface TagService {
    List<TagResponse> getTagsByCharacterIdAndLocale(Integer id, String locale);
}
