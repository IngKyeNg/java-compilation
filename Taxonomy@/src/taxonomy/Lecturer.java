package taxonomy;

public class Lecturer extends Staff{
    float Allowance;
    
    public Lecturer(String name, double Salary, float allowance) {
        super(name,Salary); // super class constructor
        /*
        Name = name;
        this.Salary = Salary; // this is used because of redundancy/same name of variable
        */
        Allowance = allowance;
    }
    @Override
    double getMonthlySalary() {
        return (1.0-EPF_Contribution) *Salary + Allowance;
    }
}
