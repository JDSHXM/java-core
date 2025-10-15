package Lesson5.Course_Management_System;

import java.util.Scanner;

public class CourseManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course course = null;
        int choice;

        do {
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("        🎓 МЕНЮ УПРАВЛЕНИЯ КУРСОМ       ");
            System.out.println("═══════════════════════════════════════");
            System.out.println("│ 1 │ 📘 Создать курс                 │");
            System.out.println("│ 2 │ 👨‍🎓 Добавить студента           │");
            System.out.println("│ 3 │ 🗓️  Отметить посещаемость       │");
            System.out.println("│ 4 │ 📋 Показать всех студентов      │");
            System.out.println("│ 5 │ 📊 Назначить баллы студенту     │");
            System.out.println("│ 6 │ 📒 Показать журнал посещаемости │");
            System.out.println("│ 0 │ 🚪 Выход                        │");
            System.out.println("═══════════════════════════════════════");

            System.out.print("👉 Введите ваш выбор: ");
            choice = sc.nextInt();
            sc.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите название курса: ");
                    String title = sc.nextLine();
                    System.out.print("Имя преподавателя: ");
                    String tName = sc.nextLine();
                    System.out.print("Email преподавателя: ");
                    String tEmail = sc.nextLine();
                    System.out.print("Предмет: ");
                    String subject = sc.nextLine();
                    course = new Course(title, new Teacher(tName, tEmail, subject));
                    System.out.println("✅ Курс успешно создан!");
                    course.showCourseInfo();
                    break;

                case 2:
                    if (course == null) {
                        System.out.println("⚠️ Сначала создайте курс!");
                        break;
                    }
                    System.out.print("Введите имя студента: ");
                    String sName = sc.nextLine();
                    System.out.print("Введите email студента: ");
                    String sEmail = sc.nextLine();
                    course.addStudent(new Student(sName, sEmail));
                    break;

                case 3:
                    if (course == null) {
                        System.out.println("⚠️ Сначала создайте курс!");
                        break;
                    }
                    System.out.print("Введите имя студента: ");
                    String nameForAttendance = sc.nextLine();
                    System.out.print("Был на занятии? (true/false): ");
                    boolean present = sc.nextBoolean();
                    course.markAttendance(nameForAttendance, present);
                    break;

                case 4:
                    if (course != null) course.showStudents();
                    else System.out.println("⚠️ Курс не создан!");
                    break;

                case 5:
                    if (course == null) {
                        System.out.println("⚠️ Сначала создайте курс!");
                        break;
                    }
                    System.out.print("Введите имя студента: ");
                    String nameForScore = sc.nextLine();
                    System.out.print("Введите количество баллов: ");
                    int score = sc.nextInt();
                    course.assignScore(nameForScore, score);
                    break;

                case 6:
                    if (course != null) course.showAttendance();
                    else System.out.println("⚠️ Курс не создан!");
                    break;

                case 0:
                    System.out.println("🚪 Программа завершена. До свидания!");
                    break;

                default:
                    System.out.println("⚠️ Неверный выбор, попробуйте снова.");
            }
        } while (choice != 0);

        sc.close();
    }
}
