package com.dobrynin.spring.springboot.spring_course_springboot.controller;


import com.dobrynin.spring.springboot.spring_course_springboot.entity.Provider;
import com.dobrynin.spring.springboot.spring_course_springboot.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/add")
    public List<Provider> showAllProviders() {
        return providerService.getAllProviders();
    }
}
