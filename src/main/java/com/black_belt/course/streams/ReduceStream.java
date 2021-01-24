package com.black_belt.course.streams;

import java.util.ArrayList;
import java.util.List;

public class ReduceStream {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(8);
        integerList.add(2);
        integerList.add(4);
        integerList.add(3);

        int result = integerList.stream().reduce((accumulator, integer) -> accumulator * integer).get();
        System.out.println(result);

    }
}
