package comparation.comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employee = new Employee(100, "Egor", "Egorov", 2100);
        Employee employee1 = new Employee(213, "Ivan", "Sidorov", 1700);
        Employee employee2 = new Employee(134, "Vlad", "Marmuz", 1890);
        list.add(employee);
        list.add(employee1);
        list.add(employee2);
        System.out.println("Before sort \n" + list);
        Collections.sort(list, new IdComparator());
        System.out.println("After sort \n" + list);
        Collections.sort(list, new NameComparator());
    }

}

class Employee {
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
}


class IdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.id == emp2.id) {
            return 0;
        } else if (emp1.id < emp2.id) {
            return -1;
        } else {
            return 1;
        }

    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.name.compareTo(emp2.name);
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.salary - emp2.salary;
    }
}
