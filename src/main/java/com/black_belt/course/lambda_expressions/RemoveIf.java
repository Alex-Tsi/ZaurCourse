package com.black_belt.course.lambda_expressions;


import java.util.ArrayList;
import java.util.List;

public class RemoveIf {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        al.add("Hi");
        al.add("Bye");
        al.add("Ok");
        al.add("Learn Java");
        al.add("Viz. lambdas");
        al.removeIf(element -> element.length() < 5);
        System.out.println(al);
    }
}
