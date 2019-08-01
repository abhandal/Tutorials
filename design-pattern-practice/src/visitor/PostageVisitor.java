package visitor;

// Goes through each product and gets the required information to calculate totalPostage
public class PostageVisitor implements Visitor {
    private double totalPostage;


    // Assume free postage for books > $10.00
    // Collects information about book by VISITING it
    @Override
    public void visit(Book book) {
        if(book.getPrice() < 10) {
            totalPostage += book.getWeight()*2;
        }
    }

    @Override
    public void visit(CD cd) {
        totalPostage+=cd.getPrice();
    }

    public double getTotalPostage() {
        return totalPostage;
    }
}
