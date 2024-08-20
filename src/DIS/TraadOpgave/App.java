package DIS.TraadOpgave;

public class App {
    public static void main(String[] args) {
        MyString myString = new MyString();
        Traad1 traad1 = new Traad1(myString);
        Traad2 traad2 = new Traad2(myString);

        traad1.start();
        traad2.start();
    }
}
