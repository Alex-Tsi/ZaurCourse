package com.black_belt.course.lambda_expressions;

import com.black_belt.course.data.Animal;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Consume {
    public static void main(String[] args) {
        var an1 = new Animal("Miha", "Tiger", 183);
        var an2 = new Animal("Li", "Lion", 167);
        List<Animal> animals = new ArrayList<>();
        animals.add(an1);
        animals.add(an2);
        changeAnimal(animals, (Animal an) -> an.setSize(an.getSize() + 5));
        animals.forEach(animal -> {
            animal.setSize(animal.getSize() + 5);
            System.out.println(animal);
        });
        System.out.println(animals);
    }

    static void changeAnimal(List<Animal> animals, Consumer<Animal> con) {
        for (Animal a : animals) {
            con.accept(a);
        }
        System.out.println(animals);
    }

}

