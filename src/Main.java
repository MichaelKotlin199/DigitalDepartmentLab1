import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Subject math = new Subject("Mathematics");
        Subject physics = new Subject("Physics");
        Subject history = new Subject("History");

        Student student1 = new Student("Ivan", "Group A", 1);
        student1.addGrade(math, 4);
        student1.addGrade(physics, 3);
        student1.addGrade(history, 5);

        Student student2 = new Student("Petr", "Group B", 1);
        student2.addGrade(math, 2);
        student2.addGrade(physics, 2);
        student2.addGrade(history, 3);

        Student student3 = new Student("Maria", "Group A", 1);
        student3.addGrade(math, 5);
        student3.addGrade(physics, 5);
        student3.addGrade(history, 5);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        filterAndPromoteStudents(students);

        System.out.println("Students on course 2:");
        printStudents(students, 2);
    }

    public static void filterAndPromoteStudents(List<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
        students.forEach(student -> {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        });
    }

    public static void printStudents(List<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
