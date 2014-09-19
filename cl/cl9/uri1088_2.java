import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1088_2 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int size;
  static int[][] matrix;
  static String winner;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      String[] info = in.readLine().split(" ");
      size = Integer.parseInt(info[0]);
      if (size != 0) {
        matrix = new int[size][size];

        for (int i = 0; i < size; ++i) {
          int temp = Integer.parseInt(info[i+1]);
          matrix[i][temp - 1] = temp;
        }
      }
    }
    catch (Exception NumberFormatException) {
      size = 0;
    }

    if (size == 0) flag = false;
    return flag;
  }

  // determinant by San Foundry
  static int determinant(int A[][],int N)
  {
      int det=0;
      if(N == 1)
      {
          det = A[0][0];
      }
      else if (N == 2)
      {
          det = A[0][0]*A[1][1] - A[1][0]*A[0][1];
      }
      else
      {
          det=0;
          for(int j1=0;j1<N;j1++)
          {
              int[][] m = new int[N-1][N-1];
              for(int i=1;i<N;i++)
              {
                  int j2=0;
                  for(int j=0;j<N;j++)
                  {
                      if(j == j1)
                          continue;
                      m[i-1][j2] = A[i][j];
                      j2++;
                  }
              }
              det += Math.pow(-1.0,1.0+j1+1.0)* A[0][j1] * determinant(m,N-1);
          }
      }
      return det;
  }

  static void processData() {
    int count = determinant(matrix, size);

    if (count > 0) winner = "Carlos";
    else winner = "Marcelo";
  }

  static void writeData() {
    System.out.println(winner);
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
