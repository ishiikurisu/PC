import java.util.*;
import java.io.*;

public class uri1608 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int money, numberIngredients, numberCakes, bestOption;
  static int[] priceIngredients;
  static List<Map> recipes;

  static void readData() throws IOException {
    recipes = new LinkedList();
    String[] line;
    Map recipe;

    try {
      line = in.readLine().split(" ");
      money = Integer.parseInt(line[0]);
      numberIngredients = Integer.parseInt(line[1]);
      numberCakes = Integer.parseInt(line[2]);

      priceIngredients = new int[numberIngredients];
      line = in.readLine().split(" ");
      for (int i = 0; i < numberIngredients; ++i)
      { priceIngredients[i] = Integer.parseInt(line[i]); }

      for (int b = 0; b < numberCakes; ++b) {
        line = in.readLine().split(" ");
        int quantity = Integer.parseInt(line[0]);
        recipe = new HashMap<Integer, Integer>();

        for (int k = 1; k <= quantity; k++) // recipe.put(what, howMany);
        { recipe.put(Integer.parseInt(line[2*k-1]), Integer.parseInt(line[2*k])); }
        recipes.add(recipe);
      }


    }
    catch (Exception NumberFormatException) {}
  }

  static void processData() {
    int[] cakePrice = new int[numberCakes];
    int price, cake, ingredient, preferredCake = 0;
    Map recipe;

    for (cake = 0; cake < numberCakes; ++cake) {
      price = 0;
      recipe = recipes.get(cake);

      // determine each cake price
      for (ingredient = 0; ingredient < numberIngredients; ++ingredient) {
        //System.out.println(recipe.get(ingredient));
        price += (recipe.containsKey(ingredient))?
          (int) recipe.get(ingredient) * priceIngredients[ingredient]: 0;
      }

      // decide maximum number of cakes
      //System.out.println("  " + cake + ": " + price);
      cakePrice[cake] = price;
      if (price < cakePrice[preferredCake]) preferredCake = cake;
    }

    bestOption = preferredCake;
    numberCakes = money / cakePrice[bestOption];
  }

  static void writeData() {
    System.out.println(numberCakes);
  }

  public static void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());

    for (int n = 0; n < numberCases; ++n) {
      readData();
      processData();
      writeData();
    }
  }

}
