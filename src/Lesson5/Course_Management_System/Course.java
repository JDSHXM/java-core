package Lesson5.Course_Management_System;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private Attendance attendance = new Attendance();

    public Course(String title, Teacher teacher) {
        this.title = title;
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("👨‍🎓 " + student.getName() + " добавлен на курс.");
    }

    public void showStudents() {
        System.out.println("\n📋 Студенты курса " + title + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName() + " (" + s.getEmail() + ")");
        }
    }

    public void markAttendance(String studentName, boolean present) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(studentName)) {
                attendance.markAttendance(s, present);
                return;
            }
        }
        System.out.println("⚠️ Студент не найден!");
    }

    public void showAttendance() {
        attendance.showAttendance();
    }

    public void assignScore(String studentName, int score) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(studentName)) {
                s.setScore(score);
                System.out.println("📊 Баллы назначены студенту " + s.getName() + ": " + score);
                return;
            }
        }
        System.out.println("⚠️ Студент не найден!");
    }

    public void showCourseInfo() {
        System.out.println("\n📘 Курс: " + title);
        teacher.displayInfo();
    }
}
