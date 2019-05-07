package taxonomy;

public class Clerk extends Staff{
    float   OTRate;
    int     OTHours;
    public Clerk(String name, double salary, float otRate){
        super(name,salary);
        OTRate  = otRate;
        OTHours = 0;
    }
    @Override
    double getMonthlySalary(){
        return (1.0-EPF_CONTRIBUTION)*Salary + (OTHours*OTRate);
    }
}
