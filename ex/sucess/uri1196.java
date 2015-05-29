import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class uri1196 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);
  static Map keyboard;

  static Map createKeyboard() {
    Map key = new HashMap<String, String>();

    key.put("`", "`");
    key.put("1", "`");
    key.put("2", "1");
    key.put("3", "2");
    key.put("4", "3");
    key.put("5", "4");
    key.put("6", "5");
    key.put("7", "6");
    key.put("8", "7");
    key.put("9", "8");
    key.put("0", "9");
    key.put("-", "0");
    key.put("=", "-");

    key.put("Q", "Q");
    key.put("W", "Q");
    key.put("E", "W");
    key.put("R", "E");
    key.put("T", "R");
    key.put("Y", "T");
    key.put("U", "Y");
    key.put("I", "U");
    key.put("O", "I");
    key.put("P", "O");
    key.put("[", "P");
    key.put("]", "[");
    key.put("\\", "]");

    key.put("A", "A");
    key.put("S", "A");
    key.put("D", "S");
    key.put("F", "D");
    key.put("G", "F");
    key.put("H", "G");
    key.put("J", "H");
    key.put("K", "J");
    key.put("L", "K");
    key.put(";", "L");
    key.put("'", ";");

    key.put("Z", "Z");
    key.put("X", "Z");
    key.put("C", "X");
    key.put("V", "C");
    key.put("B", "V");
    key.put("N", "B");
    key.put("M", "N");
    key.put(",", "M");
    key.put(".", ",");
    key.put("/", ".");

    key.put(" ", " ");

    return key;
  }

  static String translate(String sentence) throws StringIndexOutOfBoundsException {
    String newSentence = new String(
      (String) keyboard.get(sentence.substring(0, 1))
    );

    for (int c = 1; c < sentence.length(); c++) {
      newSentence = newSentence.concat((String) keyboard.get(sentence.substring(c, c+1)));
    }

    return newSentence;
  }

  public static final void main(String[] args) throws IOException {
    boolean flag = true;
    String sentence = new String();
    keyboard = createKeyboard();

    while (flag == true) {
      try {
        sentence = in.readLine();
      }
      catch (Exception NumberFormatException) {
        flag = false;
      }

      try {
        sentence = translate(sentence);
        System.out.println(sentence);
      }
      catch (Exception StringIndexOutOfBoundsException) {
        flag = false;
      }
    }
  }
}
