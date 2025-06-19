package com.vavilova.spring.springboot.pm_02.service;

import com.vavilova.spring.springboot.pm_02.entity.AccountEntity;
import com.vavilova.spring.springboot.pm_02.model.AccountModel;
import com.vavilova.spring.springboot.pm_02.repository.AccountRepository;
import com.vavilova.spring.springboot.pm_02.repository.ProviderRepository;
import com.vavilova.spring.springboot.pm_02.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final ProviderRepository providerRepository;

    @Override
    public List<AccountModel> getAllAccountsByUserId(Integer userId) {
        return accountRepository.findByUserId(userId)
                .stream()
                .map(acc -> {
                    AccountModel accountModel = new AccountModel();
                    accountModel.setId(acc.getId());
                    accountModel.setAccountNumber(acc.getAccountNumber());
                    accountModel.setFullName(acc.getFullName());
                    accountModel.setProviderId(acc.getProvider().getId());
                    accountModel.setUpdateAt(acc.getCreationDate());
                    accountModel.setUserId(userId);
                    return accountModel;
                })
                .toList();
    }

    @Transactional
    @Override
    public List<AccountModel> saveAccount(AccountModel accountModel) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(accountModel.getAccountNumber());
        accountEntity.setFullName(accountModel.getFullName());
        accountEntity.setCreationDate(LocalDate.now());
        accountEntity.setUser(userRepository.getReferenceById(accountModel.getUserId()));
        accountEntity.setProvider(providerRepository.getReferenceById(accountModel.getProviderId()));
        accountEntity.setIsDeleted(false);
        accountRepository.saveAndFlush(accountEntity);
        return getAllAccountsByUserId(accountModel.getUserId());
    }

    @Transactional
    @Override
    public void deleteAccountById(Integer id) {
        AccountEntity accountEntity = accountRepository.findById(id).get();
        accountEntity.setIsDeleted(true);
        accountRepository.save(accountEntity);
    }

    @Override
    public Integer getAccountCount() {
        return (int) accountRepository.count();
    }

    @Override
    public Integer getDeletedAccountCount() {
        return accountRepository.countAllByIsDeletedIsTrue();
    }
}
