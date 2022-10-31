package stream;

import java.util.Objects;

public class Student {
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrd;


    public Student(String name, char sex, int age, int course, double avgGrd) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrd = avgGrd;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrd() {
        return avgGrd;
    }

    public void setAvgGrd(double avgGrd) {
        this.avgGrd = avgGrd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrd=" + avgGrd +
                '}';
    }

   /* @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || o.getClass()!=this.getClass()) return false;
        Student guest = (Student) o;
        return guest.age == age

    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getSex() == student.getSex() && getAge() == student.getAge() && getCourse() == student.getCourse() && Double.compare(student.getAvgGrd(), getAvgGrd()) == 0 && Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSex(), getAge(), getCourse(), getAvgGrd());
    }
}
