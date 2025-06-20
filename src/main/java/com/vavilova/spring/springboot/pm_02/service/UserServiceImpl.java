package com.vavilova.spring.springboot.pm_02.service;

import com.sun.istack.NotNull;
import com.vavilova.spring.springboot.pm_02.entity.AccountEntity;
import com.vavilova.spring.springboot.pm_02.entity.UserEntity;
import com.vavilova.spring.springboot.pm_02.model.AccountModel;
import com.vavilova.spring.springboot.pm_02.model.UserModel;
import com.vavilova.spring.springboot.pm_02.repository.AccountRepository;
import com.vavilova.spring.springboot.pm_02.repository.ProviderRepository;
import com.vavilova.spring.springboot.pm_02.repository.UserRepository;
import com.vavilova.spring.springboot.pm_02.repository.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AccountRepository accountRepository;

    private final AccountService accountService;

    private final ProviderRepository providerRepository;

    @Override
    public List<UserModel> findAllUser() {
        return userRepository.findAllByIsDeletedIsFalse()
                .stream()
                .map(getUserEntityUserModelFunction())
                .toList();
    }

    @Override
    public List<UserModel> getAllAccountsByUserId(Integer userId) {
        return userRepository.findAllByIdAndIsDeletedIsFalse(userId)
                .stream()
                .map(userEntity -> {
                    UserModel userModel = new UserModel();
                    userModel.setId(userEntity.getId());
                    userModel.setAccountAmount(userRepository.getAccountAmount(userId));
                    userModel.setPhone(userEntity.getPhone());
                    userModel.setEmail(userEntity.getEmail());
                    userModel.setLogin(userEntity.getLogin());
                    userModel.setCreationDate(userEntity.getUpdateAt());
                    List<AccountEntity> accountEntities = accountRepository.findByUserId(userId);
                    return getUserModel(userModel, accountEntities);
                })
                .toList();
    }

    @Override
    public void saveUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        if (userModel.getId() != null) {
            userEntity.setId(userModel.getId());
        }
        userEntity.setPhone(userModel.getPhone());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setLogin(userModel.getLogin());
        userEntity.setUpdateAt(LocalDate.now());
        userEntity.setIsDeleted(false);
        userRepository.save(userEntity);
    }

    @Override
    public UserModel getUserById(Integer userId) {
        UserModel userModel = new UserModel();
        UserEntity userEntity = userRepository.getReferenceById(userId);
        userModel.setId(userEntity.getId());
        userModel.setPhone(userEntity.getPhone());
        userModel.setEmail(userEntity.getEmail());
        userModel.setLogin(userEntity.getLogin());
        userModel.setCreationDate(userEntity.getUpdateAt());
        userModel.setAccountList(accountService.getAllAccountsByUserId(userId));
        return userModel;
    }

    @Override
    public void deleteUserById(Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setIsDeleted(true);
        userRepository.save(userEntity);
    }

    @Override
    public Integer getUserCount(boolean withEmail) {
        if (withEmail) {
            return userRepository.countAllByEmailIsNotNull();
        } else {
            return userRepository.countAllClients();
        }
    }

    @Override
    public Integer getDeletedUserCount() {
        return userRepository.countAllByIsDeletedIsTrue();
    }

    @Override
    public List<UserModel> searchUsersByParameters(String phone, String email) {
        Specification<UserEntity> spec = Specification
                .where(UserSpecification.hasUserEmail(email))
                .and(UserSpecification.hasUserPhone(phone));
        return userRepository.findAll(spec)
                .stream()
                .map(getUserEntityUserModelFunction())
                .toList();
    }

    private Function<UserEntity, UserModel> getUserEntityUserModelFunction() {
        return userEntity -> {
            UserModel userModel = new UserModel();
            userModel.setId(userEntity.getId());
            userModel.setAccountAmount(userRepository.getAccountAmount(userEntity.getId()));
            userModel.setPhone(userEntity.getPhone());
            userModel.setEmail(userEntity.getEmail());
            userModel.setLogin(userEntity.getLogin());
            userModel.setCreationDate(userEntity.getUpdateAt());
            List<AccountEntity> accountEntities = accountRepository.findByUserId(userEntity.getId());
            return getUserModel(userModel, accountEntities);
        };
    }

    @NotNull
    private UserModel getUserModel(UserModel userModel, List<AccountEntity> accountEntities) {
        if (CollectionUtils.isEmpty(accountEntities)) {
            userModel.setAccountList(Collections.emptyList());
        } else {
            List<AccountModel> accountModels = accountEntities
                    .stream()
                    .map(accountEntity -> {
                        AccountModel accountModel = new AccountModel();
                        accountModel.setId(accountEntity.getId());
                        accountModel.setAccountNumber(accountEntity.getAccountNumber());
                        accountModel.setFullName(accountEntity.getFullName());
                        accountModel.setUpdateAt(accountEntity.getCreationDate());
                        accountModel.setProviderId(accountEntity.getProvider().getId());
                        accountModel.setUserId(accountEntity.getUser().getId());
                        return accountModel;
                    })
                    .toList();
            userModel.setAccountList(accountModels);
        }
        return userModel;
    }


}
