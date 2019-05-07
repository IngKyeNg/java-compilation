package testnoi2;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main02 {
  public static void main(String[] args) {
    Path noNormalize = Paths.get("C:/ikng/tournaments/./2009/dummy/../BNP.txt");
    Path normalize = Paths.get("C:/ikng/tournaments/./2009/dummy/../BNP.txt").normalize();
    System.out.println(noNormalize);
    System.out.println(normalize);
  }  
}
