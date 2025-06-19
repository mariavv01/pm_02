package com.vavilova.spring.springboot.pm_02.controller;

import com.vavilova.spring.springboot.pm_02.entity.Account;
import com.vavilova.spring.springboot.pm_02.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
  private final EmployeeService employeeService;

  public ClientController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/add")
  public List<Account> showAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/get/{id}")
  public Account getEmployee(@PathVariable int id) {
    return employeeService.getEmployee(id);
  }

  @PostMapping("/employees")
  public Account addNewEmployee(@RequestBody Account employee) {
    employeeService.saveEmployee(employee);
    return employee;
  }

  @PutMapping("/employees")
  public Account updateEmployee(@RequestBody Account employee) {
    employeeService.saveEmployee(employee);
    return employee;
  }

  @DeleteMapping("/employees/{id}")
  public String deleteEmployee(@PathVariable int id) {
    employeeService.deleteEmployee(id);
    return "Employee with id = " + id + " was deleted";
  }
}