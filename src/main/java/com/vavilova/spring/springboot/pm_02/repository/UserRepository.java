package com.vavilova.spring.springboot.pm_02.repository;


import com.vavilova.spring.springboot.pm_02.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT count(a) from UserEntity u join u.accounts a where u.id = ?1 and a.isDeleted is false")
    Integer getAccountAmount(Integer userId);

    List<UserEntity> findAllByIsDeletedIsFalse();

    List<UserEntity> findAllByIdAndIsDeletedIsFalse(Integer id);

    @Query("SELECT count(u) from UserEntity u")
    Integer countAllClients();

    Integer countAllByEmailIsNotNull();

    Integer countAllByIsDeletedIsTrue();

}
