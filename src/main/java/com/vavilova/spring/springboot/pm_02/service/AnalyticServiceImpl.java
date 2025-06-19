package com.vavilova.spring.springboot.pm_02.service;

import com.vavilova.spring.springboot.pm_02.model.Analytic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticServiceImpl implements AnalyticService {

    private final UserService userService;

    private final AccountService accountService;

    @Override
    public Analytic getAnalyticByClients() {
        Analytic analytic = new Analytic();
        analytic.setTotal(userService.getUserCount(false));
        analytic.setTotalWithEmail(userService.getUserCount(true));
        analytic.setRemovedTotal(userService.getDeletedUserCount());
        return analytic;
    }

    @Override
    public Analytic getAnalyticByAccounts() {
        Analytic analytic = new Analytic();
        analytic.setTotal(accountService.getAccountCount());
        analytic.setRemovedTotal(accountService.getDeletedAccountCount());
        return analytic;
    }
}
