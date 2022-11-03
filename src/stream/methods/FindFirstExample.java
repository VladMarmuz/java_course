package stream.methods;

import stream.Student;

import java.util.ArrayList;
import java.util.List;

public class FindFirstExample {
    public static void main(String[] args) {
        Student st1 = new Student("Vlad", 'm', 18, 2, 7.8);
        Student st2 = new Student("Elena", 'f', 22, 4, 8.3);
        Student st3 = new Student("Nikita", 'm', 18, 1, 7.1);
        Student st4 = new Student("Katya", 'f', 19, 2, 9.4);
        Student st5 = new Student("Misha", 'm', 21, 3, 6.5);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);


        // выводит первый элемент из полученного результата
        Student firstStudent = students.stream()
                .map(el -> {
                    el.setName(el.getName().toUpperCase());
                    return el;
                })
                .sorted((a, b) -> a.getAge() - b.getAge())
                .sorted((a,b)-> a.getCourse()-b.getCourse())
                .findFirst().get();
        System.out.println(firstStudent);
    }
}
