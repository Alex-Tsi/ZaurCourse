package com.black_belt.course.streams;

import com.black_belt.course.data.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinMax {
    public static void main(String[] args) {
        List<Student> studentList = Student.StudentsInsert.insert();
        Student minCourse = studentList.stream().min(Comparator.comparingInt(Student::getCourse)).orElse(null);
        //min(t) - находим минимальное значение по компаратору (сначала сорт, потом поиск)
        System.out.println(minCourse != null ? minCourse : "not present");
        studentList.stream().max(Comparator.comparingInt(Student::getCourse)).ifPresent(System.out::println);
        //max(t) - аналогично
        //findFirst(t) - поиск первого по определенному фильтру
        //limit(i) - сокращаем стрим до конкретного лимита .limit(2) - вывод двух
        //skip(i) - пропускаем первых N элементов .skip(2) - пропуск двух


        int[] array = studentList.stream().mapToInt(Student::getCourse).toArray();
        System.out.println(Arrays.toString(array));
        List<Integer> courseList = studentList.stream().mapToInt(Student::getCourse)
                .boxed() //для упаковки интов (из int в Integer)
                .collect(Collectors.toList());
        System.out.println(courseList);
        int sumCourses = studentList.stream().mapToInt(Student::getCourse).sum();
        System.out.println(sumCourses);
        double averageCourse = studentList.stream().mapToInt(Student::getCourse).average().getAsDouble();
        System.out.println(averageCourse);
        int min = studentList.stream().mapToInt(Student::getCourse).min().getAsInt();
        int max = studentList.stream().mapToInt(Student::getCourse).max().getAsInt();
        System.out.println(min + " - min\n" + max + " -max");

    }
}
