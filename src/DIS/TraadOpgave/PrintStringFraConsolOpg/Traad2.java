package DIS.TraadOpgave.PrintStringFraConsolOpg;

public class Traad2 extends Thread{
    MyString myString;

    public Traad2(MyString myString) {
        this.myString = myString;
    }

    @Override
    public void run() {
        while (true){
            String s = myString.getStreng();
            System.out.println(s);
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
