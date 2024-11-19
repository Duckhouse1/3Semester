package AP.DesignPattern.opgave06.models;

import AP.DesignPattern.opgave06.models.pizzas.VeggiePizza;

public class PizzaFactory {

    public opgave06.models.pizzas.Pizza MakePizza(String type) {
        opgave06.models.pizzas.Pizza pizza;
        if (type.equals("cheese")) {
            pizza = new opgave06.models.pizzas.CheesePizza();
        } else if (type.equals("greek")) {
            pizza = new opgave06.models.pizzas.GreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new opgave06.models.pizzas.PepperoniPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        } else {
            return null;
        }
        return pizza;
    }
}
