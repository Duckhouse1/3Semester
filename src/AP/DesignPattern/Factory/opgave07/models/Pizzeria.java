package opgave07.models;

import opgave07.models.pizza.Pizza;
import opgave07.models.factories.Factory;
import opgave07.models.factories.Factory;
public class Pizzeria {
    Factory pizzaFactory;

    public Pizzeria(Factory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = pizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
