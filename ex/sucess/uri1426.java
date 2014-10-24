import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1426 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int[][] matrix;

  static int[][] readData() throws IOException {
    matrix = new int[9][9];
    String[] line;

    for (int i = 0; i < 5; ++i) {
      line = in.readLine().split(" ");
      for (int j = 0; j <= i; ++j)
        matrix[2*i][2*j] = Integer.parseInt(line[j]);
    }

    return matrix;
  }

  static void writeData() {
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j <= i; ++j) {
        System.out.print(matrix[i][j]);
        if (j != i) System.out.print(" ");
      }
      System.out.println();
    }
  }

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    int i, j, c;

    for (c = 0; c < numberCases; c++) {
      readData();

      /* odd rows */
      for (i = 2; i < 10; i += 2)
        for (j = 1; j <= i; j += 2)
          matrix[i][j] = (matrix[i-2][j-1] - (matrix[i][j-1] + matrix[i][j+1]))/2;

      /* even rows */
      for (i = 1; i < 8; i += 2)
        for (j = 0; j <= i; ++j)
          matrix[i][j] = matrix[i+1][j] + matrix[i+1][j+1];

      writeData();
    }
  }
}
