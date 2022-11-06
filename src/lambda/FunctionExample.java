package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    // function принимает и возвращает элемент


    public static double avgOfSmth(List<Student> l, Function<Student,Double> f){
        double result= 0;

        for (Student s : l) {
            result+=f.apply(s);
        }
        result= result/ l.size();
        return result;
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

        Function<Student,Double> resFunction = student -> student.avgGrade;

        double result = avgOfSmth(students, st -> (double) st.age);
        System.out.println(result);


    }
}
