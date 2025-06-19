package com.vavilova.spring.springboot.pm_02.controller;

import com.vavilova.spring.springboot.pm_02.model.Analytic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnalyticController {
    @GetMapping("/analytics/client")
    public Analytic getClientAnalytics() {
    Analytic response = new Analytic();
    response.setTotal();
    response.setDeleteUsers();
    response.setUseEmail(true);
    return response;
}

    @GetMapping("/analytics/account")
    public Analytic getClientAnalytics() {
        Analytic response = new Analytic();
        response.setAllAccount();
        response.setDeleteAccount();
        return response;
    }
}
