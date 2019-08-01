package visitor;

import java.util.ArrayList;

/*
Purpose:
The pattern should be used when you have distinct and unrelated operations to perform across a structure of objects.
This avoids adding in code throughout your object structure that is better kept seperate, so it encourages cleaner code.
You may want to run operations against a set of objects with different interfaces.
Visitors are also valuable if you have to perform a number of unrelated operations across the classes.
*/

public class Client {

    public static void run() {
        System.out.println("\n---------------------");
        System.out.println("Visitor pattern\n---------------------");
        VisitorClient();
    }

    private static void VisitorClient() {
        ArrayList<Visitable> items;

        // Create some items
        Book book = new Book(5, 2);
        Book book2 = new Book(10, 1);
        CD cd = new CD(20.75);

        // Add items to items list
        items = new ArrayList<>();
        items.add(book);
        items.add(book2);
        items.add(cd);

        // Create a visitor
        Visitor visitor = new PostageVisitor();

        // Adds visitor to each visitable object
        for (Visitable item : items) {
            item.accept(visitor);
        }

        double postage = ((PostageVisitor) visitor).getTotalPostage();

        System.out.println("Total postage price : $" + postage);
    }
}
