package decorator;

/*
Purpose:
1. Object responsibilities and behaviours should be dynamically modifiable
2. Concrete implementations should be decoupled from responsibilities and behaviours
 */

public class Client {
    public static void run() {
        System.out.println("\n---------------------");
        System.out.println("Decorator pattern\n---------------------");
        DecoratorClient();
    }

    private static void DecoratorClient() {
        // Creates a standard espresso
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // Creates a dark roast with 2x mocha and 1x whip
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
        System.out.println();
    }
}
