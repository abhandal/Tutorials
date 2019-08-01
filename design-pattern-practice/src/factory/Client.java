package factory;

public class Client {
    public static void run() {
        System.out.println("\n---------------------");
        System.out.println("Factory pattern\n---------------------");
        FactoryClient();
    }

    private static void FactoryClient() {
        PizzaFactory pizzaFactory = new PizzaFactory();

        Pizza cheesePizza = pizzaFactory.createPizza("cheese");
        cheesePizza.prepare();
        cheesePizza.cut();
        cheesePizza.bake();
        cheesePizza.box();

        Pizza vegePizza = pizzaFactory.createPizza("vege");
        vegePizza.prepare();
        vegePizza.cut();
        vegePizza.bake();
        vegePizza.box();
    }
}
