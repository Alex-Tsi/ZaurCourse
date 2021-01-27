package com.black_belt.course.lambda_expressions;

import com.black_belt.course.data.Student;
import lombok.var;

import java.util.*;
import java.util.function.Function;

public class StudentInfo {

    StudentCheck check = s -> false;

    public static void main(String[] args) {
        List<Student> stList = Student.StudentsInsert.insert();

        var info = new StudentInfo();

        /**
         * @Author Alex
         * Лямбда понимает, что ожидается аргумент типа StudentCheck (функциональный интерфейс)
         * Она знает, что единственный метод этого интерфейса принимает аргумент типа Student
         * с возвращаемым значением boolean. В Лямбда может использоваться любой тип возвращаемого значения,
         * который описан в функциональном интерфейсе.
         * <b>Лямбда выражения - это укороченная запись анонимного класса, который имплементирует функциональный интерфейс</b>
         */

        info.getStudents(stList, (s -> s.getName().charAt(0) == 'I'));

        /**
         * Также как и анонимный класс. Просто укороченная запись. Можно использовать везде, даже в полях класса.
         */
        StudentCheck studentCheck = s -> true;

        info.getStudents(stList, studentCheck);

        Collections.sort(stList, (Student stObj1, Student stObj2) ->
                Integer.compare(stObj1.getCourse(), stObj2.getCourse())   //Или же ((Integer)stObj1.getCourse()).compareTo(stObj2.getCourse())
        );
        System.out.println(stList);
        //То же самое
        Comparator<Student> comparator1 = Comparator.comparing(new Function<Student, Double>() {
            @Override
            public Double apply(Student student) {
                return student.getAvgGrade();
            }
        });
        Comparator<Student> comparator2 = Comparator.comparing(student -> student.getAvgGrade());
        Comparator<Student> comparator3 = Comparator.comparing(Student::getAvgGrade);
        stList.sort(comparator3);
        System.out.println(stList);
    }

    void getStudents(List<? extends Student> al, StudentCheck cs) {
        for (Student st : al) {
            if (cs.check(st)) {
                System.out.println(st);
            }
        }
        System.out.println("-------------------------");
    }
}

interface StudentCheck {
    boolean check(Student s);
}