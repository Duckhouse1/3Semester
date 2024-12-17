package AP.DesignPattern.adapter.play_opgave3;

import java.util.Scanner;

public class OpenQuestion extends Question{
    private String korrektSvar;
    private String question;

    public OpenQuestion(String korrektSvar, String question) {
        this.korrektSvar = korrektSvar;
        this.question = question;
    }

    @Override
    protected void displayQuestion() {
        System.out.println("Open Question: " + question);
    }

    @Override
    protected String getUserAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Dit svar: ");
        String answer = scan.nextLine();
        return answer;
    }

    @Override
    protected boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(korrektSvar);
    }
}
