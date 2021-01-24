package com.black_belt.course.data;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public
class Car {
    String model;
    String color;
    double engine;
}
