import java.io.*;

public class uri1612 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberCases;
  static int[] trunkSize;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      numberCases = Integer.parseInt(in.readLine());
      trunkSize = new int[numberCases];
      for (int i = 0; i < numberCases; ++i)
        trunkSize[i] = Integer.parseInt(in.readLine());
    }
    catch (Exception NumberFormatException) {
      numberCases = 0;
    }

    if (numberCases == 0) flag = false;
    return flag;
  }

  static void processData() {
    for (int i = 0; i < numberCases; ++i) {
      if (trunkSize[i] % 2 == 1) System.out.println(trunkSize[i]/2 + 1);
      else System.out.println(trunkSize[i]/2);
    }
  }

  public static void main(String[] args) throws IOException {
    readData();
    processData();
  }

}
