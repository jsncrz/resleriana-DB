package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.exception.NotFoundException;
import com.jcruz.reslerianadb.domain.model.MemoriaGrowthDTO;
import com.jcruz.reslerianadb.domain.model.MemoriaStatusResponse;
import com.jcruz.reslerianadb.infrastructure.entity.Character;
import com.jcruz.reslerianadb.infrastructure.entity.MemoriaGrowth;
import com.jcruz.reslerianadb.infrastructure.entity.MemoriaStatus;
import com.jcruz.reslerianadb.infrastructure.repository.MemoriaGrowthRepository;
import com.jcruz.reslerianadb.infrastructure.repository.MemoriaStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemoriaStatusService {

    @Autowired
    private final MemoriaStatusRepository memoriaStatusRepository;

    @Autowired
    private final MemoriaGrowthRepository memoriaGrowthRepository;

    public MemoriaStatusService(MemoriaStatusRepository memoriaStatusRepository,
                                MemoriaGrowthRepository memoriaGrowthRepository) {
        this.memoriaStatusRepository = memoriaStatusRepository;
        this.memoriaGrowthRepository = memoriaGrowthRepository;
    }

    private MemoriaGrowthDTO convertToMemoriaGrowthDto(final MemoriaGrowth growth) {
        return new MemoriaGrowthDTO.Builder()
                .level(growth.getLevel())
                .value(growth.getStatValue())
                .build();
    }

    private List<MemoriaGrowthDTO> getMemoriaGrowthsAsDtos(int id) {
        return memoriaGrowthRepository.findByExtId(id).stream()
                .map(this::convertToMemoriaGrowthDto).collect(Collectors.toList());
    }

    private MemoriaStatusResponse buildMemoriaStatusResponse(MemoriaStatus memoriaStatus) {
        return new MemoriaStatusResponse.Builder()
                .attack(getMemoriaGrowthsAsDtos(memoriaStatus.getAttack()))
                .magic(getMemoriaGrowthsAsDtos(memoriaStatus.getMagic()))
                .hp(getMemoriaGrowthsAsDtos(memoriaStatus.getHp()))
                .defense(getMemoriaGrowthsAsDtos(memoriaStatus.getDefense()))
                .mental(getMemoriaGrowthsAsDtos(memoriaStatus.getMental()))
                .speed(getMemoriaGrowthsAsDtos(memoriaStatus.getSpeed()))
                .build();
    }

    public MemoriaStatusResponse getMemoriaStatus(int id) {
        MemoriaStatus status;
        try {
            Optional<MemoriaStatus> optStatus = this.memoriaStatusRepository.findById(id);
            if (optStatus.isEmpty()) {
                throw new NotFoundException(Character.class.getName(), id);
            } else {
                status = optStatus.get();
            }
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
        return buildMemoriaStatusResponse(status);
    }
}
