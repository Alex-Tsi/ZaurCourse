package com.black_belt.course.lambda_expressions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    private String name;
    private int course;
    private double avgGrade;
}
