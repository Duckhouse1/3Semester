package AP.DesignPattern.SingleTon;

public class AnvederCounterApp {
    public static void main(String[] args) {
        Counter counter = Counter.getInstance();

        counter.count();
        counter.times2();
        counter.times2();
        System.out.println(counter);
    }
}
