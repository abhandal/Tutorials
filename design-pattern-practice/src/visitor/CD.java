package visitor;

public class CD implements Visitable {
    private double price;

    public CD(double price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }
}
