import java.io.*;

public class uri1349 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int[][] stdBoard;
  static int[][] cmpBoard;
  static double confidence;
  static int stdSize;

  /* DATA STRUCTURE MANAGEMENT */
  static int[][] readBoard(int dimension) throws IOException {
    int[][] board = new int[dimension*2][dimension];
    int temp;

    for (int i = 0; i < dimension; ++i) {
      String[] numbers = in.readLine().split(" ");
      for (int j = 0; j < dimension; ++j)
        board[i][j] = Integer.parseInt(numbers[j]);
    }

    return board;
  }

  // define direction 
  static double compare() {
    int okTiles = 0;
    int totalTiles = 0;

    for (int i = 0; i < stdSize; ++i) {
      for (int j = 0; j < stdSize; ++j) {
        totalTiles++;
        if (stdBoard[i][j] + 50 > cmpBoard[i][j] &&
        stdBoard[i][j] - 50 < cmpBoard[i][j])
          okTiles++;
      }
    }

    return (okTiles + 0.0)/totalTiles;
  }

  /* MAIN FUNCTIONS */
  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      stdSize = Integer.parseInt(in.readLine());
      if (stdSize > 0) {
        stdBoard = readBoard(stdSize);
        cmpBoard = readBoard(stdSize);
      }
    }
    catch (Exception NumberFormatException) {
      stdSize = 0;
    }

    if (stdSize == 0) flag = false;
    return flag;
  }

  static void processData() {
    confidence = 0;

    double partialConfidence = compare();
    if (partialConfidence > confidence)
      confidence = partialConfidence;

    /*
    for (int i = 0; i < stdSize; ++i) {
      for (int j = 0; j < stdSize; ++j)
        System.out.print(stdBoard[i][j] + " ");
      System.out.println(" ");
    }
    */
  }

  static void writeData() {
    System.out.printf("%.2f\n", confidence*100);
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
