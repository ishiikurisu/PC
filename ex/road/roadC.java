import java.util.*;
import java.io.*;

public class roadC {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int letters, result;
  static String word;

  static boolean readData() throws IOException {
    String[] line = null;
    boolean flag = true;
    int lol = 0;

    try {
      line = in.readLine().split(" ");
      lol = Integer.parseInt(line[0]);
      letters = Integer.parseInt(line[1]);
    }
    catch (Exception NumberFormatException) {
      letters = 0;
    }

    if (letters == 0 && lol == 0) flag = false;
    else word = in.readLine();
    return flag;
  }

  static void processData() {
    int chances = 0;
    result = word.length();

    for (int i = 0; i < word.length(); ++i)
      if (word.charAt(i) != word.charAt(word.length() - i - 1))
        chances++;
    result -= chances - letters;
    if (word.length() % 2 != 0) result++;
  }

  static void writeData() {
    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
