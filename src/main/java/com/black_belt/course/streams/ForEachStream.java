package com.black_belt.course.streams;

import com.black_belt.course.data.Student;

import java.util.Arrays;
import java.util.List;


public class ForEachStream {
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array).map(value -> {
            return value = value % 3 == 0 ? (value /= 3) : (value /= 1);
        }).toArray();
        /**
         * for (int i : array) {
         *     System.out.println(i)
         * }
         */
        Arrays.stream(array).forEach(System.out::println); // value -> System.out.println(value)
        //Ещё раз
//        Arrays.stream(array).forEach(new TestUtil()::utilMethod);
        //forEach - аналог ForEach loop, return type void
        System.out.println(Arrays.toString(array));

        //------------------------------------------------------------------------------------------------------------------------

        /**
         * Неважная дичь
         */
        List<Student> studentList = Student.StudentsInsert.insert();
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        studentList.forEach(element -> {
            buffer.append(element.getCourse());
            buffer.append(", ");
        });
        buffer.delete(buffer.length() - 2, buffer.length());
        buffer.append("]");
        System.out.println(buffer);
    }
}

//class TestUtil {
//    public void utilMethod(int i) {
//        i += 1;
//        System.out.println(i);
//    }
//}