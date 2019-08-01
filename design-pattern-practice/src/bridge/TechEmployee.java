package bridge;

public class TechEmployee extends Employee{

    public TechEmployee(Pay pay) {
        super(pay);
    }

    @Override
    public void calculateSalary() {
        System.out.println("Tech Employee pay is $" +pay.payTechEmployee());
    }
}
