package com.black_belt.course.lambda_expressions;

import com.black_belt.course.data.Student;

import java.util.List;
import java.util.function.Predicate;

public class StudentInfoPredicate {
    public static void main(String[] args) {
        List<Student> stList = Student.StudentsInsert.insert();

        Filter<Student> fi = new Filter<>();
        //fi.getStudents(stList, (s) -> s.getCourse() > 1);

        Predict<Student> p1 = student -> student.getCourse() > 1;
        Predict<Student> p2 = student -> student.getName().charAt(0) == 'P';

        //fi.getStudents(stList, p1.and(p2));
        fi.getStudents(stList, p1.and(p2));

 /*       System.out.println("Before removeIf");
        System.out.println(stList);
        getWithPredicate(stList, student -> student.getCourse() > 0);
        System.out.println("------------------------------------------");
        System.out.println("After removeIf");
        System.out.println(stList);*/
    }

    static void getWithPredicate(List<Student> students, Predicate<Student> pr) {
        students.removeIf(pr);
    }
}

class Filter<T> {
    void getStudents(List<? extends T> list, Predict<T> pr) {
        for (T val : list) {
            if (pr.test(val)) {
                System.out.println(val);
            }
        }
    }
}

interface Predict<T> {
    boolean test(T t);

    default Predict<T> and(Predict<? super T> other) {
        return new Predict<T>() {
            @Override
            public boolean test(T t) {
                return other.test(t) && Predict.this.test(t);
                /**
                 * Predict.this.test указывает на объект p1. Замыкание происходит на этапе формирования объекта new Predict<T>
                 * this(p1 грубо говоря инициатор создания) с помощью .and и other.
                 * Заставляем использовать .test с объектом, с помощью которого вызвался .and, чтобы не вызвать рекурсии
                 * Грубо говоря у нас есть объект, который замкнут между двумя анонимными объектами,
                 * в нём переопределён метод test и в этих объектах тоже. Всего у нас 3 объекта
                 * и при обращении Predict.this.test мы вызваем не переопределенный
                 * метод test у нового объекта, а у замкнутого. Если бы явно не указали вызов Predict.this.test
                 * произошла бы рекурсия, т.к. JVM бы вызывала постоянно переопределенный метод test и там бы снова вызывался test
                 * но в данном случае мы говорим, чтобы внутри test вызывался ПЕРЕОПРЕДЕЛЕННЫЙ метод test
                 * у первого анонимного объекта this
                 * и у второго other
                 */
            }
        };
    }
}