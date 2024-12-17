package AP.DesignPattern.Factory.opgave07.models.factories;
import AP.DesignPattern.Factory.opgave07.models.pizza.NYStyleVeggie;
import opgave07.models.pizza.NYStyleCheesePizza;
import opgave07.models.pizza.NYStylePepperoniPizza;
import opgave07.models.pizza.Pizza;
public class NYFactory extends opgave07.models.factories.Factory {


    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else if (type.equals("veggie")) {
            return new NYStyleVeggie();
        } else {
            return null;
        }
    }
}
