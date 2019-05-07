package taxonomy;

abstract public class Staff extends Person implements Sortable{
    enum SortCriteria{ByName,ByNameDesc,ByMonthlySalary,ByMonthlySalaryDesc};
    public boolean Swap(Object rightHandSide, Object sortCriteria){
        Staff lhs=this;
        Staff rhs=(Staff)rightHandSide;
        switch((SortCriteria)sortCriteria){
            case ByName: 
                return lhs.Name.compareTo(rhs.Name)>0;
            case ByNameDesc:
                return lhs.Name.compareTo(rhs.Name)<0;
            case ByMonthlySalary:
                return lhs.getMonthlySalary()>rhs.getMonthlySalary();
            case ByMonthlySalaryDesc:
                return lhs.getMonthlySalary()<rhs.getMonthlySalary();
        }
        throw new RuntimeException("Missed case:"+sortCriteria);
    }
    
    double Salary;
    final double EPF_Contribution = 0.11;
    public Staff(String name, double salary){
        super(name);
        // Name = name;
        Salary = salary;
    }    
    abstract double getMonthlySalary();
    @Override
    void setAge(int value) {
        if (value<16) throw new RuntimeException("Too young to be staff!");
        if (value>60) throw new RuntimeException("Let youngster chance laa!");
        super.setAge(value);
    }
}
