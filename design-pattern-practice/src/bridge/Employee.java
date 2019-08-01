package bridge;

// Employee abstraction
public abstract class Employee {
    //Implementor
    protected Pay pay;

    public Employee(Pay pay) {
        this.pay = pay;
    }

    public abstract void calculateSalary();
}
