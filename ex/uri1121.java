import java.io.*;
import java.util.*;

public class Main {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int[] dimensions;
  static int numberSticks;
  static String[] arena;
  static String instructions;

  static boolean readData() throws IOException {
    boolean flag = true;
    int count = 3;
    dimensions = new int[3];

    try {
      String[] info = in.readLine().split(" ");
      for (int i = 0; i < 3; ++i) {
        dimensions[i] = Integer.parseInt(info[i]);
        if (dimensions[i] == 0) count--;
      }

      arena = new String[dimenstions[1]];
      for (int i = 0; i < dimensions[1]; ++i)
        arena[i] = in.readLine();
      instructions = in.readLine();

    }
    catch (Exception NumberFormatException) {
      count = 0;
    }

    if (count == 0) flag = false;
    return flag;
  }

  static void processData() {

  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      flag = readData();
  }
    }

}
