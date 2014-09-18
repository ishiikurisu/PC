import java.io.*;

public class pc110103 {
  static Scanner input = new Scanner(System.in);
  static double totalCost;
  static double medium;
  static double[] costs;

  public static boolean readData() {
    int quantity = 0;
    totalCost = 0.0;

    quantity = input.nextInt();
    if (quantity == 0) return false;

    costs = new double[quantity];
    for (int i = 0; i < quantity; ++i) {
      costs[i] = input.nextDouble();
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

  public static final void main(String args[]) {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      flag = readData();
    }
  }
}
