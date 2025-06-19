package com.vavilova.spring.springboot.pm_02.repository;

import com.vavilova.spring.springboot.pm_02.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  @Autowired
  private EntityManager entityManager;

  @Override
  public List<Account> getAllEmployees() {
    Query query = entityManager.createQuery("from Account");
    return query.getResultList();
  }

  @Override
  public void saveEmployee(Account employee) {
    Account newEmployee = entityManager.merge(employee);
    employee.setId(newEmployee.getId());
  }

  @Override
  public Account getEmployee(int id) {
    Account employee = entityManager.find(Account.class, id);
    return employee;
  }

  @Override
  public void deleteEmployee(int id) {
    Query query = entityManager.createQuery("delete from Account where id =: employeeId");
    query.setParameter("employeeId", id);
    query.executeUpdate();
  }
}
