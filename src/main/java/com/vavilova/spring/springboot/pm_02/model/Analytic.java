package com.vavilova.spring.springboot.pm_02.model;

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
