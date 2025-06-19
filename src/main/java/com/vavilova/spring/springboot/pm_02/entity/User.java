package com.vavilova.spring.springboot.pm_02.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String userId;

    @Column(name = "provider_id")
    private Integer providerId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}