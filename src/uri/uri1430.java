import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class uri1430 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static Map lengths;
  static String[] compasses;
  static int correctCompasses;

  static Map createLenghts() {
    Map length = new HashMap<String, Double>();

    length.put("W", 1.0);
    length.put("H", 1.0/2);
    length.put("Q", 1.0/4);
    length.put("E", 1.0/8);
    length.put("S", 1.0/16);
    length.put("T", 1.0/32);
    length.put("X", 1.0/64);

    return length;
  }

  static boolean readData() throws IOException {
    boolean flag = true;
    String line = in.readLine();

    if (line.indexOf("*") >= 0)
      flag = false;
    else
      compasses = line.split("/");

    return flag;
  }

  static void processData() {
    String note;
    correctCompasses = 0;
    double length;

    for (String compass: compasses) {
      length = 0;

      for (int c = 0; c < compass.length(); c++) {
        note = compass.substring(c, c+1);
        length += (double) lengths.get(note);
      }

      if (length == 1.0) {
        ++correctCompasses;
      }
    }
  }

  static void writeData() {
    System.out.println(correctCompasses);
  }

  public static final void main(String[] args) throws IOException {
    lengths = createLenghts();

    while (readData()) {
      processData();
      writeData();
    }
  }
}
