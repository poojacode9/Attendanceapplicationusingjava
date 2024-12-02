import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Attendance Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Attendance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    manager.addStudent(id, name);
                    break;
                case 2:
                    System.out.println("Enter attendance in the format (ID=Status,ID=Status,...): ");
                    String input = scanner.nextLine();
                    HashMap<Integer, String> attendanceBatch = new HashMap<>();
                    String[] entries = input.split(",");
                    for (String entry : entries) {
                        String[] parts = entry.split("=");
                        try {
                            int studentId = Integer.parseInt(parts[0].trim());
                            String status = parts[1].trim();
                            attendanceBatch.put(studentId, status);
                        } catch (Exception e) {
                            System.out.println("Invalid format: " + entry);
                        }
                    }
                    manager.markAttendanceBatch(attendanceBatch);
                    break;
                case 3:
                    manager.viewAttendance();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
