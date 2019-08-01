package templateMethod;

public class Client {

    public static void run() {
        System.out.println("\n---------------------");
        System.out.println("Template Method pattern\n---------------------");
        TemplateClient();
    }

    private static void TemplateClient() {
        // Create restaurants
        PizzaRecipe pizzaHut = new PizzaHut();
        PizzaRecipe dominos = new Dominos();

        //Make pizza
        pizzaHut.makeCheesePizza();
        dominos.makeCheesePizza();
    }
}
