package com.black_belt.course.data;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Faculty {
    private String name;
    private List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        studentsOnFaculty = new ArrayList<>();
    }

    public Faculty() {
        studentsOnFaculty = new ArrayList<>();
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student s) {
        studentsOnFaculty.add(s);
    }

    public void setStudentsOnFaculty(List<Student> list) {
        studentsOnFaculty = list;
    }
}