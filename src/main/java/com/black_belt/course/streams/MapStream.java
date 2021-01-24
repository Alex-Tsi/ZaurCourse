package com.black_belt.course.streams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapStream {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("how are you");
        stringList.add("OK");
        stringList.add("bye");
        System.out.println("Before loop modifier");
        for (int i = 0; i < stringList.size(); i++) {
            stringList.set(i, Integer.toString(stringList.get(i).length()));
        }
        System.out.println();
        System.out.println("With for loop\n" + stringList);

        // [5, 11, 2, 3]
        List<Integer> integerList = stringList.stream().map(element -> element.length()).collect(Collectors.toList());
        //System.out.println(integerList);

        int[] array = {5, 9, 3, 8, 1};
        System.out.println(Arrays.toString(array));
        // [5, 3, 1, 8, 1]
        array = Arrays.stream(array).map(element -> {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
        System.out.println(Arrays.toString(array));

        Set<String> stringSet = new TreeSet<>();
        stringSet.add("hello");
        stringSet.add("how are you");
        stringSet.add("OK");
        stringSet.add("bye");
        stringSet.add("all");
        System.out.println(stringSet);
        Set<Integer> integerSet = stringSet.stream().map(element -> element.length()).collect(Collectors.toSet());
        System.out.println(integerSet);

//        A.B ab = new A.B(); Так можно
    }
}

abstract class A {
    private A() {  //В основном лишено смысла

    }

    static class B extends A {

    }
}
