package opgave07.models.factories;


import opgave07.models.pizza.Pizza;

public abstract class Factory {
    public abstract Pizza createPizza(String type);

}


