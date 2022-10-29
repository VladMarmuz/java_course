package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputAndOutputImageExample {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream
                ("C:\\Users\\Admin\\Desktop\\печать для тортов\\images.jfif");
             FileOutputStream outputStream = new FileOutputStream("image.jpeg")) {
            int i;
            while ((i=inputStream.read())!=-1){
                outputStream.write(i);

            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
