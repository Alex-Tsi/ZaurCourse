package com.black_belt.course.collection;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Student {
    private int age;
    private String name;
    private int course;
}
