import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1181 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static final void main(String[] args) throws IOException {
    double[][] matrix = new double[12][12];
    double sum;
    int line = Integer.parseInt(in.readLine());
    String operation = in.readLine();

    for (int i = 0; i < 12; ++i)
      for (int j = 0; j < 12; ++j)
        matrix[i][j] = Double.parseDouble(in.readLine());

    sum = 0.0;
    for (int x = 0; x < 12; ++x)
      sum += matrix[line][x];

    if (operation.equals("S"))
      System.out.printf("%.1f\n", sum);
    else
      System.out.printf("%.1f\n", sum/12);
  }
}
