import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1002 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);
  static final double PI = 3.14159;
  static double radius;
  static double result;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      radius = Double.parseDouble(in.readLine());
    }
    catch (Exception NumberFormatException) {
      radius = 0;
    }

    if (radius == 0) {
      flag = false;
    }

    return flag;
  }

  static void processData() {
    result = PI * radius * radius;
  }

  static void writeData() {
    System.out.printf("A=%.4f\n", result);
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
