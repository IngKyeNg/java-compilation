package taxonomy;

public class Clerk extends Staff{
    float OTRate;
    int OTHours;
        
    public Clerk(String name, double salary, float otRate) {
        super(name,salary);
        /*Name = name;
        Salary = salary;*/
        OTRate = otRate;
        OTHours = 0;
    }   
    public Clerk() {
        super("",0.0);
       /* Name = "";
        Salary = 0.0;*/
        OTRate = 0.0F;
        OTHours = 0;
    }
    @Override
    double getMonthlySalary() {
        return (1.0-EPF_Contribution) *Salary + (OTRate*OTHours);
    }
}
