package com.vavilova.spring.springboot.pm_02.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "email_valid")
    private String emailValid;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date providerId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}