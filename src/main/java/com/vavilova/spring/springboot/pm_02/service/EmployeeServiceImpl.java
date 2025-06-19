package com.vavilova.spring.springboot.pm_02.service;


import com.vavilova.spring.springboot.pm_02.repository.EmployeeDAO;
import com.vavilova.spring.springboot.pm_02.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeDAO employeeDAO;

  @Override
  @Transactional
  public List<Account> getAllEmployees() {
    return employeeDAO.getAllEmployees();
  }

  @Override
  @Transactional
  public void saveEmployee(Account employee) {
    employeeDAO.saveEmployee(employee);
  }

  @Override
  @Transactional
  public Account getEmployee(int id) {
    return employeeDAO.getEmployee(id);
  }

  @Override
  @Transactional
  public void deleteEmployee(int id) {
    employeeDAO.deleteEmployee(id);
  }
}