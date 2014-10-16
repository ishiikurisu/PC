import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class uri1136 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int sequenceSize;
  static int numberBalls;
  static int[] balls;

  static boolean readData() throws IOException {
    String[] line;

    line = in.readLine().split(" ");
    sequenceSize = Integer.parseInt(line[0]);
    numberBalls = Integer.parseInt(line[1]);
    if (sequenceSize == 0 || numberBalls == 0) return false;
    else {
      balls = new int[numberBalls];
      line = in .readLine().split(" ");
      for (int b = 0; b < numberBalls; ++b)
        balls[b] = Integer.parseInt(line[b]);
    }

    return true;
  }

  public static final void main(String[] args) throws IOException {
    Set addedDiffs;
    boolean outlet;
    int diff;

    while (readData()) {
      addedDiffs = new TreeSet<Integer>();
      outlet = true;

      for (int i = 0; i < numberBalls; ++i) {
        for (int j = 0; j < numberBalls; ++j) {
          diff = Math.abs(balls[i] - balls[j]);
          addedDiffs.add(diff);
        }
      }

      for (int n = 0; n <= sequenceSize; ++n)
        if (!addedDiffs.contains(n)) outlet = false;

      if (outlet) System.out.println("Y");
      else System.out.println("N");
    }
  }
}
