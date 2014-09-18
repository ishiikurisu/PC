import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1216 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static double result;
  static int partialSum = 0;
  static int numberFriends = 0;

  static void readData() throws IOException {
    boolean flag = true;

    while (flag == true) {
      String name = in.readLine();
      if (name.length() == 0) {
        flag = false;
      }
      else {
        partialSum += Integer.parseInt(in.readLine());
        numberFriends++;
      }
    }
  }

  static void processData() {
    result = (partialSum + 0.0) / numberFriends;
  }

  static void writeData() {
    System.out.printf("%.1f\n", result);
  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    readData();
    processData();
    writeData();
  }

}
