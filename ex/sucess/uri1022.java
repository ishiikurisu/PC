import java.io.*;
import java.util.*;

public class uri1022 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static String[] expressions;
  static String[] results;
  static int numberCases;


  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      numberCases = Integer.parseInt(in.readLine());
      expressions = new String[numberCases];
      results = new String[numberCases];
      for (int n = 0; n < numberCases; ++n) {
        expressions[n] = in.readLine();
      }
    }
    catch (Exception NumberFormatException) {
      numberCases = 0;
    }

    if (numberCases == 0) flag = false;
    return flag;
  }

  static void simplify(int num, int den, int time) {
    results[time] = num + "/" + den;
    int[] zahl = new int[2];
    int limit;

    if (num > den) limit = num;
    else limit = den;

    zahl[0] = num;
    zahl[1] = den;
    for (int i = 1; i < limit; ++i) {
      if (num % i == 0 && den % i == 0) {
        zahl[0] = num / i;
        zahl[1] = den / i;
      }
    }

    results[time] = results[time].concat(" = " + zahl[0] + "/" + zahl[1]);
  }

  static void processData() {
    int[] num = new int[3];
    int[] den = new int[3];
    char op;

    for (int i = 0; i < numberCases; ++i) {
      String expression = expressions[i];
      String[] symbols = expression.split(" ");
      //System.out.println(expression);

      num[0] = Integer.parseInt(symbols[0]);
      den[0] = Integer.parseInt(symbols[2]);
      op = symbols[3].charAt(0);
      num[1] = Integer.parseInt(symbols[4]);
      den[1] = Integer.parseInt(symbols[6]);

      switch (op) {
        case '+':
          num[2] = num[0] * den[1] + num[1] * den[0];
          den[2] = den[0] * den[1];
          break;

        case '-':
          num[2] = num[0] * den[1] - num[1] * den[0];
          den[2] = den[0] * den[1];
          break;

        case '*':
          num[2] = num[0] * num[1];
          den[2] = den[0] * den[1];
          break;

        case '/':
          num[2] = num[0] * den[1];
          den[2] = den[0] * num[1];
          break;
      }

      simplify(num[2], den[2], i);
    }
  }

  static void writeData() {
    for (int i = 0; i < numberCases; ++i) {
      System.out.println(results[i]);
    }
  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      writeData();
      flag = readData();
    }
  }

}
