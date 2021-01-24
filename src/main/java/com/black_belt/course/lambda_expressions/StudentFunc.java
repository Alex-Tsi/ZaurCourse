package com.black_belt.course.lambda_expressions;

import com.black_belt.course.data.Student;

import java.util.List;
import java.util.function.Function;

public class StudentFunc {
    public static void main(String[] args) {
        List<Student> students = Student.StudentsInsert.insert();
        double avgGrade = avgOfGrade(students, student -> student.getAvgGrade());
        System.out.println(avgGrade);
    }

    private static double avgOfGrade(List<? extends Student> students, Function<Student, Double> function) {
        double result = 0;
        for (Student s : students) {
            result += function.apply(s);
        }
        return result / students.size();
    }
}
