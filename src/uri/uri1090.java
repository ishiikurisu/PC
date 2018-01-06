import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class uri1090 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberCards;
  static int[] cardNumbers;
  static String[] cardTypes;
  static int combinations;

  /* AUXILIAR FUNCTIONS */
  static boolean validPermutation(int a, int b, int c) {
    if (a != b && a != c && b != c)
      return true;
    else
      return false;
  }

  static boolean isASet(int a, int b, int c) {
    boolean flag = true;

    /* figure combination */
    if (
      (
        (
          cardNumbers[a] != cardNumbers[b] &&
          cardNumbers[a] != cardNumbers[c] &&
          cardNumbers[b] != cardNumbers[c]
        ) &&
        (
          cardTypes[a].equals(cardTypes[b]) &&
          cardTypes[a].equals(cardTypes[c]) &&
          cardTypes[b].equals(cardTypes[c])
        )
      ) ||
      (
        (
          cardNumbers[a] != cardNumbers[b] &&
          cardNumbers[a] != cardNumbers[c] &&
          cardNumbers[b] != cardNumbers[c]
        ) &&
        (
          cardTypes[a].compareTo(cardTypes[b]) != 0 &&
          cardTypes[a].compareTo(cardTypes[c]) != 0 &&
          cardTypes[b].compareTo(cardTypes[c]) != 0
        )
      )
    )
      flag = true;

    return flag;
  }

  /* MAIN FUNCTIONS */
  static boolean readData() throws IOException {
    String[] line;

    numberCards = Integer.parseInt(in.readLine());
    if (numberCards == 0) return false;
    else {
      cardNumbers = new int[numberCards];
      cardTypes = new String[numberCards];

      for (int c = 0; c < numberCards; c++) {
        line = in.readLine().split(" ");

        cardTypes[c] =  line[1];
        if (line[0].equals("um"))
          cardNumbers[c] = 1;
        else if (line[0].equals("dois"))
          cardNumbers[c] = 2;
        else if (line[0].equals("tres"))
          cardNumbers[c] = 3;
      }
    }

    return true;
  }

  static void processData() {
    combinations = 0;

    for (int a = 0; a < numberCards; ++a) {
      for (int b = a + 1; b < numberCards; ++b) {
        for (int c =  b + 1; c < numberCards; ++c) {
          if (validPermutation(a, b, c) && isASet(a, b, c)) {
            ++combinations;
          }
        }
      }
    }
  }

  static void writeData() {
    System.out.println(combinations);
  }

  public static final void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }
}


/*
if (
  (
    cardNumbers[a] != cardNumbers[b] &&
    cardNumbers[a] != cardNumbers[c] &&
    cardNumbers[b] != cardNumbers[c]
  ) ||
  (
    cardTypes[a].compareTo(cardTypes[b]) != 0 &&
    cardTypes[a].compareTo(cardTypes[c]) != 0 &&
    cardTypes[b].compareTo(cardTypes[c]) != 0
  ) ||
  (
    cardNumbers[a] == cardNumbers[b] &&
    cardNumbers[a] == cardNumbers[c] &&
    cardNumbers[b] == cardNumbers[c]
  ) ||
  (
    cardTypes[a].compareTo(cardTypes[b]) == 0 &&
    cardTypes[a].compareTo(cardTypes[c]) == 0 &&
    cardTypes[b].compareTo(cardTypes[c]) == 0
  )
)
  flag = true;
*/
