import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1351 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberProducts, numberAisles;
  static int[] products, aisles;
  static double[] prices;
  static double finalCost;

  /* AUXILIARY FUNCTIONS */
  static boolean possibleToAdd(int currentAisle, int productIndex) {
    int currentProduct = products[productIndex];

    while (currentAisle < numberAisles && productIndex < numberProducts) {
      if (aisles[currentAisle] == currentProduct) {
        productIndex++;
        if (productIndex < numberProducts)
          productIndex = products[productIndex];
      }
      currentAisle++;
    }

    if (productIndex == numberProducts)
      return true;
    else
      return false;
  }

  /* MAIN FUNCTIONS */
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

    if (numberProducts == 0 || numberAisles == 0) flag = false;
    return flag;
  }

  static void processData() {
    double[] costs = new double[numberProducts];
    int addedItens = 0;
    int position = 0;
    int product = 0;
    int memory = 0;
    int item;
    finalCost = 0;

    for (item = 0; item < numberProducts; ++item) {
      product = products[item];
      position = memory;

      try {
        while (aisles[position] != product && position < numberAisles)
          position++;
      }
      catch (Exception ArrayIndexOutOfBoundsException) {
        position = numberAisles;
      }

      if (position == numberAisles) break;
      else {
        costs[item] = prices[position];
        memory = position + 1;
        ++addedItens;
        ++position;

        while (position < numberAisles) {
          if (aisles[position] == product && prices[position] < costs[item]) {
            if (!possibleToAdd(position, item)) break;
            else {
              costs[item] = prices[position];
              memory = position + 1;
            }
          }
          ++position;
        }
      }
    }

    if (addedItens == numberProducts)
      for (product = 0; product < numberProducts; ++product)
        finalCost += costs[product];
    else finalCost = -1;
  }

  static void writeData() {
    if (finalCost < 0)
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
