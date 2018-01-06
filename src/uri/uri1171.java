import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Collections;

public class uri1171 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    List addedNumbers = new LinkedList<Integer>();
    Map numberRatio = new HashMap<Integer, Integer>();

    for (int c = 0; c < numberCases; c++) {
      int number = Integer.parseInt(in.readLine());
      if (addedNumbers.indexOf(number) < 0) {
        addedNumbers.add(number);
        numberRatio.put(number, 1);
      }
      else {
        int oldRatio = (int) numberRatio.get(number);
        numberRatio.remove(number);
        numberRatio.put(number, ++oldRatio);
      }
    }
    Collections.sort(addedNumbers);
    for (int n = 0; n < addedNumbers.size(); ++n) {
      int number = (int) addedNumbers.get(n);
      System.out.println(number + " aparece " + numberRatio.get(number) + " vez(es)");
    }
  }

}
