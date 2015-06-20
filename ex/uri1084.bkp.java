import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1084 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberSize;
  static int numberErasings;
  static String numberOnBoard;

  /* AUXILIAR FUNCTIONS */
  static int[] initialize(int difference) {
    int[] positions = new int[difference];

    for (int i = 0; i < difference; ++i)
      positions[i] = i;

    return positions;
  }

  /* MAIN FUNCTIONS */
  static boolean readData() throws IOException {
    String[] line = in.readLine().split(" ");
    numberSize = Integer.parseInt(line[0]);
    numberErasings = Integer.parseInt(line[1]);

    if (numberSize == 0 || numberErasings == 0)
      return false;

    numberOnBoard = in.readLine();
    return true;
  }

  public static final void main(String[] args) throws IOException {
    String numberInMind;
    int biggestNumber;
    int difference;
    int currentNumber;
    int[] positions;
    int i;

    while (readData()) {
      difference = numberSize - numberErasings;
      positions = initialize(difference);
      biggestNumber = 0;

      while (positions[0] != difference && positions[difference - 1] != numberErasings) {
        numberInMind = new String();

        for (i = 0; i < difference; ++i)
          numberInMind.concat(numberOnBoard.substring(positions[i], positions[i]+1));

        try {
          currentNumber = Integer.parseInt(numberInMind);
        }
        catch (Exception NumberFormatException) {
          continue;
        }

        if (currentNumber > biggestNumber)
          biggestNumber = currentNumber;

        i = difference - 1;
        while (positions[i] > numberSize) {
          positions[i] = 0;
          --i;
          ++positions[i];
        }
      }

      System.out.println(biggestNumber);
    }
  }
}
