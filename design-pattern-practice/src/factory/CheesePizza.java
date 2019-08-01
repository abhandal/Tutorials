package factory;

public class CheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Cheese pizza is being prepared");
    }

    @Override
    public void bake() {
        System.out.println("Cheese pizza is being baked");

    }

    @Override
    public void cut() {
        System.out.println("Cheese pizza is being cut");

    }

    @Override
    public void box() {
        System.out.println("Cheese pizza is being boxed");

    }
}
