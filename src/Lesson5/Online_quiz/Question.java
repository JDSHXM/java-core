package Lesson5.Online_quiz;

import java.util.List;

public class Question {
    private String text;
    private List<String> options;
    private int correctIndex;

    public Question(String text, List<String> options, int correctIndex) {
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
    }

    public void showQuestion() {
        System.out.println("\n❓ " + text);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(int answer) {
        return (answer - 1) == correctIndex;
    }
}
