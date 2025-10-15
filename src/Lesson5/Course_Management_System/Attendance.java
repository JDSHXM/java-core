package Lesson5.Course_Management_System;

import java.util.HashMap;
import java.util.Map;

public class Attendance {
    private Map<Student, Boolean> attendanceList = new HashMap<>();

    public void markAttendance(Student student, boolean present) {
        attendanceList.put(student, present);
    }

    public void showAttendance() {
        System.out.println("\n📒 Журнал посещаемости:");
        for (Map.Entry<Student, Boolean> entry : attendanceList.entrySet()) {
            System.out.println(entry.getKey().getName() + " → " +
                    (entry.getValue() ? "✅ Присутствовал" : "❌ Отсутствовал"));
        }
    }
}
