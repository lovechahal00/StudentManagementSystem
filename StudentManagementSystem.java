import java.util.List;
import java.util.ArrayList;

public class StudentManagementSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("S001", "Lovepreet Singh", 19);
        student1.addCourse("Math");
        student1.addCourse("Physics");
        students.add(student1);

        Student student2 = new Student("S002", "Bhavesh kataria", 19);
        student2.addCourse("Computer Science");
        students.add(student2);

        Student student3 = new Student("S003", "Harmandeep", 21);
        student3.addCourse("History");
        students.add(student3);

        // Display details of all students using streams
        System.out.println("Details of all students:");
        students.forEach(Student::displayDetails);

        // Students enrolled in a specific course ("Computer Science")
        String specificCourse = "Computer Science";
        System.out.println("Students enrolled in course: " + specificCourse);
        students.stream()
                .filter(student -> student.getCourses().contains(specificCourse))
                .forEach(Student::displayDetails);

        // Update age of a specific student ("Bob")
        String studentIDToUpdate = "S002";
        int newAge = 23;
        students.stream()
                .filter(student -> student.getStudentID().equals(studentIDToUpdate))
                .findFirst()
                .ifPresent(student -> student.setAge(newAge));

        // Calculate and display average age of all students
        double averageAge = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Average age of all students: " + averageAge);
    }
}