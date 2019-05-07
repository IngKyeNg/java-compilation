package serializationdeserialization;

import java.io.*;
import java.util.Date;

public class DeserializeDate {

    DeserializeDate() {
        Date dt = null;

        try {
            FileInputStream f = new FileInputStream("date.txt");
            ObjectInputStream s = new ObjectInputStream(f);
            dt = (Date) s.readObject();
            s.close();
            f.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Deserialized Date object from date.txt");
        System.out.println("date: " + dt);

    }
}
