package com.black_belt.course.io;

import lombok.SneakyThrows;

import java.io.*;

public class BufferedEx {
    @SneakyThrows
    public static void main(String[] args) {
        File from = new File("rubai.txt");
        File to = new File("rubaiCopy.txt");
        String result;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(to, true));
             BufferedReader reader = new BufferedReader(new FileReader(from))) {
            while ((result = reader.readLine()) != null) {
                writer.write(result);
                writer.write("\n");
            }
        }
    }
}
