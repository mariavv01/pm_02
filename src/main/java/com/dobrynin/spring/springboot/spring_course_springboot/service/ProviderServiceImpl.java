package com.dobrynin.spring.springboot.spring_course_springboot.service;

import com.dobrynin.spring.springboot.spring_course_springboot.dao.ProviderDAO;
import com.dobrynin.spring.springboot.spring_course_springboot.entity.Provider;
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
