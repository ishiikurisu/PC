import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class uri1676 {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);
  static int[] memo = new int[100];

  static boolean prime(int number) {
    boolean result = true;
    int test;

    for (test = 2; test <= Math.sqrt(number) && result == true; ++test)
      if (number % test == 0)
        result = false;

    return result;
  }

  static int nthPrimeNumber(int n) {
    int i = 2;
    int cn = 3;

    if (memo[n-1] != 0)
      cn = memo[n-1];
    else while (i != n) {
      do ++cn;
      while (!prime(cn));
      if (memo[i] == 0)
        memo[i] = cn;
      ++i;
    }

    return cn;
  }

  public static final void main(String[] args) {
    memo[0] = 2;
    memo[1] = 3;
    memo[2] = 5;
    int lucky;

    while (true) {
      try {
        lucky = Integer.parseInt(in.readLine());
        if (lucky == 0) break;
        lucky = nthPrimeNumber(lucky--);
        System.out.println(lucky);
      }
      catch (Exception any) {
        break;
      }
    }

    /*
    for (int i = 0; i < 100; ++i)
      System.out.println(i + ". " + memo[i]);
    */
  }
}
