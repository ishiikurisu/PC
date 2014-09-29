public class PascalTriangle {
  private int[][] triangle;

  public PascalTriangle(int size) {
    this.triangle = new int[size][size];

    for (int i = 0; i < size; ++i)
      triangle[i][0] = triangle[i][i] = 1;

    for (int j = 1; j < size; ++j) for (int i = 0; i < j; ++i)
      triangle[i][j] = triangle[i][j-1] + triangle[i-1][j-1];
  }

  public get(int x, int y) {
    return this.triangle[x][y-1];
  }
}
