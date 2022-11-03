package stream.methods;

import stream.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapToIntExample {
    public static void main(String[] args) {
        Student st1 = new Student("Vlad", 'm', 18, 2, 7.8);
        Student st2 = new Student("Elena", 'f', 22, 4, 8.3);
        Student st3 = new Student("Nikita", 'm', 17, 1, 7.1);
        Student st4 = new Student("Katya", 'f', 19, 2, 9.4);
        Student st5 = new Student("Misha", 'm', 21, 3, 6.5);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        // mapToInt - когда нужно сохранить поле с интовым значением в отдельный лист
        //boxed -конвертирует int в Integer( т.е. из примитива в обертку)
        List<Integer> cources = students.stream()
                .mapToInt(element -> element.getCourse())
                .boxed()
                .collect(Collectors.toList());

        List<Double> c = students.stream()
                .mapToDouble(element -> element.getAvgGrd())
                .boxed()
                .collect(Collectors.toList());

        // sum ,average(среднее арифметическое)

        int sum  = students.stream().mapToInt(el->el.getAge()).sum();
        System.out.println(sum);
        double average  = students.stream().mapToInt(el->el.getAge()).average().getAsDouble();
        System.out.println(average);
        int min  = students.stream().mapToInt(el->el.getAge()).min().getAsInt();
        System.out.println(min);
        int max  = students.stream().mapToInt(el->el.getAge()).max().getAsInt();
        System.out.println(max);

    }
}
