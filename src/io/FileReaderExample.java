package io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args){
        try(FileReader reader = new FileReader("C:\\Users\\Admin\\Desktop\\test1.txt")) {

            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
