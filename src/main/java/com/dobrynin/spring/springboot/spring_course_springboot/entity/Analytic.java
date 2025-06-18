package com.dobrynin.spring.springboot.spring_course_springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Analytic {

    private Integer total;
    private Integer removedTotal;
    private Integer totalWithEmail;

}
