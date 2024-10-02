import java.util.*;

public class VirtualClassroomManager {
    private static Map<String, Classroom> classrooms = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);

            if (parts.length < 2) {
                System.out.println("Invalid command.");
                continue;
            }

            String command = parts[0];
            String argument = parts[1];

            switch (command) {
                case "add_classroom":
                    addClassroom(argument);
                    break;
                case "add_student":
                    addStudent(argument);
                    break;
                case "schedule_assignment":
                    scheduleAssignment(argument);
                    break;
                case "submit_assignment":
                    submitAssignment(argument);
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private static void addClassroom(String className) {
        if (!classrooms.containsKey(className)) {
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
        } else {
            System.out.println("Classroom " + className + " already exists.");
        }
    }

    private static void addStudent(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 2) {
            System.out.println("Invalid student addition format.");
            return;
        }
        String studentId = parts[0];
        String className = parts[1];

        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom " + className + " does not exist.");
        } else {
            classroom.addStudent(new Student(studentId));
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        }
    }

    private static void scheduleAssignment(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length != 2) {
            System.out.println("Invalid assignment scheduling format.");
            return;
        }
        String className = parts[0];
        String assignmentDetails = parts[1];

        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom " + className + " does not exist.");
        } else {
            classroom.scheduleAssignment(new Assignment(assignmentDetails));
            System.out.println("Assignment for " + className + " has been scheduled.");
        }
    }

    private static void submitAssignment(String input) {
        String[] parts = input.split(" ", 3);
        if (parts.length != 3) {
            System.out.println("Invalid assignment submission format.");
            return;
        }
        String studentId = parts[0];
        String className = parts[1];
        String assignmentDetails = parts[2];

        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom " + className + " does not exist.");
        } else {
            classroom.submitAssignment(studentId, new Assignment(assignmentDetails));
            System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        }
    }
}
