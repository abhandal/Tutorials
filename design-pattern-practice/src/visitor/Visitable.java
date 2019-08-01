package visitor;

public interface Visitable {
    // Asks the visitor to make the necessary calculations
    void accept(Visitor visitor);
}
