package com.black_belt.course.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) {
        String rubai = "Много лет я над жизнью размышлял.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего не известно!\n" +
                "Вот последняя правда, открытая мной.\n";
        String wordAppend = "Done!\n";

//        FileWriter writer;  //так нельзя, ссылочная переменная также должна быть объявлена в блоке try ()

        try (FileWriter writer = new FileWriter("rubai.txt", true)) { //теперь, когда используем write/append
            //будет добавляться в конец файла
            writer.append(rubai);
            writer.append(wordAppend);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } //try () с ресурсами сам закроет поток
    }
    // close() Закрывает файл связанный с объектом, он отмежевывается от потока.
    // Любая находящаяся в ожидании выходная последовательность записывается в физический файл.
    // Когда поток открывает файл, то этот файл блокируется, и никто не сможет получить к нему доступ.
    // Для этого и необходим вызов метода close - файл закрывается и разблокируется.
}
