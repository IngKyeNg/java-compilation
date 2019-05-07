package Socket;
import java.net.*;
import java.io.*;

public class SimpleServer {
    public static void main(String[] args) {
        ServerSocket s = null;
        try {
            s = new ServerSocket(5432);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int n = 0;
        System.out.println("server will allow 3 connections");
        while (++n <= 3) {
            try {
                System.out.println("waiting for incoming conn: " + n);
                Socket s1 = s.accept();
                OutputStream os = s1.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                bw.write("hello world: #" + n + "\n");
                bw.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{
                try{
                    s.close();
                }
                catch(Exception ex){}
            }
        }
        System.out.println("shutting down the server");
    }
}