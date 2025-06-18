package com.dobrynin.spring.springboot.spring_course_springboot.controller;

import com.dobrynin.spring.springboot.spring_course_springboot.entity.Analytic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
