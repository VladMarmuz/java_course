package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной\n" +
                "Мне известно, что мне ничего не известно\n" +
                "Вот последняя правда, открытая мной";

        String string = " new part";
        try ( FileWriter writer = new FileWriter("C:\\Users\\Admin\\Desktop\\test1.txt");){
            //можно и не создавать файл изначально для записи ,
            // можно написать навзвание и файл создастся в корне проекта
            //writer = new FileWriter(" test2.txt", true);

            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));
            }
            writer.write(string);
            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
