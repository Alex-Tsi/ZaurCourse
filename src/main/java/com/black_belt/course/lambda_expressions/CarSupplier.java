package com.black_belt.course.lambda_expressions;

import com.black_belt.course.data.Car;

import java.util.*;
import java.util.function.Supplier;

public class CarSupplier {

    public static List<Car> createCars(Supplier<Car> s) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(s.get());
        }
        return list;
    }

    public static void main(String[] args) {
        List<Car> cars = createCars(() -> new Car("Toyota", "Green", 3.14));
        for(Car c : cars) System.out.println(c);
    }
}

