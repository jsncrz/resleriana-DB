package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.entity.MemoriaGrowth;
import com.jcruz.reslerianadb.infrastructure.entity.MemoriaGrowthId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoriaGrowthRepository extends JpaRepository<MemoriaGrowth, MemoriaGrowthId> {

}
