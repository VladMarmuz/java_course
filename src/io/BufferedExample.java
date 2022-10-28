package io;

import java.io.*;

public class BufferedExample {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\test1.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("test3.txt"))) {

           /* int character;
            while((character=reader.read())!=-1){
                writer.write((char) character);
            }*/

            String line;
            while((line = reader.readLine())!= null){
                writer.write(line);
                writer.write("\n");
            }

            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
