import java.util.*;

public class uva10252 {
  static Scanner input = new Scanner(System.in);
  static String[] words;

  static boolean readData() {
    words = new String[2];

    try {
      words[0] = input.next();
      if (words[0].isEmpty()) return false;
      words[1] = input.next();
      if (words[1].isEmpty()) return false;
    }
    catch (Exception NoSuchElementException) {
      return false;
    }

    /*
    System.out.println(words[0]);
    System.out.println(words[1]);
    */

    return true;
  }

  static String findOutWord() {
    String result = new String("");
    char letter;

    for (int i = 0; i < words[0].length(); ++i) {
      letter = words[0].charAt(i);
      for (int j = 0; j < words[1].length(); ++j) {
        if (letter == words[1].charAt(j) && result.indexOf(letter) == -1) {
          result = result + letter;
          break;
        }
      }
    }

    return result;
  }

  private static int partition(char[] a, int p, int r) {
    int x = a[r];
    int i = p-1;
    char temp;

    for (int j = p; j < r - 1 ; ++j) {
      if (a[j] <= x) {
        i++;
        /*replace strings*/
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    }
    temp = a[i+1];
    a[i+1] = a[r];
    a[r] = temp;

    return i + 1;
  }

  //using MIT's QuickSort
  static char[] sortString(char[] word, int currentIndex, int lastIndex) {
    if (currentIndex < lastIndex) {
      int newIndex = partition(word, currentIndex, lastIndex);
      word = sortString(word, currentIndex, newIndex - 1);
      word = sortString(word, newIndex + 1, lastIndex);
    }

    return word;
  }

  static void processData() {
    String result = findOutWord();
    char[] resultArray = sortString(result.toCharArray(), 0, result.length()-1);
    result = String.copyValueOf(resultArray);

    System.out.println(result);
  }

  public static final void main(String[] args) {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      flag = readData();
    }
  }
}
