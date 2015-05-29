import java.io.*;

public class uri1029 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberCases;
  static int[] input;
  static int calls;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      numberCases = Integer.parseInt(in.readLine());
      input = new int[numberCases];
      for (int i = 0; i < numberCases; ++i) {
        input[i] = Integer.parseInt(in.readLine());
      }
    }
    catch (Exception NumberFormatException) {
      numberCases = 0;
    }

    if (numberCases == 0) flag = false;
    return flag;
  }

  static int fib(int number, int pos) {
    int result;
    calls++;

    if (number <= 1) {
      result = pos + number;
    }
    else {
      result = fib(number - 2, pos) + fib(number - 1, pos);
    }

    // System.out.println("  " + number + " " + result[0]);
    return result;
  }

  static void processData() {
    int output;

    for (int i = 0; i < numberCases; ++i) {
      calls = -1;
      output = fib(input[i], 0);
      writeData(output, input[i]);
    }
  }

  static void writeData(int output, int input) {
    System.out.printf("fib(%d) = %d calls = %d\n", input, calls, output);
  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    readData();
    processData();
  }

}
