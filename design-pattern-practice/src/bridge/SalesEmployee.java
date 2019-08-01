package bridge;

public class SalesEmployee extends Employee {
    public SalesEmployee(Pay pay) {
        super(pay);
    }

    @Override
    public void calculateSalary() {
        System.out.println("Sales Employee pay is $" + pay.paySalesEmployee());
    }
}
