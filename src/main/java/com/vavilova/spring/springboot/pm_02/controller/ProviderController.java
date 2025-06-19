package com.vavilova.spring.springboot.pm_02.controller;


import com.vavilova.spring.springboot.pm_02.entity.ProviderEntity;
import com.vavilova.spring.springboot.pm_02.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService providerService;

    @GetMapping("/providers")
    public List<ProviderEntity> getAllProviders() {
        return providerService.getAllProviders();
    }
}
