package opgave07.models;

import opgave07.models.pizza.Pizza;

public class Pizzeria {
    opgave07.models.factories.Factory pizzaFactory;

    public Pizzeria(opgave07.models.factories.Factory pizzaFactory) {
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
