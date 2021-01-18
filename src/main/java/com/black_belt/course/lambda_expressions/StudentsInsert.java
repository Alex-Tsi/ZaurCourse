package com.black_belt.course.lambda_expressions;

import lombok.var;

import java.util.ArrayList;
import java.util.List;

public class StudentsInsert {

    static List<Student> insert() {
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
