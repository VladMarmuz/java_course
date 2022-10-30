package io;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RandomAccessFile {
    public static void main(String[] args) {
        try(java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile("test10.txt","rw")){

            int a = randomAccessFile.read();//читает один байт
            System.out.println((char)a);

            String s1 = randomAccessFile.readLine();//просто читыеам строку
            System.out.println(s1);

            randomAccessFile.seek(101);// перемещаем курсор считывания на 101 байт вперёд и считываем из этоого места
            String s2 = randomAccessFile.readLine();
            System.out.println(s2);

            long position = randomAccessFile.getFilePointer();
            System.out.println(position);

           // randomAccessFile.seek(0);// перемещаемся в начало файла
           //  randomAccessFile.writeBytes("Привет");// заменяем первые байты на наше слово

            randomAccessFile.seek(randomAccessFile.length()-1);//перемещаемся в конец файла
            randomAccessFile.writeBytes("\n\t\t\t\t Мармуз Владислав");



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
