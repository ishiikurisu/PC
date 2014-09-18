import java.util.*;

public class uva10082 {
  static Scanner input = new Scanner(System.in);
  static Map<String, String> letters = new HashMap();
  static String newPhrase;
  static String oldPhrase;


  static void createMap() {
    letters.put(" ", " ");
    letters.put("Q", "Q");
    letters.put("A", "A");
    letters.put("Z", "Z");
    letters.put(";", ";");
    letters.put(".", ".");
    letters.put("1", "1");

    letters.put("2", "1");
    letters.put("3", "2");
    letters.put("4", "3");
    letters.put("5", "4");
    letters.put("6", "5");
    letters.put("7", "6");
    letters.put("8", "7");
    letters.put("9", "8");
    letters.put("0", "9");
    letters.put("-", "0");
    letters.put("=", "-");
    letters.put("W", "Q");
    letters.put("E", "W");
    letters.put("R", "E");
    letters.put("T", "R");
    letters.put("Y", "T");
    letters.put("U", "Y");
    letters.put("I", "U");
    letters.put("O", "I");
    letters.put("P", "O");
    letters.put("[", "P");
    letters.put("]", "[");
    letters.put("\\", "]");
    letters.put("S", "A");
    letters.put("D", "S");
    letters.put("F", "D");
    letters.put("G", "F");
    letters.put("H", "G");
    letters.put("J", "H");
    letters.put("K", "J");
    letters.put("L", "K");
    letters.put(";", "L");
    letters.put("\'", ";");
    letters.put("X", "Z");
    letters.put("C", "X");
    letters.put("V", "C");
    letters.put("B", "V");
    letters.put("N", "B");
    letters.put("M", "N");
    letters.put(",", "M");
    letters.put(";", ",");
    letters.put("/", ".");
  }

  static boolean readData() {
    boolean flag = true;

    oldPhrase = input.nextLine();
    if (oldPhrase.length() == 0) {
      flag = false;
    }

    return flag;
  }

  static void processData() {
    newPhrase = new String();
    String temp;

    for (int i = 0; i < oldPhrase.length(); ++i) {
      temp = letters.get(oldPhrase.substring(i, i+1));
      if (temp != null) newPhrase = newPhrase.concat(temp);
    }
  }

  static void writeData() {
    System.out.println(newPhrase);
  }

  public static final void main(String[] args) {
    boolean flag = true;

    createMap();
    flag = readData();
    while (flag) {
      processData();
      writeData();
      flag = readData();
    }
  }
}
