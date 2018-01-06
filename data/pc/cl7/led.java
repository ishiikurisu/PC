import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// http://192.168.12.100:8000/boca

public class led {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static Map<Integer, Integer> ledMap = new HashMap();
  static int numberCases;
  static String[] cases;

  static void createMap() {
    ledMap.put(0, 6);
    ledMap.put(1, 2);
    ledMap.put(2, 5);
    ledMap.put(3, 5);
    ledMap.put(4, 4);
    ledMap.put(5, 5);
    ledMap.put(6, 6);
    ledMap.put(7, 3);
    ledMap.put(8, 7);
    ledMap.put(9, 6);
  }

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      numberCases = Integer.parseInt(in.readLine());
    }
    catch (Exception NumberFormatException) {
      numberCases = 0;
    }

    if (numberCases == 0) {
      flag = false;
    }
    else {
      cases = new String[numberCases];
      for (int i = 0; i < numberCases; ++i) {
        cases[i] = in.readLine();
      }
    }

    return flag;
  }

  static void writeData(int result) {
    System.out.println(result + " leds");
  }

  static void processData() {
    String currentWord;
    int count;

    for (int i = 0; i < numberCases; ++i) {
      currentWord = cases[i];
      count = 0;
      for (int it = 0; it < currentWord.length(); ++it) {
        count += ledMap.get(Integer.parseInt(currentWord.substring(it, it+1)));
      }
      writeData(count);
    }
  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    createMap();
    flag = readData();
    while (flag) {
      processData();
      flag = readData();
    }
  }

}
