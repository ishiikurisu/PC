import java.io.*;

public class pc101102 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static boolean[][] field;
  static int numberField = 1;
  static int[] coordinates = new int[2];

  static final void pass() {}

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
          pass();
        }
      }
    }

    return count;
  }

  static void processData() {
    byte count = 0;

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
    System.out.print("\n");
  }

  public static final void main(String args[]) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      flag = readData();
      numberField++;
    }
  }
}
