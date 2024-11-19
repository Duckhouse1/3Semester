package AP.DesignPattern.opgave07.models.factories;

import AP.DesignPattern.opgave07.models.pizza.ChicagoStyleVeggie;
import opgave07.models.pizza.ChicagoStyleCheesePizza;
import opgave07.models.pizza.ChicagoStylePepperoniPizza;
import opgave07.models.pizza.Pizza;

public class ChicagoFactory extends opgave07.models.factories.Factory {
    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else if (type.equals("veggie")) {
            return new ChicagoStyleVeggie();
        } else {
            return null;
        }
    }
}
