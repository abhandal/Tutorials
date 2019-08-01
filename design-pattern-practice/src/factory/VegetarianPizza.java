package factory;

public class VegetarianPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Vegetarian pizza is being prepared");
    }

    @Override
    public void bake() {
        System.out.println("Vegetarian pizza is being bake");
    }

    @Override
    public void cut() {
        System.out.println("Vegetarian pizza is being cut");
    }

    @Override
    public void box() {
        System.out.println("Vegetarian pizza is being box");
    }
}
