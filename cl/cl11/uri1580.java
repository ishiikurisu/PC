import java.util.*;
import java.io.*;

class PascalTriangle {
  private long[][] triangle;

  public PascalTriangle(int size) {
    this.triangle = new long[size][size];
    int i, j;

    for (i = 0; i < size; ++i)
      triangle[i][0] = triangle[i][i] = 1;

    for (j = 1; j < size; ++j) {
      for (i = 1; i < j; ++i) {
        triangle[i][j] = triangle[i][j-1] + triangle[i-1][j-1];
        System.out.print(triangle[i][j] + "\t");
      }
      System.out.println(triangle[i][j]);
    }
  }

  public long get(int x, int y) {
    return this.triangle[x][y];
  }
}


public class uri1580 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static PascalTriangle pascal = new PascalTriangle(50);
  static String inlet;
  static long outlet;

  /* AUXILIARY FUNCTIONS */
  static long fat(int n) {
    if (n <= 1) return 1;

    int i = 2;
    long result = 1;

    while (i <= n) {
      result *= i; i++;
    }

    return result;
  }

  static long pn(int n, int k) {
    //return fat(n) / fat(n-k) / fat(k);
    return pascal.get(n, k);
  }

  /* MAIN FUNCTIONS */
  static boolean readData() throws IOException {
    boolean flag = true;
    try {
      inlet = in.readLine();
    }
    catch (Exception NumberFormatException) {
      flag = false;
    }

    return flag;
  }

  static void processData() {
    Set letters = new HashSet<String>();
    String letter;

    /* identify letters */
    for (int i = 0; i < inlet.length(); ++i) {
      letter = inlet.substring(i, i+1);
      if (!letters.contains(letter))
        letters.add(letter);
    }

    /* combinate */
    outlet = pn(inlet.length(), letters.size());
  }

  static void writeData() {
    System.out.println(outlet);
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
