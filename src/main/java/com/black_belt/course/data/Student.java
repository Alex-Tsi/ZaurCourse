package com.black_belt.course.data;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    private String name;
    private int course;
    private double avgGrade;

    public static class StudentsInsert {

       public static List<Student> insert() {
            List<Student> list = new ArrayList<>();
            var st1 = new Student("Ivan", 3, 8.3);
            var st2 = new Student("Nikolay", 2, 8.1);
            var st3 = new Student("Elena", 1, 8.9);
            var st4 = new Student("Petr", 4, 7.6);
            var st5 = new Student("Mariya", 1, 10.0);

            list.add(st1);
            list.add(st2);
            list.add(st3);
            list.add(st4);
            list.add(st5);
            return list;
        }
    }
}
