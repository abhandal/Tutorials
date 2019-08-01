package templateMethod;

public abstract class PizzaRecipe {
    // Have a final method that cannot be changed
    public final void makeCheesePizza() {
        System.out.println("1. Make dough");
        addSauce();
        System.out.println("3. Add Cheese");
        System.out.println("4. Cook Pizza\n");
    }

    // Have a method that is defined by the restaurants that use the recipe
    protected abstract void addSauce();
}
