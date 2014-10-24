import java.util.*;
import java.io.*;

public class uri1598 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberNodes;
  static int numberKnots;
  static int[][] knots;
  static double value;
  // static List nodes;
  // static Map knots;

  static boolean readData() throws IOException {
    String[] line;

    try {
      line = in.readLine().split(" ");
      numberNodes = Integer.parseInt(line[0]);
      numberKnots = Integer.parseInt(line[1]);
      knots = new int[numberNodes][numberNodes];

      for (int k = 0; k < numberKnots; ++k) {
        line = in.readLine().split(" ");
        int u = Integer.parseInt(line[0]);
        int v = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        knots[u][v] = c;
        knots[v][u] = c;
      }
    } catch (Exception NumberFormatException) {
      numberNodes = numberKnots = 0;
    }

    if (numberNodes == 0 || numberKnots == 0)
      return false;
    else
      return true;
  }

  static void processData() {
    List circuit;
    BitSet flag;
    value = -1;

    for (int n = 0; n < numberNodes; ++n) {
      circuit = new ArrayList<Integer>();
      flag = new BitSet(numberNodes);

      for (int m = 0; m < numberNodes; ++m) {
        if (knots[n][m] > 0) {
          circuit.add(m);
          flag.set(m, true);
        }
      }

      for (Integer node: circuit) {
        if (flag.get(node) == false) {
          flag.set(node, true);
          circuit.add(node);
        }
      }

      if (flag.get(n) == true) {

      }
    }
  }

  static void writeData() {
    if (value < 0)
      System.out.println(-1);
    else
      System.out.println("%.3f\n", value);
  }

  public static final void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }
}
