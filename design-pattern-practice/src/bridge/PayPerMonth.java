package bridge;

public class PayPerMonth implements Pay {
    @Override
    public double payTechEmployee() {
        return 600;
    }

    @Override
    public double paySalesEmployee() {
        return 300;
    }
}
