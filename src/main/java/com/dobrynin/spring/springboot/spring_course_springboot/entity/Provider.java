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
public class Provider {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "short_name")
    private String short_name;

    @Column(name = "full_name")
    private String full_name;

    public Provider(String short_name, String full_name) {
        this.short_name = short_name;
        this.full_name = full_name;
    }
}
