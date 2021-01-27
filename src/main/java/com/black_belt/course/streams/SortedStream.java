package com.black_belt.course.streams;

import com.black_belt.course.data.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedStream {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));

        List<Student> list = Student.StudentsInsert.insert();
//        list = list.stream().sorted(Comparator.comparingInt(Student::getCourse)).collect(Collectors.toList());  //by Comparator
        //System.out.println(list);
        list = list.stream().sorted().collect(Collectors.toList()); //by Comparable
        System.out.println(list);
    }
}