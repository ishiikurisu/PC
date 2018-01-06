import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1250 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberBullets;
  static int numberHits;
  static int[] bulletHeight;
  static boolean[] manHeight;

  static void readData() throws IOException {
    String[] heights;
    String jumps;

    numberBullets = Integer.parseInt(in.readLine());
    heights = in.readLine().split(" ");
    jumps =  in.readLine();

    bulletHeight = new int[numberBullets];
    manHeight = new boolean[numberBullets];

    for (int h = 0; h < numberBullets; ++h) {
      bulletHeight[h] = Integer.parseInt(heights[h]);
      //System.out.print(bulletHeight[h]);
    }
    //System.out.println();
    for (int p = 0; p < numberBullets; ++p) {
      if (jumps.substring(p, p+1).equals("J")) {
        manHeight[p] = true;
        //System.out.print("J");
      }
      else {
        manHeight[p] = false;
        //System.out.print("S");
      }
    }
    //System.out.println();
  }

  static void processData() {
    numberHits = 0;

    for (int i = 0; i < numberBullets; ++i) {
      if (manHeight[i] && bulletHeight[i] > 2)
        ++numberHits;
      else if (!manHeight[i] && bulletHeight[i] < 3)
        ++numberHits;
    }
  }

  static void writeData() {
    System.out.println(numberHits);
  }

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());

    for (int c = 0; c < numberCases; c++) {
      readData();
      processData();
      writeData();
    }
  }
}
