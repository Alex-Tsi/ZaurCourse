package com.black_belt.course.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.var;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LinkedListEx {
    public static void main(String[] args) {
        var lnList = new LinkedList<Student>();
        GenericType<? extends Number> gt = new GenericType<>();
        /*gt.foo(new Integer(1));
        GenericType<? super Integer> gt2 = new GenericType<>();
        Integer integer = gt2.retFoo(new Integer(1));*/
        HashMap<Object, Object> map = new HashMap<>();
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());


        Map<Dog, String> dogStringMap = new HashMap<>();
        dogStringMap.put(new Dog("Mari", 10), "Mari");
        dogStringMap.put(new Dog("Mari", 10), "Ali");
        dogStringMap.put(new Dog("Mari", 10), "Mari");
        dogStringMap.put(new Dog("Mari", 10), "Ali");
        dogStringMap.put(new Dog("Mari", 10), "Mari");
        dogStringMap.put(new Dog("Mari", 10), "Ali");
        dogStringMap.put(new Dog("Mari", 10), "Mari");
        dogStringMap.put(new Dog("Mari", 10), "Ali");
        dogStringMap.put(new Dog("Mari", 10), "Mari");
        dogStringMap.put(new Dog("Mari", 10), "Ali");
        dogStringMap.put(new Dog("Mari", 10), "Mari");
        dogStringMap.put(new Dog("Mari", 10), "Ali");
        dogStringMap.put(new Dog("Mari", 10), "Mari");
        dogStringMap.put(new Dog("Mari", 10), "Ali");
        dogStringMap.put(new Dog("Mari", 10), "Mari");
        dogStringMap.put(new Dog("Mari", 10), "Ali");
        System.out.println(dogStringMap);


        System.out.println(map);
        Set<Map.Entry<Object, Object>> set = map.entrySet();
        set.remove(set.iterator().next());
        System.out.println(set);
    }


}

class GenericType<T> {
    public void foo(T t) {
    }

    public T retFoo(T arg) {
        return arg;
    }
}

@Data
@AllArgsConstructor
@ToString
class Dog {
    String name;
    int size;


    @Override
    public boolean equals(Object obj) {
        Dog dog = (Dog) obj;
        return this.equals(dog) && this.equals(size);
    }
}