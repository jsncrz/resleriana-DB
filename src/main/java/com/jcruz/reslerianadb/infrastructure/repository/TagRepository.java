package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.dto.ItemTranslationDTO;
import com.jcruz.reslerianadb.infrastructure.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Query("""
            select new com.jcruz.reslerianadb.infrastructure.dto.ItemTranslationDTO(t.id, n.text) from Character c
                JOIN c.characterTags t
                JOIN t.name n
                WHERE c.extId = :id
                AND n.language = :language
                ORDER BY t.priority asc
            """)
    List<ItemTranslationDTO> findTagsByCharacterIdAndLocale(@Param("id") Integer id, @Param("language") String locale);

}
