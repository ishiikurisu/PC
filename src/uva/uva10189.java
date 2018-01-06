import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class uva10189 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static boolean[][] field;
  static int[] coordinates = new int[2];

  static void writeField(boolean camp) {
    if (camp)
      System.out.print("*");
    else
      System.out.print(".");
  }

  static byte judgeCamp(int x, int y) {
    int i, j;
    byte count = 0;

    for (i = x - 1; i <= x + 1 ; i++) {
      for (j = y - 1; j <= y + 1; j++) {
        try {
          if (field[i][j]) count++;
        }
        catch(Exception ArrayIndexOutOfBoundsException) {
          continue;
        }
      }
    }

    return count;
  }

  static boolean readData() throws IOException {
    int x, y;
    String line;

    line = in.readLine();
    x = Integer.parseInt((line.split(" "))[0]);
    y = Integer.parseInt((line.split(" "))[1]);
    if (x == 0 || y == 0) return false;
    coordinates[0] = x;
    coordinates[1] = y;
    field = new boolean[x][y];

    for (x = 0; x < coordinates[0]; x++) {
      line = in.readLine();
      for (y = 0; y < coordinates[1]; y++) {
        if (line.charAt(y) == '*')
          field[x][y] = true;
        else
          field[x][y] = false;
      }
    }

    return true;
  }

  public static final void main(String args[]) throws IOException {
    int numberField = 1;
    boolean FIRST = true;
    byte count = 0;

    while (readData()) {
      if (FIRST)
        FIRST = false;
      else
        System.out.print("\n");
      System.out.println("Field #" + numberField + ":");

      for (int i = 0; i < coordinates[0]; ++i) {
        for (int j = 0; j < coordinates[1]; ++j) {
          if (field[i][j]) {
            System.out.print("*");
          }
          else {
            count = judgeCamp(i, j);
            System.out.print(count);
          }
        }
        System.out.print("\n");
      }

      numberField++;
    }
  }
}
