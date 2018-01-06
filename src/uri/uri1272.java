import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1272 {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    String inlet;
    String outlet;

    for (int c = 0; c < numberCases; c++) {
      inlet = in.readLine();
      outlet = new String("");

      if (!inlet.substring(0, 1).equals(" "))
        System.out.print(inlet.substring(0, 1));
        // outlet.concat(inlet.substring(0, 1));

      for (int i = 1; i < inlet.length(); ++i)
        if (inlet.substring(i-1,i).equals(" ") &&
        !inlet.substring(i,i+1).equals(" "))
          System.out.print(inlet.substring(i, i+1));
          // outlet.concat(inlet.substring(i, i+1));

      // System.out.println(outlet);
      System.out.println();
    }
  }
}
