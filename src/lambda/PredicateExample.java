package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {


    void testStudent(List<Student> list, Predicate<Student> pr) {
        for (Student s : list) {
            System.out.println(pr.test(s));
        }
    }


    public static void main(String[] args) {
        Student st1 = new Student("Vlad", 2, 'm', 7.9, 19);
        Student st2 = new Student("Egor", 4, 'm', 6.7, 20);
        Student st3 = new Student("Alya", 3, 'f', 9.3, 18);
        Student st4 = new Student("Sofa", 2, 'f', 8.6, 17);
        Student st5 = new Student("Maks", 1, 'm', 8.2, 17);

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        PredicateExample example = new PredicateExample();

        example.testStudent(students, s -> s.avgGrade < 8.5);


        Predicate<Student> p1 = s -> s.avgGrade > 7.5;
        Predicate<Student> p2 = s -> s.sex == 'm';

        // объединяем 2 проверки
        example.testStudent(students,p1.and(p2));
        // или то, или это (можно чтобы совпадало 2)
        example.testStudent(students,p1.and(p2));

        // negate()- означает наоборот

        example.testStudent(students,p1.negate());
    }
}
