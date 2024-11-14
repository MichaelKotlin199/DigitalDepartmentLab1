import java.util.HashMap;
import java.util.Map;

public class Student {
    private final String name;
    private String group;
    private int course;
    private Map<Subject, Integer> grades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<Subject, Integer> getGrades() {
        return grades;
    }

    public void addGrade(Subject subject, int grade) {
        grades.put(subject, grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        return grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }
}