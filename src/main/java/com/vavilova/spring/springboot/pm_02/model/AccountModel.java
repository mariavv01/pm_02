package com.vavilova.spring.springboot.pm_02.model;

import com.vavilova.spring.springboot.pm_02.entity.ProviderEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountModel {

    private Integer id;

    private String accountNumber;

    private String fullName;

    private Integer providerId;

    private LocalDate updateAt;

    private Integer userId;

}
