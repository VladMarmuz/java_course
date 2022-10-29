package io.serialization.pragrammer1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample1 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Egor");
        employees.add("Nikita");
        employees.add("Katya");
        employees.add("Chel");
        employees.add("Batya");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees.bin"))) {

            outputStream.writeObject(employees);
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
