package com.black_belt.course.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        doubles.add(10.0);
        doubles.add(5.0);
        doubles.add(1.0);
        doubles.add(0.25);

        double sumResult = doubles.parallelStream()
                .reduce(Double::sum).orElse(0.0);
        System.out.println(sumResult);

        double divisionResult = doubles.parallelStream()
                .reduce((ac, e) -> ac / e).orElse(0.0);
        System.out.println(divisionResult); //не верный результат.
        //параллельные стримы лучше не использовать, когда нужен последовательный порядок выполнения операций
    }
}
