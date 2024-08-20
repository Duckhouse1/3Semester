package DIS.TraadOpgave;

import java.io.BufferedReader;
import java.util.Scanner;

public class Traad1 extends Thread{
    MyString myString;

    public Traad1(MyString myString) {
        this.myString = myString;
    }

    @Override
    public void run() {
        while (true){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            myString.setStreng(s);
        }
    }
}
