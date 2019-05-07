package methodreference;

import java.util.*;
import java.util.function.Predicate;

public class ReferenceToStaticMethod {
  public static void main(String[] args) {
    List numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16);
    List primeNumbers = ReferenceToStaticMethod.findPrimeNumbers(numbers,
        (number) -> ReferenceToStaticMethod.isPrime((int) number));

    System.out.println("Prime Numbers are " + primeNumbers);
  }

  public static boolean isPrime(int n) {
    if (n<0) n =-n;
    int i;
    for (i = 2; i <=n; i++) {
      if (n % i == 0) break;
    }
    return (i==n);
  }

  public static List findPrimeNumbers(List list, Predicate predicate) {
    List sortedNumbers = new ArrayList();
    list.stream().filter((i) -> (predicate.test(i))).forEach((i) -> {
      sortedNumbers.add(i);
    });
    return sortedNumbers;

  }
}