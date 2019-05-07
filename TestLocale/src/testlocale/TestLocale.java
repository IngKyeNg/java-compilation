package testlocale;

import java.util.Locale;
import java.util.Locale.Builder;
import java.text.*;
import java.util.*;

public class TestLocale {

  public static void main(String[] args) {
    String s = new String();
    Locale[] thaiLocale = {
      new Locale("th"),
      new Locale("th", "TH"),
      new Locale("th", "TH", "TH")
    };

    for (Locale locale : thaiLocale) {
      NumberFormat nf = NumberFormat.getNumberInstance(locale);
      s += locale.toString() + ": ";
      s += nf.format(573.34) + "\n";
    }
    System.out.println(s);
    
    Date date = new Date();
    Builder builder = new Builder();
    Locale locale = builder.build();
    Locale.setDefault(locale);
    System.out.println(DateFormat.getDateTimeInstance(DateFormat.LONG,
      DateFormat.LONG).format(date.getTime()));
    
    builder.setLanguage("zh");
    builder.setScript("Hans");
    builder.setRegion("CN");
    locale = builder.build();
    Locale.setDefault(locale);
    System.out.println(DateFormat.getDateTimeInstance(DateFormat.LONG,
      DateFormat.LONG).format(date.getTime()));
    System.out.println("" + locale.getDisplayLanguage());    
  }
}
