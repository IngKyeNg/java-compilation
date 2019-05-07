package serializationdeserialization;

import java.io.*;
import java.util.Date;

public class SerializeDate {

    SerializeDate() {
        Date dt = new Date();
        try {

            FileOutputStream output = new FileOutputStream("date.txt");
            ObjectOutputStream obj = new ObjectOutputStream(output);
            obj.writeObject(dt);
            obj.close();
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
