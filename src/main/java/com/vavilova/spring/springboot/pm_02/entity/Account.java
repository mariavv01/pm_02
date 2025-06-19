package com.vavilova.spring.springboot.pm_02.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "update_at")
    @Temporal(TemporalType.DATE)
    private Date updateAt;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "provider_id")
    private Integer providerId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}