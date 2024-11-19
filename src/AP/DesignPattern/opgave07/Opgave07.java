package opgave07;

import AP.DesignPattern.opgave07.models.factories.NYFactory;
import opgave07.models.Pizzeria;

public class Opgave07 {
    public static void main(String[] args) {
        opgave07.models.factories.Factory nyFactory = new NYFactory();
        Pizzeria pizzeria = new Pizzeria(nyFactory);
        System.out.println(pizzeria.orderPizza("cheese"));
    }

}
