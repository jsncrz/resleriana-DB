package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.entity.Translation;
import com.jcruz.reslerianadb.infrastructure.entity.TranslationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation, TranslationId> {
}
