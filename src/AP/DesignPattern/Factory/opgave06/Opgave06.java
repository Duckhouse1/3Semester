package opgave06;

import AP.DesignPattern.Factory.opgave06.models.PizzaFactory;
import opgave06.models.Pizzeria;

public class Opgave06 {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        Pizzeria pizzeria = new Pizzeria(pizzaFactory);
        System.out.println(pizzeria.orderPizza("pepperoni"));
    }

}
