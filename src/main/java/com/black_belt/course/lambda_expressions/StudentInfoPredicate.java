package com.black_belt.course.lambda_expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentInfoPredicate {
    public static void main(String[] args) {
        List<Student> stList = new ArrayList<>();
        StudentsInsert si = new StudentsInsert();
        si.insert(stList);

        Filter<Student> fi = new Filter<>();
        //fi.getStudents(stList, (s) -> s.getCourse() > 1);

        Predic<Student> p1 = student -> student.getCourse() > 1;
        Predic<Student> p2 = student -> student.getName().charAt(0) == 'P';

        //fi.getStudents(stList, p1.and(p2));
        fi.getStudents(stList, p1.and(p2));
    }
}

class Filter<T> {
    void getStudents(List<? extends T> list, Predic<T> pr) {
        for (T val : list) {
            if (pr.test(val)) {
                System.out.println(val);
            }
        }
    }
}

interface Predic<T> {
    boolean test(T t);

    default Predic<T> and(Predic<? super T> other) {
        return new Predic<T>() {
            @Override
            public boolean test(T t) {
                return Predic.this.test(t) && other.test(t);
            }
        };
    }
}