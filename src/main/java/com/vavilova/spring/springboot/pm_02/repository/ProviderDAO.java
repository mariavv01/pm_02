package com.vavilova.spring.springboot.pm_02.repository;


import com.vavilova.spring.springboot.pm_02.entity.Provider;

import java.util.List;

public interface ProviderDAO {
    List<Provider> getAllProviders();
}
