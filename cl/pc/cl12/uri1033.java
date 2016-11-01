import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1033 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int N, B, numberCases = 0, numberCalls;
  static int[] fibonacciNumbers;

  /* DATA STRUCTURES */
  static int[] calculateFibonacci(int limit) {
    int[] sequence = new int[limit];
    sequence[0] = 0;
    sequence[1] = 1;

    for (int i = 2; i < limit; ++i)
      sequence[i] = sequence[i-1] + sequence[i-2];

    return sequence;
  }

  /* AUXILIARY FUNCTIONS */
  static int leo(int n, int call) {
    //System.out.print(n + " ");
    if (n <= 1) return call + 1;
    else return leo(n-1, call) + leo(n-2, call) + 1;
  }

  static int leo(int n) {
    if (n <= 1) return 1;
    else return 2 * fib(n+1) - 1;
  }

  static int fib(int n) {
    return fibonacciNumbers[n];
  }

  /* MAIN FUNCTIONS */
  static boolean readData() throws IOException {
    boolean flag = true;
    String[] line = in.readLine().split(" ");

    try {
      N = Integer.parseInt(line[0]);
      B = Integer.parseInt(line[1]);
    }
    catch (Exception NumberFormatException) {
      N = B = 0;
    }

    if (N == 0 && B == 0) flag = false;
    return flag;
  }

  static void processData() {
    numberCalls = leo(N, 0);
    // numberCalls = leo(N);
  }

  static void writeData() {
    numberCases++;
    System.out.print("Case " + numberCases + ": ");
    System.out.println(N + " " + B + " " +  (numberCalls%B));
  }

  public static void main(String[] args) throws IOException {
    fibonacciNumbers = calculateFibonacci(5000);

    while (readData()) {
      processData();
      writeData();
    }
  }

}
