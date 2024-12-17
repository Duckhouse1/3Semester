package opgave06.models;

import AP.DesignPattern.Factory.opgave06.models.PizzaFactory;
import opgave06.models.pizzas.Pizza;

public class Pizzeria {
    private PizzaFactory pizzaFactory;

    public Pizzeria(PizzaFactory pizzaFactory){
        this.pizzaFactory = pizzaFactory;
    }
    public Pizza orderPizza(String type) {
        Pizza pizza = pizzaFactory.MakePizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
