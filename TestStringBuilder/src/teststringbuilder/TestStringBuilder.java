package teststringbuilder;

class X{
    String Name;
    public X(String name) {
        Name = name;
    }
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println(Name);
        new X(Name + "*"); //Immediately become garbage
    }
}

public class TestStringBuilder {
    
    public static void main(String[] args) {
        new X("*"); //Garbage
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<5000;i++){
            sb.append(i);
        }
        String s = sb.toString();
        System.out.println(s.length());
    }
    
}
