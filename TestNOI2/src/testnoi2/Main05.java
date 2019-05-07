package testnoi2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main05 {

  public static void main(String[] args) {
    Path path = Paths.get("C:", "ikng/tournaments/2009", "BNP.txt");
    for (Path name : path) {
      System.out.println(name);
    }
  }
}
