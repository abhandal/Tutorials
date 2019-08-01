package visitor;

// For every concrete vistable element, we'll need a variable
public interface Visitor {
    void visit(Book book);
    void visit(CD cd);
}
