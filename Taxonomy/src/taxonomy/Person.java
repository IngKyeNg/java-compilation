package taxonomy;

public class Person extends Object{
    final String Name; 
    private int Age;
    void setAge(int value){
        if (value<1) throw new RuntimeException("Age must be > 0!");
        if (value>128) throw new RuntimeException("Is this human?!");
        Age = value;
    }
    int getAge(){
        return Age;
    }
    public Person(String name){
        super();
        Name = name;
        /*
        Another 100 lines of the common initialization code
        */
    }
    public Person(){
        this("");
    }
}
