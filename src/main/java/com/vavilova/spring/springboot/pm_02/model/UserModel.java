package com.vavilova.spring.springboot.pm_02.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UserModel {

    private Integer id;

    private String phone;

    private String email;

    private String login;

    private List<AccountModel> accountList;

    private Integer accountAmount;

    private LocalDate creationDate;
}