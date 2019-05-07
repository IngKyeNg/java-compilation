package taxonomy;

public class Manager extends Staff{
    float CarAllowance;
    public Manager(String name, double salary, float carAllowance){
        super(name,salary);
        CarAllowance = carAllowance;
    }
    double getMonthlySalary(){
        return (1.0-EPF_CONTRIBUTION)*Salary + CarAllowance;
    }
}
