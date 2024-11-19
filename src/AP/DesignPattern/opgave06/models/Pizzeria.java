package opgave06.models;

import AP.DesignPattern.opgave06.models.PizzaFactory;
import AP.DesignPattern.opgave06.models.pizzas.VeggiePizza;
import opgave06.models.pizzas.CheesePizza;
import opgave06.models.pizzas.GreekPizza;
import opgave06.models.pizzas.PepperoniPizza;
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
