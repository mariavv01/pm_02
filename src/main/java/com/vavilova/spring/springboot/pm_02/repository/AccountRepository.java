package com.vavilova.spring.springboot.pm_02.repository;

import com.vavilova.spring.springboot.pm_02.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    @Query("SELECT a from UserEntity u join u.accounts a where u.id = ?1 and a.isDeleted is false")
    List<AccountEntity> findByUserId(Integer userId);

    Integer countAllByIsDeletedIsTrue();

}
