package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.exception.NotFoundException;
import com.jcruz.reslerianadb.common.util.TranslationHelper;
import com.jcruz.reslerianadb.domain.model.AbilityEffectResponse;
import com.jcruz.reslerianadb.domain.model.AbilityResponse;
import com.jcruz.reslerianadb.domain.model.MemoriaResponse;
import com.jcruz.reslerianadb.domain.specification.MemoriaSpec;
import com.jcruz.reslerianadb.infrastructure.entity.Ability;
import com.jcruz.reslerianadb.infrastructure.entity.AbilityEffect;
import com.jcruz.reslerianadb.infrastructure.entity.Memoria;
import com.jcruz.reslerianadb.infrastructure.repository.MemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class MemoriaService {

    @Autowired
    private final MemoriaRepository memoriaRepository;

    @Autowired
    private final TranslationHelper translationHelper;

    public MemoriaService(MemoriaRepository memoriaRepository, TranslationHelper translationHelper) {
        this.memoriaRepository = memoriaRepository;
        this.translationHelper = translationHelper;
    }

    public Page<MemoriaResponse> findMemorias(Integer rarity, String language, Pageable p) {
        Page<Memoria> memorias;
        List<Memoria> memoriasWithTranslations;
        Specification<Memoria> spec = where(null);
        if (rarity != null) {
            spec = spec.and(MemoriaSpec.rarityIs(rarity));
        }
        try {
            memorias = this.memoriaRepository.findAll(spec, p);
            List<Integer> ids = memorias.getContent().stream()
                    .map(Memoria::getExtId)
                    .toList();
            spec = spec.and(MemoriaSpec.idsIn(ids));
            memoriasWithTranslations = memoriaRepository.findAll(
                    spec.and(MemoriaSpec.fetchTranslations()), p.getSort());
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
        return new PageImpl<>(memoriasWithTranslations, p, memorias.getTotalElements())
                .map(memoria -> convertToMemoriaResponse(memoria, language));
    }

    public MemoriaResponse getMemoria(int id, String language) {
        Memoria memoria;
        try {
            Specification<Memoria> spec = where(MemoriaSpec.idIs(id));
            spec = spec.and(MemoriaSpec.fetchTranslations());
            spec = spec.and(MemoriaSpec.fetchAbilities());
            Optional<Memoria> optionalMemoria = this.memoriaRepository.findOne(spec);
            if (optionalMemoria.isEmpty()) {
                throw new NotFoundException(Memoria.class.getName(), id);
            }
            memoria = optionalMemoria.get();
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
        return new MemoriaResponse.Builder()
                .id(memoria.getExtId())
                .name(translationHelper.getTextForLang(memoria.getName(), language))
                .description(translationHelper.getTextForLang(memoria.getDescription(), language))
                .rarity(memoria.getRarity())
                .abilityResponse(getAbilityResponse(language, memoria))
                .build();
    }

    private MemoriaResponse convertToMemoriaResponse(final Memoria memoria, String language) {
        return new MemoriaResponse.Builder()
                .id(memoria.getExtId())
                .name(translationHelper.getTextForLang(memoria.getName(), language))
                .rarity(memoria.getRarity())
                .build();
    }

    private List<AbilityResponse> getAbilityResponse(String language, Memoria memoria) {
        return memoria.getMemoriaAbility().stream()
                .map(ability -> mapAbilityToResponse(language, ability))
                .toList();
    }

    private AbilityResponse mapAbilityToResponse(String language, Ability ability) {
        return new AbilityResponse.Builder()
                .name(translationHelper.getTextForLang(ability.getName(), language))
                .description(translationHelper.getTextForLang(ability.getDescription(), language))
                .abilityEffect(
                        getAndMapAbilityEffectToResponse(ability))
                .build();
    }

    private static List<AbilityEffectResponse> getAndMapAbilityEffectToResponse(Ability ability) {
        return ability.getAbilityEffects().stream()
                .map(abilityEffect -> new AbilityEffectResponse(abilityEffect.getValue())).toList();
    }
}
