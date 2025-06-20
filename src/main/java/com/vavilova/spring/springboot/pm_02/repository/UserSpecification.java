package com.vavilova.spring.springboot.pm_02.repository;

import com.vavilova.spring.springboot.pm_02.entity.UserEntity;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<UserEntity> hasUserEmail(String userEmail) {
        return ((root, query, criteriaBuilder) -> {
            if (userEmail == null || userEmail.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("email"), userEmail);
        });
    }

    public static Specification<UserEntity> hasUserPhone(String userPhone) {
        return ((root, query, criteriaBuilder) -> {
            if (userPhone == null || userPhone.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("phone"), userPhone);
        });
    }
}
