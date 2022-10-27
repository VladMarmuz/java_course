package generics.game;

public class Test {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Vlad", 14);
        Schoolar schoolar2 = new Schoolar("Egor", 15);

        Student student1 = new Student("Natasha",22);
        Student student2 = new Student("Nikita",24);
        Employee employee1 = new Employee("Sergei", 39);
        Employee employee2 = new Employee("Kira", 35);

        Team<Schoolar> schoolarTeam = new Team("Lucky");
        Team<Student> studentsTeam = new Team("Wolfs");
        Team<Employee> employeesTeam = new Team("Frogs");

        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        studentsTeam.addNewParticipant(student1);
        studentsTeam.addNewParticipant(student2);

        employeesTeam.addNewParticipant(employee1);
        employeesTeam.addNewParticipant(employee2);

        Team<Schoolar> schoolarTeam2 = new Team("Dream");
        Schoolar schoolar3 = new Schoolar("Sergei", 13);
        Schoolar schoolar4 = new Schoolar("Misha", 15);
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);

        schoolarTeam.playWith(schoolarTeam2);



    }
}
