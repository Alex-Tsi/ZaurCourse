package com.black_belt.course.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceStream {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(8);
        integerList.add(2);
        integerList.add(4);
        integerList.add(3);

        int intResult = integerList.stream().reduce((accumulator, integer) -> accumulator * integer).get(); //.orElse(0)
        System.out.println(intResult);
        intResult = integerList.stream().reduce(5, (accumulator, integer) -> accumulator * integer);
        System.out.println(intResult);

        Optional<Integer> o = integerList.stream().reduce((accumulator, integer) -> accumulator * integer);
        if (o.isPresent()) {
            System.out.println(o.get());
        } else {
            System.out.println("Not present");
        }

        List<String> stringList = new ArrayList<>();
        stringList.add("Privet");
        stringList.add("Kak dela?");
        stringList.add("OK");
        stringList.add("Poka");

        Optional<String> optionalS = stringList.stream().reduce((a, e) -> a + " " + e);

        String stringResult = optionalS.orElse("Not present");
        System.out.println(stringResult);

    }
}
