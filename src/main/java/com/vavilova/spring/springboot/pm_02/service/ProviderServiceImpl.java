package com.vavilova.spring.springboot.pm_02.service;

import com.vavilova.spring.springboot.pm_02.repository.ProviderDAO;
import com.vavilova.spring.springboot.pm_02.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProviderServiceImpl implements ProviderService{
    @Autowired
    private ProviderDAO providerDAO;

    @Override
    @Transactional
    public List<Provider> getAllProviders() {
        return providerDAO.getAllProviders();
    }
}
