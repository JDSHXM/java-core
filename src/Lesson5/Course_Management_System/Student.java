package Lesson5.Course_Management_System;

public class Student extends Person {
    private int score;

    public Student(String name, String email) {
        super(name, email);
        this.score = 0;
    }

    public void setScore(int score) { this.score = score; }
    public int getScore() { return score; }

    @Override
    public void displayInfo() {
        System.out.println("👨‍🎓 Студент: " + getName() + " | Баллы: " + score);
    }
}
