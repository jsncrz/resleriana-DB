package com.jcruz.reslerianadb.infrastructure.repository;


import com.jcruz.reslerianadb.infrastructure.entity.Memoria;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemoriaRepository extends PagingAndSortingRepository<Memoria, Integer>, JpaSpecificationExecutor<Memoria> {

}
