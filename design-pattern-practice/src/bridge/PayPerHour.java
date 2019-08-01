package bridge;

public class PayPerHour implements Pay {
    @Override
    public double payTechEmployee() {
        return 20.50;
    }

    @Override
    public double paySalesEmployee() {
        return 15.75;
    }
}
