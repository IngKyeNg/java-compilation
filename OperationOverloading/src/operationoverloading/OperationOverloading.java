package operationoverloading;

public class OperationOverloading {
  static int Sum(int x, int y, int z){
    return x + y + z;
  }
  static double Sum(double x, double y){
    return x + y;
  }
  static int Sum(int x, int y){
    return x + y;
  }
  static double Sum(double... items){
    double sum=0;
    for(double item:items) sum += item;
    return sum;
  }
  
  public static void main(String[] args) {
    System.out.println("Sum(3,5)="+Sum(3,5));
    System.out.println("Sum(3,5,2)="+Sum(3,5,2));
    System.out.println("Sum(3.3,5.5)="+Sum(3.3,5.5));
    System.out.println("Sum(1,2,3,4,5)="+Sum(1,2,3,4,5));
    System.out.println("Sum(1.1,2,3,4,5.5,6.6,7,8)="+Sum(1.1,2,3,4,5.5,6.6,7,8));
  }  
  
  
  
  
  
  static int Min(int x, int y){
    return (x<y)?x:y;
  }
  static double Min(double x, double y){
    return (x<y)?x:y;
  }
  static int Min(int x, int y, int z){
    return Min(Min(x,y),Min(y,z));
  }
  static double Min(double min,double... items){
    for(double item:items){
      if(min>item) min = item;
    }
    return min;
  } 

}
