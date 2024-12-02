import java.util.ArrayList;
import java.util.HashMap;

public class AttendanceManager {
    private ArrayList<Student> students;

    public AttendanceManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(int id, String name) {
        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
    }

    public void markAttendanceBatch(HashMap<Integer, String> attendanceBatch) {
        for (Integer id : attendanceBatch.keySet()) {
            String status = attendanceBatch.get(id);
            boolean studentFound = false;
            for (Student student : students) {
                if (student.getId() == id) {
                    student.markAttendance(status);
                    System.out.println(status + " marked for " + student.getName());
                    studentFound = true;
                    break;
                }
            }
            if (!studentFound) {
                System.out.println("Student with ID " + id + " not found!");
            }
        }
    }

    public void viewAttendance() {
        System.out.println("Attendance Report:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
