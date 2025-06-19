package com.vavilova.spring.springboot.pm_02.service;

import com.vavilova.spring.springboot.pm_02.entity.ProviderEntity;
import com.vavilova.spring.springboot.pm_02.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    @Override
    public List<ProviderEntity> getAllProviders() {
        return providerRepository.findAllByOrderByName();
    }
}
