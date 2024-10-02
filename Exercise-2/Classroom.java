import java.util.*;

public class Classroom {
    private String name;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void scheduleAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

    public void submitAssignment(String studentId, Assignment assignment) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                student.submitAssignment(assignment);
                return;
            }
        }
        System.out.println("Student " + studentId + " not found in " + name + ".");
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}

