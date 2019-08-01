package templateMethod;

public class PizzaHut extends PizzaRecipe {
    @Override
    protected void addSauce() {
        System.out.println("2. Add special Pizza Hut Sauce");
    }
}
