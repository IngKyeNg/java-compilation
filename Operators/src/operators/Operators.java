package operators;

// short circuit
public class Operators {

  static boolean GT0(int v){
    System.out.printf("calling GT0(%d)%n",v);
    return (v>0);
  }
  public static void main(String[] args) {
    boolean result=GT0(5) || GT0(-7); // no short circuit for XOR
    System.out.println(result);
  }  
}
