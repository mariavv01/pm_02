package com.vavilova.spring.springboot.pm_02.service;


import com.vavilova.spring.springboot.pm_02.entity.Account;

import java.util.List;

public interface EmployeeService {

  List<Account> getAllEmployees();

  void saveEmployee(Account employee);

  public Account getEmployee(int id);

  void deleteEmployee(int id);
}
