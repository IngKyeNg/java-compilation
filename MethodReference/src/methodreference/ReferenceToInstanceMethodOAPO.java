/*
  Reference To An Instance Method Of A Particular Object
 */
package methodreference;

import java.util.*;
import java.util.function.Consumer;

public class ReferenceToInstanceMethodOAPO {
  public static void main(String[] args) {
    List names = new ArrayList();
    names.add("David");
    names.add("Richard");
    names.add("Samuel");
    names.add("Rose");
    names.add("John");

    ReferenceToInstanceMethodOAPO.printNames(names, System.out::println);
  }

  private static void printNames(List list, Consumer c) {
    list.forEach(x -> c.accept(x));
  }
}
