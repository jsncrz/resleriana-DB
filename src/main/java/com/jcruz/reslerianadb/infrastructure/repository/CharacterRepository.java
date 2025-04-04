package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    @Query("""
            select c from Character c
                JOIN FETCH c.name n
                JOIN FETCH c.anotherName an
                WHERE n.language = :language
                AND an.language = :language
                ORDER BY c.releaseDate desc
                LIMIT 20
            """)
    List<Character> findSimpleByLocale(@Param("language") String locale);
    @Query("""
            select c from Character c
                JOIN FETCH c.name n
                JOIN FETCH c.anotherName an
                JOIN FETCH c.fullName fn
                JOIN FETCH c.acquisitionText at
                JOIN FETCH c.description d
                WHERE n.language = :language
                AND an.language = :language
                AND fn.language = :language
                AND at.language = :language
                AND d.language = :language
            """)
    List<Character> findDetailedByLocale(@Param("language") String locale);
}
