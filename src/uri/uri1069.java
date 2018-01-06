import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1069 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    String mine;
    int openDiamond, closedDiamond;

    for (int n = 0; n < numberCases; n++) {
      openDiamond = closedDiamond = 0;
      mine = in.readLine();
      for (int c = 0; c <  mine.length(); c++) {
        switch (mine.charAt(c)) {
          case '<':
            openDiamond++;
          break;

          case '>':
            if (openDiamond > 0) {
              openDiamond--;
              closedDiamond++;
            }
          break;
        }
      }
      System.out.println(closedDiamond);
    }
  }
}
