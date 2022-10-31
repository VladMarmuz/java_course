package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChainingExample {
    public static void main(String[] args) {
        int[] arr = {9, 20, 45, 33, 88, 79, 4, 18, 22, 27};

        int result = Arrays.stream(arr)
                .filter(el -> el % 2 == 1)
                .map(el -> {
                    if (el % 3 == 0) {
                        el = el / 3;
                    }
                    return el;
                })
                .reduce((a, el) -> a + el).getAsInt();

        System.out.println(result);


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

        students.stream()
                .map(el -> {
                    el.setName(el.getName().toUpperCase());
                    return el;
                })
                .filter(el->el.getSex()=='f')
                .sorted((a,b)-> a.getAge()-b.getAge())
                .forEach(el-> System.out.println(el));

    }
}
