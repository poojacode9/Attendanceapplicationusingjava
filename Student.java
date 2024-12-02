import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private ArrayList<String> attendanceLog;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.attendanceLog = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void markAttendance(String status) {
        attendanceLog.add(status);
    }

    public ArrayList<String> getAttendanceLog() {
        return attendanceLog;
    }

    @Override
    public String toString() {
        String log = attendanceLog.isEmpty() ? "No attendance recorded" : attendanceLog.toString();
        return "ID: " + id + ", Name: " + name + ", Attendance: " + log;
    }
}
