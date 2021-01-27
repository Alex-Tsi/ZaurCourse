package com.black_belt.course.streams;

import java.util.stream.Stream;

public class Methods {
    public static void main(String[] args) {
        //-----------------------------------------------------------------------
        System.out.println("Concat result: ");
        Stream<Integer> concatFirst = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> concatSecond = Stream.of(7, 8, 9, 10);
        Stream<Integer> streamConcat = Stream.concat(concatFirst, concatSecond); //concat - просто склеивает
        streamConcat.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");


        //-----------------------------------------------------------------------
        System.out.println("Distinct result: ");
        Stream<Integer> distinctStream = Stream.of(1, 2, 3, 1, 2, 3, 1, 2, 3);
        distinctStream.distinct().forEach(System.out::println); //distinct(i) - уникальные значения
        System.out.println("--------------------------------------------------------------------------------");


        //-----------------------------------------------------------------------
        System.out.println("Count result: ");
        Stream<Integer> countStream = Stream.of(1, 2, 3, 4, 5, 0);
        long countResult = countStream.count(); //count(t) - возвращает количество элементов
        System.out.println(countResult);
        System.out.println("--------------------------------------------------------------------------------");

        //Стрим можно использовать только 1 раз
    }
}
