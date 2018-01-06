import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1234 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static void main(String[] args) throws IOException {
    String sentence;
    boolean occur = true;

    while (true) {
      sentence = in.readLine();

      for (int c = 0; c < sentence.length(); c++) {
        if (sentence.charAt(c) is a letter) {
          sentence.replace()
          occur = !occur;
        }
      }
    }
  }

}
