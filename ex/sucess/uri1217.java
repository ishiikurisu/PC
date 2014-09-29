import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1217 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  public static void main(String[] args) throws IOException {
    int numberDays = Integer.parseInt(in.readLine());
    int[] dayWeight = new int[numberDays];
    double totalCost =  0, totalWeight = 0;
    String[] line;
    boolean flag;

    for (int day = 0; day < numberDays; ++day) {
      totalCost += Double.parseDouble(in.readLine());
      line = in.readLine().split(" ");
      flag = true;

      while (flag) {
        try {
          String lol = line[dayWeight[day]];
          ++dayWeight[day];
        }
        catch(Exception ArrayIndexOutOfBoundsException) {
          flag = false;
        }
      }

      totalWeight += dayWeight[day];

      System.out.println("day " + (day + 1) + ": " + dayWeight[day] + " kg");
    }

    System.out.printf("%.2f kg by day\n", totalWeight/numberDays);
    System.out.printf("R$ %.2f by day\n", totalCost / numberDays);
  }

}
