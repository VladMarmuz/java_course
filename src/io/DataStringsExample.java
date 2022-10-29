package io;

import java.io.*;

public class DataStringsExample {
    public static void main(String[] args) {
        try (DataOutputStream outputStream =new DataOutputStream(new FileOutputStream("my_test.bin"));
             DataInputStream inputStream = new DataInputStream(new FileInputStream("my_test.bin"))){


            outputStream.writeBoolean(true);
            outputStream.writeByte(2);
            outputStream.writeInt(10000);
            outputStream.writeLong(200300040000L);
            outputStream.writeFloat(134F);

            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readByte());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readLong());
            System.out.println(inputStream.readFloat());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
