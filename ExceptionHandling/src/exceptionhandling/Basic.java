package exceptionhandling;

public class Basic {
    static void OpX(){
        System.out.println("OpX:----1");
        OpY();
        System.out.println("OpX:----2");
    }
    static void OpY(){
        System.out.println("OpY:----1");
        OpZ();
        System.out.println("OpY:----2");
    }
    static void OpZ(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("OpZ:----1");
        System.out.print("n>>");
        String s = sc.next();
        int n = Integer.parseInt(s);
        System.out.println("OpZ:----2");
    }
    public static void main(String[] args){
        OpX();
    }
}
