package factory;

public class PizzaFactory {

    private Pizza pizza;

    public PizzaFactory() {
        pizza = null;
    }

    public Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            pizza = new CheesePizza();
        }
        else if(type.equals("vege")) {
            pizza = new VegetarianPizza();
        }
        return pizza;
    }
}
