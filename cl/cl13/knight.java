import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Knight {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int boardSize;
  static List path;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      boardSize = Integer.parseInt(in.readLine());
    }
    catch (Exception NumberFormatException) {
      boardSize = 0;
    }

    if (boardSize == 0) flag = false;
    return flag;
  }

  static void processData() {
    int[][] board = new int[boardSize][boardSize];
    int[][] position = new
    path = new LinkedList<Integer[]>();

    
  }

  public static final void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }
}
