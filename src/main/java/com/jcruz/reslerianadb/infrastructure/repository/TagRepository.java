package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.dto.ItemTranslationDTO;
import com.jcruz.reslerianadb.infrastructure.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {

//    List<ItemTranslationDTO> findTagsByCharacterIdAndLanguage(@Param("id") Integer id, @Param("language") String language);

}
