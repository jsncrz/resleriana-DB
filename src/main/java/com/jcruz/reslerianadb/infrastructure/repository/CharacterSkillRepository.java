package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.entity.CharacterSkill;
import com.jcruz.reslerianadb.infrastructure.entity.CharacterSkillKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CharacterSkillRepository extends JpaRepository<CharacterSkill, CharacterSkillKey>, JpaSpecificationExecutor<CharacterSkill> {

}
