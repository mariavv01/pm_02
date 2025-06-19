package com.vavilova.spring.springboot.pm_02.controller;

import com.vavilova.spring.springboot.pm_02.model.Analytic;
import com.vavilova.spring.springboot.pm_02.service.AnalyticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticController {

    private final AnalyticService analyticService;

    @GetMapping("/client")
    public Analytic getClientAnalytics() {
        return analyticService.getAnalyticByClients();
    }

    @GetMapping("/account")
    public Analytic getAccountAnalytics() {
        return analyticService.getAnalyticByAccounts();
    }
}
