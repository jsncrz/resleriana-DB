package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.entity.Memoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemoriaRepository extends PagingAndSortingRepository<Memoria, Integer>, JpaSpecificationExecutor<Memoria> {

    @Query("""
            select m from Memoria m
                JOIN FETCH m.name n
                WHERE n.language = :language
            """)
    Page<Memoria> findSimpleByLanguage(@Param("language") String language, Pageable pageable);

    @Query("""
            select m from Memoria m
                JOIN FETCH m.name n
                JOIN FETCH m.description d
                WHERE m.extId = :extId
                AND n.language = :language
                AND d.language = :language
            """)
    Optional<Memoria> findByExtIdAndLanguage(@Param("extId") Integer extId, @Param("language") String language);

}
