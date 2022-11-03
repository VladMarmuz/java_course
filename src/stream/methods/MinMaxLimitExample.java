package stream.methods;

import stream.Student;

import java.util.ArrayList;
import java.util.List;

public class MinMaxLimitExample {
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


        // Min и Max сравнивают через компаратор и выводят мин и макс значения
        Student studentMinAge = students.stream().
                min((a,b)-> a.getAge()- b.getAge()).get();

        System.out.println("Min : "+studentMinAge);

        Student studentMaxAge = students.stream()
                .max((a,b)-> a.getAge()-b.getAge()).get();
        System.out.println("Max : "+studentMaxAge);



        System.out.println("All elements who have age less than 22");
        students.stream()
                .filter(element -> element.getAge()<22)
                .forEach(System.out::println);

        //limit - ограничивает вывод( оставляет первые N элементов)

        System.out.println("Limit");
        students.stream()
                .filter(element -> element.getAge()<22)
                .limit(2)
                .forEach(System.out::println);


        //skip - пропускает первые N элементов
        System.out.println("Skip");
        students.stream()
                .filter(element -> element.getAge()<22)
                .skip(1)
                .forEach(System.out::println);

    }
}
