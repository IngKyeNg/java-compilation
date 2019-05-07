package taxonomy;

public class Student extends Person {
    float CGPA;
    public Student(String name, float cgpa){
        super(name);
        CGPA = cgpa;
    }
    public Student(){
        super("");
        CGPA = 0.0F;
    }
}
