package com.black_belt.course.streams;

import com.black_belt.course.data.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStream {
    public static void main(String[] args) {
        List<Student> studentList = Student.StudentsInsert.insert();

        studentList = studentList.stream().filter(element -> element.getCourse() > 1).collect(Collectors.toList());

        System.out.println(studentList);

        /**
         * Simple stream reference
         */
        Stream<Student> myStream = Stream.of(studentList.get(0), studentList.get(1), studentList.get(2));


        System.out.println();

    }
}