import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class uri1556 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static String inlet;

  static boolean readData() throws IOException {
    inlet = in.readLine();
    if (inlet != null) return true;
    else return false;
  }

  public static final void main(String[] args) throws IOException {
    List outlet;
    String newString;

    while (readData()) {
      outlet = new ArrayList<String>();

      for (int i = 1; i < inlet.length() - 1; ++i) {
        for (int j = 0; j < inlet.length() - i + 1; ++j) {
          newString = inlet.substring(j, j + i);
          outlet.add(newString);
        }
      }
      Collections.sort(outlet);

      for (Object out: outlet) {
        System.out.println((String) out);
      }
      System.out.println();
    }
  }
}
