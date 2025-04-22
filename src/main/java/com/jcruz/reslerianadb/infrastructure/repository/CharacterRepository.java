package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    //    @Query("""
//            select c from Character c
//                JOIN FETCH c.name n
//                JOIN FETCH c.anotherName an
//                WHERE n.language = :language
//                AND an.language = :language
//                ORDER BY c.releaseDate desc
//            """)
    @Query("""
                    select c from Character c
                    WHERE :language = :language
            """)
    List<Character> findSimpleByLanguage(@Param("language") String language);

    //    @Query("""
//            select c from Character c
//                JOIN FETCH c.name n
//                JOIN FETCH c.anotherName an
//                JOIN FETCH c.fullName fn
//                JOIN FETCH c.acquisitionText at
//                JOIN FETCH c.description d
//                WHERE c.extId = :extId
//                AND n.language = :language
//                AND an.language = :language
//                AND fn.language = :language
//                AND at.language = :language
//                AND d.language = :language
//            """)
    @Query("""
                    select c from Character c
                    WHERE :language = :language AND :extId = :extId
            """)
    Optional<Character> findByExtIdAndLanguage(@Param("extId") Integer extId, @Param("language") String language);

}
