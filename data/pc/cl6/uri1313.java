import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class uri1313 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);
  static Set<String> combinations;
  static Set<String> portugueseWords;
  static Set<String> spanishWords;
  static int[] sizes = new int[2];

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      String line = in.readLine();
      String[] numbers = line.split(" ");

      for (int i = 0; i < 2; ++i) {
        sizes[i] = Integer.parseInt(numbers[i]);
      }
    }
    catch (Exception NumberFormatException) {
      return false;
    }

    portugueseWords = new HashSet<String>();
    spanishWords = new HashSet<String>();

    for (int i = 0; i < sizes[0]; ++i) {
      String tempString = in.readLine();
      portugueseWords.add(tempString);
    }
    for (int i = 0; i < sizes[1]; ++i) {
      String tempString = in.readLine();
      spanishWords.add(tempString);
    }

    return flag;
  }

  static void processData() {
    String tempString;
    combinations = new HashSet<String>();

    /*this is so ugly*/
    for (String ptWord: portugueseWords) {
      combinations.add(ptWord);
      for (String esWord: spanishWords) {
        for (int i = 0; i < ptWord.length(); ++i) {
          if (i+1 < esWord.length()) {
            tempString = ptWord.substring(0, i+1) + esWord.substring(i+1, esWord.length());
            combinations.add(tempString);
          }
        }
      }
    }
  }

  static void writeData() {
    System.out.println(combinations.size());
  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      writeData();
      flag = readData();
    }
  }
}
