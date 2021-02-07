package com.black_belt.course.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) {
        int character;
        try (FileReader reader = new FileReader("rubai.txt");
             FileWriter writer = new FileWriter("rubai.txt");
             FileWriter writer1 = new FileWriter("rubai.txt")) {
            while ((character = reader.read()) != -1) { //конец файл всегда возвращает -1
                System.out.print((char) character);
            }
//            writer.write("a");
//            writer1.write("b");
            //второй поток заблокирован
            //поток на чтение тоже заблокирован до тех пор, пока writer не закроет и файл не разблокируется
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

