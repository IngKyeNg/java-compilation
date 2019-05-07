package testsimpledatetimeformat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main{
    public static void main(String args[]){
      // Create Date object.
      Date date = new Date();

      //Specify the desired date format
      String DATE_FORMAT = "yyyyMMdd'T'HH':'mm':'ss";

      //Create object of SimpleDateFormat & pass the desired format.
      SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

      //Use format method of SimpleDateFormat class to format the date.
      System.out.println("Today is " + sdf.format(date) );
    }
}
