package taxonomy;

abstract public class Staff extends Person implements Sortable{
    enum SortCriteria{ByName,ByNameDesc,ByMonthlySalary,ByMonthlySalaryDesc};
    @Override
    public boolean Swap(Object rightHandSide,Object sortCriteria){
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
    final double EPF_CONTRIBUTION=0.13;
    public Staff(String name, double salary){
        super(name);
        Salary = salary;
    }
    @Override
    void setAge(int value){
        if (value<16) throw new RuntimeException("Too young to be Staff!");
        if (value>60) throw new RuntimeException("Give chance to the young one-lah!");
        super.setAge(value);
    }
    abstract double getMonthlySalary();
}
