import java.util.*;
import java.io.*;

public class roadD {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int side, dots;
  static int result;

  static boolean readData() throws IOException {
    String[] line;
    boolean flag = true;

    try {
      line = in.readLine().split(" ");
      side = Integer.parseInt(line[0]);
      dots = Integer.parseInt(line[1]);
    }
    catch (Exception NumberFormatException) {
      side = dots = 0;
    }

    if (side == 0 || dots == 0) flag = false;
    return flag;
  }

  static int fat(int number) {
    int r = 1;
    for (int i = number; i > 1; --i) r *= i;
    return r;
  }

  static void processData() {
    result = fat(side*side)/fat(dots);
  }

  static void writeData() {
    System.out.println(result);
  }

  public static final void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }
}
