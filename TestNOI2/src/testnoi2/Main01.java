package testnoi2;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main01 {
  public static void main(String[] args) {
    Path path1 = Paths.get("C:/ikng/tournaments/2009", "BNP.txt");
    Path path2 = Paths.get("C:", "ikng/tournaments/2009", "BNP.txt");
    Path path3 = Paths.get("C:", "ikng", "tournaments", "2009", "BNP.txt");
    System.out.println(path1);
    System.out.println(path2);
    System.out.println(path3);
  }  
}
