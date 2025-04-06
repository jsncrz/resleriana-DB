package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.entity.CharacterStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterStatsRepository extends JpaRepository<CharacterStats, Integer> {

}
