package com.vavilova.spring.springboot.pm_02.service;

import com.vavilova.spring.springboot.pm_02.model.Analytic;

public interface AnalyticService {

    Analytic getAnalyticByClients();

    Analytic getAnalyticByAccounts();
}