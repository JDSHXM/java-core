package Lesson5.Course_Management_System;

public class Teacher extends Person {
    private String subject;

    public Teacher(String name, String email, String subject) {
        super(name, email);
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        System.out.println("👨‍🏫 Преподаватель: " + getName() + " | Предмет: " + subject);
    }
}
