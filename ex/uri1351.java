import java.util.*;
import java.io.*;

public class uri1351 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberProducts, numberAisles;
  static int[] products, aisles;
  static double[] prices;
  static double finalCost;

  static boolean readData() throws IOException {
    boolean flag = true;
    String[] line;

    try {
      line = in.readLine().split(" ");
      numberProducts = Integer.parseInt(line[0]);
      numberAisles = Integer.parseInt(line[1]);

      if (numberProducts != 0 && numberAisles != 0) {
        products = new int[numberProducts];
        aisles = new int[numberAisles];
        prices = new double[numberAisles];

        line = in.readLine().split(" ");
        for (int p = 0; p < numberProducts; ++p)
          products[p] = Integer.parseInt(line[p]);
        for (int p = 0; p < numberAisles; ++p) {
          line = in.readLine().split(" ");
          aisles[p] = Integer.parseInt(line[0]);
          prices[p] = Double.parseDouble(line[1]);
        }
      }
    }
    catch (Exception NumberFormatException) {
      numberProducts = numberAisles = 0;
    }

    if (numberProducts ==  0 && numberAisles == 0) flag = false;
    return flag;
  }

  static void processData() {
    finalCost = 0.0;
    int product, aisle, aisleMemory = 0, addedItens = 0;
    double[] costs = new double[numberProducts];

    for (int i = 0; i < numberProducts; ++i) {
      product = products[i];
      aisle = aisleMemory;

      // first search
      while (aisle < numberAisles && aisles[aisle] != product)
        ++aisle;
      if (aisles[aisle] == product) {
        costs[i] = prices[aisle];
        aisleMemory = aisle;
        addedItens++;
      }

      // search until end
      while (aisle < numberAisles) {

        // if it is a better option
        if (aisles[aisle] == product && prices[aisle] < costs[i]) {
          // and if not impossible to add it
          boolean flag = false;
          int p = i, a = aisle;
          while (a < numberAisles && p < numberProducts) {
            if (aisles[a] == products[p])
            { p++; }
            a++;
          }
          if (p == numberProducts) flag = true;

          // then add this item
          if (flag == true) {
            costs[i] = prices[aisle];
            aisleMemory = aisle;
          }
        }
        ++aisle;
      }
    }

    if (addedItens == numberProducts)
      for (product = 0; product < numberProducts; ++product)
        finalCost += costs[product];
    else finalCost = 0;
  }

  static void writeData() {
    if (finalCost == 0)
      System.out.println("Impossible");
    else
      System.out.printf("%.2f\n", finalCost);
  }

  public static final void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }
}
