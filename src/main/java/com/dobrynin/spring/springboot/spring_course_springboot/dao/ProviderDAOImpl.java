package com.dobrynin.spring.springboot.spring_course_springboot.dao;

import com.dobrynin.spring.springboot.spring_course_springboot.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProviderDAOImpl implements ProviderDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Provider> getAllEmployees() {
        Query query = entityManager.createQuery("from Provider");
        return query.getResultList();
    }
}
