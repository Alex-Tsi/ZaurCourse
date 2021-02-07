package com.black_belt.course.streams;

import com.black_belt.course.data.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class ChainingStream {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        int result = Arrays.stream(array).filter(value -> value % 2 == 0).map(operand -> operand % 3 == 0 ? operand /= 3 : operand)
                .reduce((a, r) -> a += r).orElseThrow(() -> new RuntimeException("not present"));
        /*OptionalInt o = Arrays.stream(array).filter(value -> value % 2 == 0).map(operand -> operand % 3 == 0 ? operand /= 3 : operand)
                .reduce((a, r) -> a += r);
        System.out.println(o.isPresent() ? o.getAsInt() : "Not present");*/
        System.out.println(result);

        List<Student> studentList = Student.StudentsInsert.insert();
        studentList.stream().map(student -> {
            student.setName(student.getName().toLowerCase());
//            System.out.println(student); //доказательно того, что terminal (eager) методы (foreach, reduce и т.п.)
            //заставляет работать цепочку (chaining) методов (intermediate(промежуточные) (lazy)).
            //Terminal методы - это те, которые не возвращают стримы и грубо говоря оканчивают цепочку.
            return student;
        }).filter(student -> student.getCourse() > 1 && student.getAvgGrade() > 8).forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------------------");


        //Лучше писать так
        studentList.stream().peek(student -> student.setName(student.getName().toLowerCase()))
                .filter(student -> student.getCourse() > 1 && student.getAvgGrade() > 8).forEach(System.out::println);
    }
}