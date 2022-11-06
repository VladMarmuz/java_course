package lambda;

public class Student {
    String name;
    int course;
    char sex;
    double avgGrade;

    int age;

    public Student(String name, int course, char sex, double avgGrade, int age) {
        this.name = name;
        this.course = course;
        this.sex = sex;
        this.avgGrade = avgGrade;
        this.age= age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", sex=" + sex +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
