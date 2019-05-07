package taxonomy;

public class SalesManager extends Manager{
    float PetrolAllowance;
    double MonthlySales;
    public SalesManager(String name, double salary, float carAllowance, float petrolAlowance) {
        super(name,salary,carAllowance);
        PetrolAllowance = petrolAlowance;
        MonthlySales = 0.0;
    }
    
    @Override
    double getMonthlySalary() {
        return (1.0-EPF_Contribution) *(0.6*Salary) + (0.1*MonthlySales) + CarAllowance + PetrolAllowance;
    }
}
