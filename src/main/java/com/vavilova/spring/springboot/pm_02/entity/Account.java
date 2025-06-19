package com.vavilova.spring.springboot.pm_02.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "provider_id")
    private Integer providerId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}