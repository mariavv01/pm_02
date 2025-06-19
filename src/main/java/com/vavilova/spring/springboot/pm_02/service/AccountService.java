package com.vavilova.spring.springboot.pm_02.service;


import com.vavilova.spring.springboot.pm_02.model.AccountModel;

import java.util.List;

public interface AccountService {

    List<AccountModel> getAllAccountsByUserId(Integer userId);

    List<AccountModel> saveAccount(AccountModel account);

    void deleteAccountById(Integer id);

    Integer getAccountCount();

    Integer getDeletedAccountCount();
}
