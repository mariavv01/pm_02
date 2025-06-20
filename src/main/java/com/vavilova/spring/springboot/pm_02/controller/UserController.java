package com.vavilova.spring.springboot.pm_02.controller;

import com.vavilova.spring.springboot.pm_02.model.AccountModel;
import com.vavilova.spring.springboot.pm_02.model.UserModel;
import com.vavilova.spring.springboot.pm_02.service.AccountService;
import com.vavilova.spring.springboot.pm_02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AccountService accountService;

    @GetMapping("/clients")
    public List<UserModel> getAllClients() {
        return userService.findAllUser();
    }

    @GetMapping("/client/search")
    public List<UserModel> getAllClients(@RequestParam(required = false) String phone,
                                         @RequestParam(required = false) String email) {
        return userService.searchUsersByParameters(phone, email);
    }

    @PutMapping("/client/add")
    public void addUser(@RequestBody UserModel userModel) {
        userService.saveUser(userModel);
    }

    @PostMapping("/client/edit")
    public void editUser(@RequestBody UserModel userModel) {
        userService.saveUser(userModel);
    }

    @DeleteMapping("/client/{id}/delete")
    public void deleteUser(@PathVariable("id") Integer userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping("/client/{id}/accounts")
    public List<AccountModel> getAllAccountByUser(@PathVariable("id") Integer userId) {
        return accountService.getAllAccountsByUserId(userId);
    }

    @PutMapping("/account/add")
    public void addAccountByUser(@RequestBody AccountModel accountModel) {
        accountService.saveAccount(accountModel);
    }

    @DeleteMapping("account/{accountId}/delete")
    public void deleteAccountByUser(@PathVariable("accountId") Integer accountId) {
        accountService.deleteAccountById(accountId);
    }
}