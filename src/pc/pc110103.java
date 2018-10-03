package pc;

import java.io.*;

public class pc110103 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);
  static double totalCost;
  static double medium;
  static double[] costs;

  public static boolean readData() throws IOException {
    int quantity = 0;
    totalCost = 0.0;

    String line = in.readLine();
    quantity = Integer.parseInt(line);
    if (quantity == 0) return false;

    costs = new double[quantity];
    for (int i = 0; i < quantity; ++i) {
      line = in.readLine();
      costs[i] = Double.parseDouble(line);
      totalCost += costs[i];
    }
    medium = totalCost/quantity;

    return true;
  }

  public static void processData() {
    double difference = 0;
    double temp;

    for (double value: costs) {
      temp = medium - value;
      if (temp > 0)
        difference += temp;
      else
        difference -= temp;
    }

    System.out.printf("%.2f\n", difference/2);
  }

  public static final void main(String args[]) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      flag = readData();
    }
  }
}
