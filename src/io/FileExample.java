package io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileExample {
    public static void main(String[] args) throws IOException {
        // Нужен для работы с файлами и директориями

        File file = new File("test2.txt");
        File folder = new File("C:\\Users\\Admin\\Desktop\\Инфа для собеса");
        File file1 = new File("example.txt");
        File folder1 = new File("example");
        System.out.println("Абсолютный путь: "+ file.getAbsolutePath());
        System.out.println("Абсолютный путь: "+ folder.getAbsolutePath());
        System.out.println("----------------------");
        System.out.println("Абсолютный ли путь? "+ file.isAbsolute());
        System.out.println("Абсолютный ли путь? "+ folder.isAbsolute());
        System.out.println("----------------------");
        System.out.println("Является ли созданный файл директорией? "+ file.isDirectory());
        System.out.println("Является ли созданный файл директорией? "+ folder.isDirectory());
        System.out.println("----------------------");
        System.out.println("Существует ли? "+ file.exists());
        System.out.println("Существует ли? "+ folder.exists());
        System.out.println("----------------------");
        System.out.println("создать файл "+ file1.createNewFile());
        System.out.println("создать директорию "+folder1.mkdir());
        System.out.println("----------------------");
        System.out.println("Узнать размер "+ file.length());
        System.out.println("Узнать размер "+ folder.length());
        System.out.println("----------------------");
        File[] files = folder.listFiles();
        System.out.println("Вывести содержимое папки");
        System.out.println(Arrays.toString(files));
        System.out.println("----------------------");
        System.out.println("Скрыт файл или нет? " + file.isHidden());



    }
}
