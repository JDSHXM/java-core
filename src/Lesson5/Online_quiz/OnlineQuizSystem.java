package Lesson5.Online_quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quiz quiz = null;
        int choice;

        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("        🧠 ONLINE QUIZ SYSTEM MENU         ");
            System.out.println("══════════════════════════════════════════");
            System.out.println("│ 1 │ 📘 Создать квиз                     │");
            System.out.println("│ 2 │ ❓ Добавить вопрос                  │");
            System.out.println("│ 3 │ 👥 Добавить команду                │");
            System.out.println("│ 4 │ ▶️  Запустить квиз                 │");
            System.out.println("│ 5 │ 🏁 Показать результаты              │");
            System.out.println("│ 0 │ 🚪 Выход                            │");
            System.out.println("══════════════════════════════════════════");
            System.out.print("👉 Ваш выбор: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название квиза: ");
                    String title = sc.nextLine();
                    quiz = new Quiz(title);
                    System.out.println("✅ Квиз \"" + title + "\" создан!");
                    break;

                case 2:
                    if (quiz == null) {
                        System.out.println("⚠️ Сначала создайте квиз!");
                        break;
                    }
                    System.out.print("Введите текст вопроса: ");
                    String qText = sc.nextLine();
                    List<String> options = new ArrayList<>();
                    for (int i = 1; i <= 4; i++) {
                        System.out.print("Вариант " + i + ": ");
                        options.add(sc.nextLine());
                    }
                    System.out.print("Введите номер правильного ответа (1-4): ");
                    int correct = sc.nextInt();
                    quiz.addQuestion(new Question(qText, options, correct - 1));
                    break;

                case 3:
                    if (quiz == null) {
                        System.out.println("⚠️ Сначала создайте квиз!");
                        break;
                    }
                    System.out.print("Введите название команды: ");
                    String teamName = sc.nextLine();
                    quiz.addTeam(new Team(teamName));
                    break;

                case 4:
                    if (quiz == null) {
                        System.out.println("⚠️ Квиз не создан!");
                        break;
                    }
                    quiz.start();
                    break;

                case 5:
                    if (quiz == null) {
                        System.out.println("⚠️ Квиз не создан!");
                        break;
                    }
                    quiz.showResults();
                    break;

                case 0:
                    System.out.println("🚪 Завершение программы...");
                    break;

                default:
                    System.out.println("⚠️ Неверный выбор!");
            }

        } while (choice != 0);
    }
}
