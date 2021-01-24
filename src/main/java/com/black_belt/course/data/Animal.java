package com.black_belt.course.data;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public
class Animal {
    private String name;
    private String type;
    private int size;
}
