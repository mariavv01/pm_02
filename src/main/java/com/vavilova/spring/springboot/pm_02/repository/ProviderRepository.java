package com.vavilova.spring.springboot.pm_02.repository;


import com.vavilova.spring.springboot.pm_02.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Integer> {

    List<ProviderEntity> findAllByOrderByName();
}
