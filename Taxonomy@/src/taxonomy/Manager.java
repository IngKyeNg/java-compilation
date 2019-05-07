package taxonomy;

public class Manager extends Staff {
    float CarAllowance;
    public Manager(String name, double salary, float carAllowance) {
        super(name, salary);
        CarAllowance = carAllowance;
    }
    // if dont want to override, put a final in front of the method in sub class
    double getMonthlySalary() {
        return (1.0-EPF_Contribution) *Salary + CarAllowance;
    }
}
