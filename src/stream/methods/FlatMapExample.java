package stream.methods;

import stream.Student;

import java.util.ArrayList;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        Student st1 = new Student("Vlad", 'm', 18, 2, 7.8);
        Student st2 = new Student("Elena", 'f', 22, 4, 8.3);
        Student st3 = new Student("Nikita", 'm', 18, 1, 7.1);
        Student st4 = new Student("Katya", 'f', 19, 2, 9.4);
        Student st5 = new Student("Misha", 'm', 21, 3, 6.5);

        Faculty f1 =  new Faculty("Economics");
        Faculty f2 = new Faculty("Mathematics");
        f1.addStudentToFaculty(st1);
        f1.addStudentToFaculty(st2);
        f1.addStudentToFaculty(st3);
        f2.addStudentToFaculty(st4);
        f2.addStudentToFaculty(st5);

        List<Faculty>  faculties = new ArrayList<>();
        faculties.add(f1);
        faculties.add(f2);

        //flatMap - используется, когда нам нужно работать с элементам элементов в нашей коллекции
        //в данной ситуации мы открыли стрим у листа всех факультетов, а затем работаем со стримом листов отдельно каждого факультет
        faculties.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream()).
                forEach(student -> System.out.println(student.getName()));


    }
    
}
class Faculty{
    String name;
    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        studentsOnFaculty = new ArrayList<>();
    }


    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void addStudentToFaculty(Student student){
        studentsOnFaculty.add(student);
    }
}
