import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1310 {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);

  static int numberDays;
  static int dailyCost;
  static int[] dailyReceipt;
  static int finalReceipt;
  static int[][] memo;

  static int max(int a, int b) {
    return (a > b)? a : b;
  }

  static int evaluate(int currentDay, int addedDays, int currentReceipt) {
    int receipt = currentReceipt;

    if (currentDay == numberDays)
      receipt = currentReceipt;
    else if (memo[currentDay][addedDays] >= 0)
      receipt = memo[currentDay][addedDays];
    else for (int day = currentDay; day < numberDays; ++day) {
      receipt = max(currentReceipt, max(
        evaluate(currentDay+1, addedDays, currentReceipt),
        evaluate(currentDay+1, addedDays+1, currentReceipt + dailyReceipt[currentDay] - dailyCost)
      ));
      if (receipt > memo[currentDay][addedDays])
        memo[currentDay][addedDays] = receipt;
    }

    return receipt;
  }

  static void readData() throws IOException, NumberFormatException {
    numberDays = Integer.parseInt(in.readLine());
    dailyCost = Integer.parseInt(in.readLine());
    dailyReceipt = new int[numberDays];
    memo = new int[numberDays][numberDays];

    for (int d = 0; d < numberDays; ++d) {
      dailyReceipt[d] = Integer.parseInt(in.readLine());
      for (int f = 0; f < numberDays; ++f)
        memo[d][f] = -1;
    }
  }

  static void processData() {
    finalReceipt = 0;

    for (int d = numberDays - 1; d >= 0; --d)
      finalReceipt = max(finalReceipt, evaluate(d, 0, 0));
  }

  static void writeData() {
    System.out.println(finalReceipt);
  }

  public static final void main(String[] args) {
    while (true) {
      try {
        readData();
        processData();
        writeData();
      } catch (Exception any) { break; }
    }
  }
}
