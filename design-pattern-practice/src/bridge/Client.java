package bridge;

/*
Purpose
The Bridge pattern should be used when both the class as well as what it does vary often.
The bridge pattern can also be thought of as two layers of abstraction. When the abstractions and
implementations should not be bound at compile time, and should be independently extensible the pattern should be used.
 */
public class Client {

    public static void run() {
        System.out.println("\n---------------------");
        System.out.println("Bridge pattern\n---------------------");
        BridgeClient();
    }

    private static void BridgeClient() {
        Pay payHour = new PayPerHour();
        Pay payMonth = new PayPerMonth();

        Employee salesEmployee = new SalesEmployee(payMonth);
        Employee techEmployee = new TechEmployee(payHour);

        salesEmployee.calculateSalary();
        techEmployee.calculateSalary();
    }
}
