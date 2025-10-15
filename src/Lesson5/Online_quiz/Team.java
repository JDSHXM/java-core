package Lesson5.Online_quiz;

public class Team extends User {
    private int score;

    public Team(String name) {
        super(name);
        this.score = 0;
    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void displayInfo() {
        System.out.println("👥 Команда: " + getName() + " | Очки: " + score);
    }
}
