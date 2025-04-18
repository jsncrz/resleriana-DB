package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.entity.MemoriaGrowth;
import com.jcruz.reslerianadb.infrastructure.entity.MemoriaGrowthId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoriaGrowthRepository extends JpaRepository<MemoriaGrowth, MemoriaGrowthId> {

    List<MemoriaGrowth> findByExtId(Integer extId);

}
