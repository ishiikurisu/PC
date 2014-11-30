import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1263 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static String[] words;
  static int frequency;

  static void readData() throws IOException {
    words = in.readLine().split(" ");
  }

  static void processData() {
    String last = words[0].substring(0, 1).toLowerCase();
    String current;
    int count = 0;
    frequency = 0;

    for (String word: words) {
      current = word.substring(0, 1).toLowerCase();
      // System.out.print(count + " ");
      if (last.equals(current) == true)
        ++count;
      else {
        last = current;
        if (count > 1)
          ++frequency;
        count = 1;
      }
    }
    if (count > 1)
      ++frequency;
  }

  static void writeData() {
    System.out.println(frequency);
  }

  public static void main(String[] args) {
    while (true) {
      try {
        readData();
        processData();
        writeData();
      }
      catch (Exception any) {
        break;
      }
    }
  }

}
