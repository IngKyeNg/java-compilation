package taxonomy;

public class Lecturer extends Staff{
    float   Allowance;
    public Lecturer(String name, double salary, float allowance){
        super(name,salary);
        Allowance = allowance;
    }
    @Override
    double getMonthlySalary(){
        return (1.0-EPF_CONTRIBUTION)*Salary + Allowance;
    }
}
