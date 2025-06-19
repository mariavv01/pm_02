package com.vavilova.spring.springboot.pm_02.repository;


import com.vavilova.spring.springboot.pm_02.entity.Account;

import java.util.List;

public interface EmployeeDAO {

  List<Account> getAllEmployees();

  void saveEmployee(Account employee);

  Account getEmployee(int id);

  void deleteEmployee(int id);
}
