import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

class uri1609 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    int numberSheeps;
    int currentSheep;
    Set stockyard;
    String[] line;

    for (int c = 0; c < numberCases; c++) {
      numberSheeps = Integer.parseInt(in.readLine());
      line = in.readLine().split(" ");
      stockyard = new TreeSet<Integer>();

      for (int s = 0; s < numberSheeps; ++s) {
        currentSheep = Integer.parseInt(line[s]);
        stockyard.add(currentSheep);
      }

      System.out.println(stockyard.size());
    }
  }
}
