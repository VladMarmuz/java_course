package lambda;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentInfo {

    void testStudents(List<Student> list, CheckStudents checkStudents) {
        for (Student s : list)
            if (checkStudents.check(s)) {
                System.out.println(s);
            }
    }

   /* void printStudentOverGrade(List<Student> list, double grade){

        for(Student s: list){
            if(s.avgGrade>grade){
                System.out.println(s);
            }
        }

    }
    void printStudentLowerAge(List<Student> list, int age){
        for(Student s: list){
            if(s.age<age){
                System.out.println(s);
            }
        }


    }
    void printStudentMixConditions(List<Student> list, double grade, int age, char sex){
        for(Student s: list){
        if(s.avgGrade<grade && s.age<age && s.sex==sex){
            System.out.println(s);
        }
    }

    }*/
}

class Test {
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

        StudentInfo info = new StudentInfo();

       /* Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.course- o2.course;
            }
        });*/

        Collections.sort(students, (a,b)-> a.course-b.course);


        info.testStudents(students, s -> s.avgGrade < 8.4);
        System.out.println("----------------------------------");

        info.testStudents(students, (Student student) -> student.age < 19);
        System.out.println("----------------------------------");

        info.testStudents(students, (Student student) -> {
            return student.age < 19 && student.avgGrade < 8.1 && student.sex == 'f';
        });
        System.out.println("----------------------------------");

        CheckStudents checkStudents= s -> s.avgGrade<8.4;
        info.testStudents(students,checkStudents);

    }
}

class CheckOverGrade implements CheckStudents {
    @Override
    public boolean check(Student student) {
        return student.avgGrade > 8;
    }
}

