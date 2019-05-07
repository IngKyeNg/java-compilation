package recursion;

public class Magic3X3 {

  static long TotalPatterns = 0;
  static long TotalAnswers = 0;
  static int[] slots = new int[9];
  static int level = 0;

  static void Solve() {
    if (level == 9) {
      TotalPatterns++;
      if (IsAnswer()) {
        TotalAnswers++;
        ShowAnswer();
      }
    } else {
      for (int n = 1; n <= 9; n++) {
        if (NotInUsed(n)) {
          slots[level] = n;
          level++;
          Solve();//Recursive call
          level--;//Back-Tracking
        }
      }
    }
  }

  static void ShowAnswer() {
    System.out.println("" + slots[0] + slots[1] + slots[2]);
    System.out.println("" + slots[3] + slots[4] + slots[5]);
    System.out.println("" + slots[6] + slots[7] + slots[8]);
    System.out.println();
  }

  static boolean NotInUsed(int n) {
    for (int i = 0; i < level; i++) {
      if (slots[i] == n) {
        return false;
      }
    }
    return true;
  }

  static boolean IsAnswer() {
    int H1 = slots[0] + slots[1] + slots[2];
    int H2 = slots[3] + slots[4] + slots[5];
    int H3 = slots[6] + slots[7] + slots[8];
    int V1 = slots[0] + slots[3] + slots[6];
    int V2 = slots[1] + slots[4] + slots[7];
    int V3 = slots[2] + slots[5] + slots[8];
    int D1 = slots[0] + slots[4] + slots[8];
    int D2 = slots[2] + slots[4] + slots[6];
    return (H1 == H2) && (H1 == H3)
      && (H1 == V1) && (H1 == V2) && (H1 == V3) && (H1 == D1) && (H1 == D2);
  }

  public static void main(String[] args) {
    Solve();
    System.out.println("Total Patterns examined=" + TotalPatterns);
    System.out.println("Total Answers found=" + TotalAnswers);
  }
}
