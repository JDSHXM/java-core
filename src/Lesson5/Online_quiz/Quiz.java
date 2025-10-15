package Lesson5.Online_quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private String title;
    private List<Question> questions = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion(Question q) {
        questions.add(q);
        System.out.println("✅ Вопрос добавлен!");
    }

    public void addTeam(Team t) {
        teams.add(t);
        System.out.println("👥 Команда " + t.getName() + " зарегистрирована!");
    }

    public void start() {
        if (teams.isEmpty() || questions.isEmpty()) {
            System.out.println("⚠️ Добавьте команды и вопросы перед запуском квиза!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\n▶️ Квиз \"" + title + "\" начинается!");
        System.out.println("--------------------------------");

        for (Question q : questions) {
            for (Team t : teams) {
                q.showQuestion();
                System.out.print("Ответ команды " + t.getName() + ": ");
                int ans = sc.nextInt();

                if (q.checkAnswer(ans)) {
                    System.out.println("✅ Верно!");
                    t.addScore(10);
                } else {
                    System.out.println("❌ Неверно!");
                }
            }
        }

        showResults();
    }

    public void showResults() {
        System.out.println("\n🏁 РЕЗУЛЬТАТЫ КВИЗА:");
        System.out.println("----------------------");
        teams.sort((a, b) -> b.getScore() - a.getScore());
        for (Team t : teams) {
            t.displayInfo();
        }
        System.out.println("----------------------");
        System.out.println("🥇 Победитель: " + teams.get(0).getName() + " 🎉");
    }

    public void showTeams() {
        System.out.println("\n👥 Зарегистрированные команды:");
        for (Team t : teams) {
            t.displayInfo();
        }
    }
}