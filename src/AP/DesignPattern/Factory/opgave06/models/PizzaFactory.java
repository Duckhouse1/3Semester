package AP.DesignPattern.Factory.opgave06.models;

import AP.DesignPattern.Factory.opgave06.models.pizzas.VeggiePizza;
import opgave06.models.pizzas.CheesePizza;
import opgave06.models.pizzas.GreekPizza;
import opgave06.models.pizzas.PepperoniPizza;
import opgave06.models.pizzas.Pizza;
public class PizzaFactory {

    public opgave06.models.pizzas.Pizza MakePizza(String type) {
        Pizza pizza;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("greek")) {
            pizza = new GreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        } else {
            return null;
        }
        return pizza;
    }
}
