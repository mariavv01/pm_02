package com.dobrynin.spring.springboot.spring_course_springboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "department")
  private String department;

  @Column(name = "salary")
  private int salary;

  public Employee(String name, String surname, String department, int salary) {
    this.name = name;
    this.surname = surname;
    this.department = department;
    this.salary = salary;
  }
}

