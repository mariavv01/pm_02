package com.dobrynin.spring.springboot.spring_course_springboot.controller;

import com.dobrynin.spring.springboot.spring_course_springboot.entity.Employee;
import com.dobrynin.spring.springboot.spring_course_springboot.service.EmployeeService;
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
  public List<Employee> showAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/get/{id}")
  public Employee getEmployee(@PathVariable int id) {
    return employeeService.getEmployee(id);
  }

  @PostMapping("/employees")
  public Employee addNewEmployee(@RequestBody Employee employee) {
    employeeService.saveEmployee(employee);
    return employee;
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee) {
    employeeService.saveEmployee(employee);
    return employee;
  }

  @DeleteMapping("/employees/{id}")
  public String deleteEmployee(@PathVariable int id) {
    employeeService.deleteEmployee(id);
    return "Employee with id = " + id + " was deleted";
  }
}