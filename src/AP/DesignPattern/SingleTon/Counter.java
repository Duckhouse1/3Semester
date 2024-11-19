package AP.DesignPattern.SingleTon;

public class Counter {
    private static Counter uniqueInstance;
    private int value;
    private Counter (){

    }
    public static Counter getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Counter();
            uniqueInstance.value = 0;
        }
        return uniqueInstance;
    }
    public void count(){
        value++;
    }
    public void times2(){
        value *= 2;
    }
    public void zero(){
        value = 0;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "uniqueInstance: " + value;
    }
}
