import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class InputException extends Exception {
  public InputException() {}
}

public class uri1366 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberCases;
  static int[] length;
  static int[] quantity;

  static void readData() throws IOException, InputException {
    numberCases = Integer.parseInt(in.readLine());
    String[] line;

    if (numberCases == 0)
      throw new InputException();
    else {
      length = new int[numberCases];
      quantity = new int[numberCases];

      for (int c = 0; c < numberCases; c++) {
        line = in.readLine().split(" ");
        length[c] = Integer.parseInt(line[0]);
        quantity[c] = Integer.parseInt(line[1]);
      }
    }
  }

  public static final void main(String[] args) throws IOException {
    int howMany;

    while (true) {
      try  {
        readData();
        howMany = 0;

        for (int c = 0; c < numberCases; c++) {
          howMany += quantity[c] / 2;
        }

        System.out.println(howMany/2);
      }
      catch (InputException bitch) {
        break;
      }
    }
  }
}
