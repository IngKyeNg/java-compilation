package args;

import java.util.Properties;

public class Main {
  public static void main(String[] args) {
    int sum = 0;
    
    System.out.println("args.length:" + args.length);
    for (String s : args) {
      sum += Integer.parseInt(s);
    }
    for (int i = 0; i < args.length; i++) {
      System.out.println("args[" + i + "] is " + args[i]);
    }
    System.out.println("sum: " + sum);

    //place the following to the VM option
    //under the property of the project
    //  -DmyProp=theValue
    Properties props = System.getProperties();
    props.list(System.out);

  }
}
