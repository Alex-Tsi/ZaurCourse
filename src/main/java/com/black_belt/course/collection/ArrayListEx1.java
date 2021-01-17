package com.black_belt.course.collection;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();
        var alex = new Student(23, "Alex", 4);
        var maria = new Student(18, "Maria", 1);
        var maksim = new Student(22, "Maxim", 4);
        arrayList.add(alex);
        arrayList.add(maria);
        arrayList.add(maksim);
        System.out.println(arrayList);
        var maksimCopy = new Student(22, "Maxim", 4);
        /*arrayList.remove(maksimCopy); //used equals not ==
        arrayList.remove(1);    //delete on index
        System.out.println(arrayList);*/
        arrayList.add(maksimCopy);
        var subList = arrayList.subList(1, 4);
        subList.add(new Student(21, "Andrey", 4));
        System.out.println(subList);
        System.out.println(arrayList);

        //arrayList.remove(1);          //Если удалить/добавить то вызовет эксепшн в саб листе
        //System.out.println(arrayList);
        //System.out.println(subList);  //.ConcurrentModificationException

        //subList.retainAll() //оставляет те элементы, которые переданы в аргумент (коллекция)

    }
}

