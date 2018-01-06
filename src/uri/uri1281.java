import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class uri1281 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static double totalCost;
  static Map prices;
  static Map quantities;
  static int numberAvailable;
  static int shoppingListLength;
  static List shoppingList;

  static void readData() throws IOException {
    String[] line;
    String product;
    double price;
    int quantity;
    prices = new HashMap<String, Double>();
    quantities = new HashMap<String, Integer>();
    shoppingList = new LinkedList<String>();

    numberAvailable = Integer.parseInt(in.readLine());
    for (int p = 0; p < numberAvailable; ++p) {
      line = in.readLine().split(" ");
      product = line[0];
      price = Double.parseDouble(line[1]);
      prices.put(product, price);
    }

    shoppingListLength = Integer.parseInt(in.readLine());
    for (int i = 0; i < shoppingListLength; ++i) {
      line = in.readLine().split(" ");
      product = line[0];
      quantity = Integer.parseInt(line[1]);
      quantities.put(product, quantity);
      shoppingList.add(product);
    }
  }

  static void processData() {
    String product;
    double price;
    int quantity;
    totalCost = 0.0;

    for (int it = 0; it < shoppingListLength; ++it) {
      product = (String) shoppingList.get(it);
      price = (double) prices.get(product);
      quantity = (int) quantities.get(product);
      totalCost += price * quantity;
    }
  }

  static void writeData() {
    System.out.printf("R$ %.2f\n", totalCost);
  }

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());

    for (int c = 0; c < numberCases; c++) {
      readData();
      processData();
      writeData();
    }
  }
}
