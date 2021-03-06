package testnoi2;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main04 {
  public static void main(String[] args) {
    Path path = Paths.get("C:", "ikng/tournaments/2009", "BNP.txt");    
    System.out.println(path);
    System.out.println("Root of this path: " + path.getRoot());
    System.out.println("Parent: " + path.getParent());
    System.out.println("Number of name elements in path: " + path.getNameCount());
    for (int i = 0; i < path.getNameCount(); i++) {
      System.out.println("Name element " + i + " is: " + path.getName(i));
    } 
    System.out.println("Subpath (0,3): " + path.subpath(0, 3));
  }  
}
