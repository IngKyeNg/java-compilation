package array1d;

public class Array1D {

  public static void main(String[] args) {
    int[] data1 = new int[3];
    int[] data2 = new int[]{2,5,7};
    int[] data3 = {1,6,8,9};
    int[] data4 = data2;
    String[] days={"MON","TUE","WED","THU","FRI","SAT","SUN"};
    
    System.out.print("data1:"); ShowArrayItems(data1);   
    System.out.print("data2:"); ShowArrayItems(data2);   
    System.out.print("data3:"); ShowArrayItems(data3);   
    System.out.print("data4:"); ShowArrayItems2(data4);   
    
    data1 = new int[5];
    data3 = new int[]{2,4};
    
    //data2[1] = 8;
    //System.out.println("data4[1]="+data4[1]);
  }
  static void ShowArrayItems(int[] items){
    for(int i=0;i<items.length;i++) System.out.print("\t"+items[i]);
    System.out.println();
  }
  static void ShowArrayItems2(int[] items){
    for(int item:items) System.out.print("\t"+item);
    System.out.println();
  }
}
