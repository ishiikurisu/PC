import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class uri1248 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static Set[] meal;
  static List alm;
  static int numberMeals = 3;
  static boolean cheaterAlert;

  static void readData() throws IOException {
    String food;
    String rice;
    meal = new Set[numberMeals];
    alm = new LinkedList<String>();

    for (int i = 0; i < numberMeals; ++i) {
      food = in.readLine();
      meal[i] = new TreeSet<String>();

      for (int j = 0; j < food.length(); ++j) {
        rice = food.substring(j, j+1);
        meal[i].add(rice);
        if (alm.indexOf(rice) < 0) alm.add(rice);
      }
    }
  }

  static void processData() {
    Collections.sort(alm);
    cheaterAlert = false;
    String rice;

    for (int a = 0; a < alm.size(); ++a) {
      rice = (String) alm.get(a);

      for (int i = 1; i < numberMeals; ++i) {
        if (meal[i].contains(rice) && meal[0].contains(rice)) {
          alm.remove(alm.indexOf(rice));
          meal[0].remove(rice);
        }
        else if (meal[i].contains(rice) && !meal[0].contains(rice)) {
          cheaterAlert = true;
          break;
        }
      }
    }
  }

  static void writeData() {
    if (cheaterAlert == true)
      System.out.print("CHEATER");
    else for (int a = 0; a < alm.size(); ++a)
      System.out.print(alm.get(a));
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());

    for (int c = 0; c < numberCases; c++) {
      readData();
      processData();
      writeData();
    }
  }

}
