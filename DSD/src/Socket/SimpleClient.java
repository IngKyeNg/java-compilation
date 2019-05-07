package Socket;
import java.net.*;
import java.io.*;

public class SimpleClient {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        try {
            Socket s = new Socket("127.0.0.1", 5432);
            System.out.print("Message to Server>");
            String msg = sc.nextLine();
            try (OutputStream os = s.getOutputStream(); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
                bw.write(msg);
            }
            try (InputStream is = s.getInputStream(); InputStreamReader r = new InputStreamReader(is); BufferedReader br = new BufferedReader(r)) {
                System.out.println(br.readLine());
            }
        } catch (ConnectException e) {
            System.out.println("cannot connect");
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        System.out.println("client terminated");
    }
}