package AP.DesignPattern.adapter.play_opgave3;

// Konkrete implementeringer af Game
public class QuizGame extends Game {
    private Question[] questions;

    public QuizGame(Question[] questions) {
        this.questions = questions;
    }

    protected void askQuestions() {
        for (Question question : questions) {
            question.askQuestion();
        }
    }
}

