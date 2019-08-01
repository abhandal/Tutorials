package templateMethod;

public class Dominos extends PizzaRecipe {
    @Override
    protected void addSauce() {
        System.out.println("2. Add Dominos Special Sauce");
    }
}
