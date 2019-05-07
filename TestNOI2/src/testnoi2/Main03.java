package testnoi2;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main03 {
  public static void main(String[] args) {
    Path path = Paths.get(System.getProperty("user.home"), "downloads", "game.exe");
    System.out.println(path);
  }  
}
