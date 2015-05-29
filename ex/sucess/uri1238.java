import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1238 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    String[] words;
    String big;
    int limit;

    for (int c = 0; c < numberCases; c++) {
      words = in.readLine().split(" ");
      if (words[0].length() < words[1].length()) {
        limit = words[0].length();
        big = words[1];
      }
      else {
        limit = words[1].length();
        big = words[0];
      }

      for (int i = 0; i < limit; ++i) {
        System.out.print(words[0].substring(i, i+1));
        System.out.print(words[1].substring(i, i+1));
      }
      for (int j = limit; j < big.length(); ++j) {
        System.out.print(big.substring(j, j+1));
      }
      System.out.printf("\n");
    }
  }
}
