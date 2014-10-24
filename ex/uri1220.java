import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1220 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static double medium;
  static double[] costs;

  public static boolean readData() throws IOException {
    int quantity = 0;
    medium = 0.0;

    quantity = Integer.parseInt(in.readLine());
    if (quantity == 0) return false;

    costs = new double[quantity];
    for (int i = 0; i < quantity; ++i) {
      costs[i] = Double.parseDouble(in.readLine());
      medium += costs[i];
    }
    medium /= quantity;

    return true;
  }

  public static final void main(String args[]) throws IOException {
    double difference;
    double temp;

    while (readData()) {
      difference = 0;

      for (double value: costs) {
        temp = medium - value;
        if (temp >= 0)
          difference += temp;
        else
          difference -= temp;
      }

      System.out.printf("$%.2f\n", difference/2);
    }
  }
}
