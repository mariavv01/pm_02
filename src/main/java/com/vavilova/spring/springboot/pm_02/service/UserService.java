package com.vavilova.spring.springboot.pm_02.service;

import com.vavilova.spring.springboot.pm_02.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> findAllUser();

    List<UserModel> getAllAccountsByUserId(Integer userId);

    void saveUser(UserModel userModel);

    UserModel getUserById(Integer userId);

    void deleteUserById(Integer id);

    Integer getUserCount(boolean isEmail);

    Integer getDeletedUserCount();
}
