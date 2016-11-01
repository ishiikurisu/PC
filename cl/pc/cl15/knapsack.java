import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class knapsack {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberItens;
  static int maxWeight;
  static int[] weight;
  static int[] value;
  static int[][] memo;
  static int maxValue;
  final static int UNKNOWN = 0;

  static int max(int a, int b) {
    return (a > b)? a : b;
  }

  static void readData() throws IOException {
    String[] line = in.readLine().split(" ");
    numberItens = Integer.parseInt(line[0]);
    maxWeight = Integer.parseInt(line[1]);

    if (numberItens == 0 || maxWeight == 0)
      throw new IOException();
    else {
      weight = new int[numberItens];
      value = new int[numberItens];

      for (int i = 0; i < numberItens; ++i) {
        line = in.readLine().split(" ");
        weight[i] = Integer.parseInt(line[0]);
        value[i] = Integer.parseInt(line[1]);
      }
    }
  }

  static void processData() {
    memo = new int[numberItens+1][maxWeight+1];
    maxValue = UNKNOWN;
    int i, j;

    /* init */
    for (i = 0; i <= numberItens; ++i)
      for (j = 0; j <= maxWeight; ++j)
        memo[i][j] = UNKNOWN;

    /* tests */
    for (i = numberItens-1; i >= 0; --i) {
      for (j = maxWeight; j >= 0; --j) {
        if (j - weight[i] >= 0)
          memo[i][j] = max(memo[i+1][j], memo[i+1][j - weight[i]] + value[i]);
        else
          memo[i][j] = max(memo[i+1][j], UNKNOWN);

        if (memo[i][j] > maxValue)
          maxValue = memo[i][j];
      }
    }
  }

  static void writeData() {
    /*
    for (int i = 0; i <= numberItens; ++i) {
      for (int j = 0; j <= maxWeight; ++j) {
        System.out.print(memo[i][j] + "\t");
      }
      System.out.println();
    }
    */
    System.out.println(maxValue);
  }

  public static void main(String[] args) {
    while (true) {
      try {
        readData();
        processData();
        writeData();
      }
      catch (Exception any) {
        break;
      }
    }
  }

}
