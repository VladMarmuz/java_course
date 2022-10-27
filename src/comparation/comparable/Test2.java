package comparation.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employee= new Employee(100,"Egor","Egorov", 2100);
        Employee employee1= new Employee(213,"Ivan","Sidorov", 1700);
        Employee employee2= new Employee(134,"Vlad","Marmuz", 1890);
        list.add(employee);
        list.add(employee1);
        list.add(employee2);
        System.out.println("Before sort \n" + list);
        Collections.sort(list);
        System.out.println("After sort \n" + list);
    }

}

class Employee implements Comparable<Employee>{
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee anotherEmp) {
       /* if(this.id == anotherEmp.id){
            return 0;
        } else if (this.id< anotherEmp.id) {
            return -1;
        }else {
            return 1;
        }*/

        /**если по имени равны, то сравни по фамилии */

       /* int result = this.name.compareTo(anotherEmp.name);
        if (result == 0){
            result = this.surname.compareTo(anotherEmp.surname);
        }
        return result;*/

        return this.id-anotherEmp.id; //+1(this больше) -1(another больше) 0(равны);
    }
}