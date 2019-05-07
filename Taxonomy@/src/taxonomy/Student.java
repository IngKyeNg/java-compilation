package taxonomy;

public class Student extends Person implements Sortable{
    enum SortCriteria{ByName,ByNameDesc,Bycgpa,BycgpaDesc};
    public boolean Swap(Object rightHandSide, Object sortCriteria){
        Student lhs=this;
        Student rhs=(Student)rightHandSide;
        switch((SortCriteria)sortCriteria){
            case ByName: 
                return lhs.Name.compareTo(rhs.Name)>0;
            case ByNameDesc:
                return lhs.Name.compareTo(rhs.Name)<0;
            case Bycgpa:
                return lhs.CGPA>rhs.CGPA;
            case BycgpaDesc:
                return lhs.CGPA<rhs.CGPA;
        }
        throw new RuntimeException("Missed case:"+sortCriteria);
    }
    
    float CGPA;
    public Student(String name, float cgpa) {
        super(name);
        // Name = name;
        CGPA = cgpa;
    }
    
    public Student() {
        super("");
        // Name = "";
        CGPA = 0.0F;
    }
}
