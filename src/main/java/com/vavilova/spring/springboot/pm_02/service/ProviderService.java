package com.vavilova.spring.springboot.pm_02.service;

import com.vavilova.spring.springboot.pm_02.entity.ProviderEntity;

import java.util.List;

public interface ProviderService {
    List<ProviderEntity> getAllProviders();
}
