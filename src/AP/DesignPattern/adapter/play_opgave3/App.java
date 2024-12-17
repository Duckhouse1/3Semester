package AP.DesignPattern.adapter.play_opgave3;

public class App {
    public static void main(String[] args) {
        // Oprettelse af spørgsmål
        Question[] questions = {
                new MultipleChoiceQuestion("Hvad er hovedstaden i Frankrig?", new String[]{"Paris", "Berlin", "London"}, 0),
                new TrueFalseQuestion("Er jorden rund?", true),
                new OpenQuestion("Nichlas er den dårligste","Hvem er den dårligste til tft i klassen?")
        };

        // Oprettelse af spil og afvikling
        Game game = new QuizGame(questions);
        game.playGame();
    }

}

