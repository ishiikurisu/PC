import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1160 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int[] results;
  static int TC;
  static long P1, P2;
  static double G1, G2;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      TC = Integer.parseInt(in.readLine());
    }
    catch (Exception NumberFormatException) {
      TC = 0;
    }

    if (TC == 0) {
      flag = false;
    }

    return flag;
  }

  static int testData() {
    int count = 0;

    while (count <= 100 && P1 < P2) {
      P1 += P1*G1;
      P2 += P2*G2;
      count++;
    }

    return count;
  }

  static void processData() throws IOException {
    results = new int[TC];
    int count = 0;

    String line;
    String[] values;

    for (int i = 0; i < TC; ++i) {
      do {
        line = in.readLine();
        values = line.split(" ");

        P1 = Integer.parseInt(values[0]);
        P2 = Integer.parseInt(values[1]);
        G1 = Double.parseDouble(values[2])/100;
        G2 = Double.parseDouble(values[3])/100;
      } while (G1 < G2);

      count = testData();
      results[i] = count;
    }
  }

  static void writeData() {
    for (int i = 0; i < TC; ++i) {
      if (results[i] > 100)
        System.out.println("Mais de 1 seculo.");
      else
        System.out.println(results[i] + " anos.");
    }
  }

  public static final void main(String[] args) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      writeData();
      flag = readData();
    }
  }
}
