package opgave07;
import opgave07.models.factories.Factory;
import AP.DesignPattern.Factory.opgave07.models.factories.NYFactory;
import opgave07.models.Pizzeria;

public class Opgave07 {
    public static void main(String[] args) {
        Factory nyFactory = new NYFactory();
        Pizzeria pizzeria = new Pizzeria(nyFactory);
        System.out.println(pizzeria.orderPizza("cheese"));
    }

}
