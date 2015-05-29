import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1068 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static String input;
  static boolean result;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      input = in.readLine();
    }
    catch (Exception NumberFormatException) {
      input = "";
    }

    if (input.length() == 0) flag = false;
    return flag;
  }

  static void processData() {
    result = true;
    int index = 0;
    int cunt = 0;

    while (index < input.length() && result) {
      if (input.charAt(index) == '(') cunt++;
      else if (input.charAt(index) == ')') cunt--;

      if (cunt < 0) result = false;

      index++;
    }

    if (cunt != 0) result = false;
  }

  static void writeData() {
    String output;

    if (result) output = "correct";
    else output = "incorrect";

    System.out.println(output);
  }

  public static final void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }
}
