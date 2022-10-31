package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {
    public static void main(String[] args) {
        Student st1 = new Student("Vlad",'m',18,2,7.8);
        Student st2 = new Student("Egor",'m',22,4,8.3);
        Student st3 = new Student("Nikita",'m',18,1,7.1);
        Student st4 = new Student("Ivan",'m',19,2,9.4);
        Student st5 = new Student("Misha",'m',21,3,6.5);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        //сортировка массива
        int[] arr = {9,20,45,33,88,79,4,17,22,57};
        arr = Arrays.stream(arr).sorted().toArray();
        System.out.println(Arrays.toString(arr));

        //сортировка листа по полю Name
        students = students.stream().sorted((a, b) -> a.getName().compareTo(b.getName()))
                .collect(Collectors.toList());
        System.out.println(students);

    }
}
