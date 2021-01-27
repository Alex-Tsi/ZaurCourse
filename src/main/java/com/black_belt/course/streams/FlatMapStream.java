package com.black_belt.course.streams;

import com.black_belt.course.data.Faculty;
import com.black_belt.course.data.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapStream {

    public static void main(String[] args) {
        List<Student> studentList = Student.StudentsInsert.insert();
        Faculty economics = new Faculty("Экономика");
        Faculty it = new Faculty("IT");
        economics.addStudent(studentList.get(0));
        economics.addStudent(studentList.get(1));
        it.addStudent(studentList.get(2));
        it.addStudent(studentList.get(3));
        it.addStudent(studentList.get(4));

        //--------------------------------------------------------------------------------

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(economics);
        facultyList.add(it);
        facultyList.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
                .forEach(System.out::println); //flatMap(i) - работаем с внутренним стримом
        System.out.println(facultyList);


        //--------------------------------------------------------------------------------

        studentList.stream()
                .peek(student -> student.setName(student.getName().toLowerCase()))
                .collect(Collectors.groupingBy(Student::getCourse)).entrySet().forEach(System.out::println);
        //groupingBy(i) - получаем Map<Integer, List<Student>> - ключ - номер группы, значение - лист (данные)

        studentList.stream().collect(Collectors
                .partitioningBy(student -> student.getCourse() > 2))
                .entrySet().forEach(System.out::println);
        //partitioningBy(i) - получаем Map<Boolean, List<Student>> - ключ - булев, значение - лист (данные)

    }
}
