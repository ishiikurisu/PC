import java.io.*;
import java.util.*;

public class uri1024 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static List oldPhrases = new LinkedList<String>();
  static List newPhrases = new LinkedList<String>();
  static int numberCases;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      numberCases = Integer.parseInt(in.readLine());
      oldPhrases = new LinkedList();
      newPhrases = new LinkedList();
      for (int i = 0; i < numberCases; ++i) {
        oldPhrases.add(in.readLine());
      }
    }
    catch (Exception NumberFormatException) {
      numberCases = 0;
    }

    if (numberCases == 0) flag = false;

    for (int i = 0; i < numberCases; ++i)
      try {
        System.out.println(oldPhrases.get(i));
      }
      catch (Exc)
    return flag;
  }

  static void processData() {
    char[] phrase;
    int size;

    for (int i = 0; i < numberCases; ++i) {
      System.out.println(oldPhrases.get(i));
    }

    for (int i = 0; i < numberCases; ++i) {
      String oldPhrase = (String) oldPhrases.get(i);
      phrase = oldPhrase.toCharArray();
      size = oldPhrase.length();

      for (int j = 0; j < size; ++j) {
        if (phrase[j] != ' ')
          phrase[j] += 3;
      }

      String newPhrase = new String();
      for (int j = size - 1; j >= 0; --j) {
        newPhrase.concat("" + phrase[j]);
      }
      newPhrases.add(newPhrase);
    }
  }

  public static void writeData() {
    for (int i = 0; i < numberCases; ++i) {
      System.out.println(newPhrases.get(i));
    }
  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      flag = readData();
    }
  }

}
