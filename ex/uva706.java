import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.BitSet;
import java.util.Set;

class InvalidInputException extends Exception {
  public InvalidInputException(){}
}

class uva706 {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);

  static BitSet[] lcdScheme;
  static int lcdSize;
  static String lcdNumber;

  /*
  * MEMORIZATION FUNCTIONS
  */
  static void createMap() {
    lcdScheme = new BitSet[10];
    BitSet scheme;

    /* 0 */
    scheme = new BitSet();
    scheme.set(0, true);
    scheme.set(1, true);
    scheme.set(2, true);
    scheme.set(3, false);
    scheme.set(4, true);
    scheme.set(5, true);
    scheme.set(6, true);
    lcdScheme[0] = scheme;

    /* 1 */
    scheme = new BitSet();
    scheme.set(0, false);
    scheme.set(1, false);
    scheme.set(2, true);
    scheme.set(3, false);
    scheme.set(4, false);
    scheme.set(5, true);
    scheme.set(6, false);
    lcdScheme[1] = scheme;

    /* 2 */
    scheme = new BitSet();
    scheme.set(0, true);
    scheme.set(1, false);
    scheme.set(2, true);
    scheme.set(3, true);
    scheme.set(4, true);
    scheme.set(5, false);
    scheme.set(6, true);
    lcdScheme[2] = scheme;

    /* 3 */
    scheme = new BitSet();
    scheme.set(0, true);
    scheme.set(1, false);
    scheme.set(2, true);
    scheme.set(3, true);
    scheme.set(4, false);
    scheme.set(5, true);
    scheme.set(6, true);
    lcdScheme[3] = scheme;

    /* 4 */
    scheme = new BitSet();
    scheme.set(0, false);
    scheme.set(1, true);
    scheme.set(2, true);
    scheme.set(3, true);
    scheme.set(4, false);
    scheme.set(5, true);
    scheme.set(6, false);
    lcdScheme[4] = scheme;

    /* 5 */
    scheme = new BitSet();
    scheme.set(0, true);
    scheme.set(1, true);
    scheme.set(2, false);
    scheme.set(3, true);
    scheme.set(4, false);
    scheme.set(5, true);
    scheme.set(6, true);
    lcdScheme[5] = scheme;

    /* 6 */
    scheme = new BitSet();
    scheme.set(0, true);
    scheme.set(1, true);
    scheme.set(2, false);
    scheme.set(3, true);
    scheme.set(4, true);
    scheme.set(5, true);
    scheme.set(6, true);
    lcdScheme[6] = scheme;

    /* 7 */
    scheme = new BitSet();
    scheme.set(0, true);
    scheme.set(1, false);
    scheme.set(2, true);
    scheme.set(3, false);
    scheme.set(4, false);
    scheme.set(5, true);
    scheme.set(6, false);
    lcdScheme[7] = scheme;

    /* 8 */
    scheme = new BitSet();
    scheme.set(0, true);
    scheme.set(1, true);
    scheme.set(2, true);
    scheme.set(3, true);
    scheme.set(4, true);
    scheme.set(5, true);
    scheme.set(6, true);
    lcdScheme[8] = scheme;

    /* 9 */
    scheme = new BitSet();
    scheme.set(0, true);
    scheme.set(1, true);
    scheme.set(2, true);
    scheme.set(3, true);
    scheme.set(4, false);
    scheme.set(5, true);
    scheme.set(6, true);
    lcdScheme[9] = scheme;
  }

  /*
  * OUTPUT FUNCTIONS
  */
  static void evenBlock(boolean should, int length) {
    String letter;

    if (should) letter = "-";
    else letter = " ";

    System.out.print(" ");
    for (int d = 0; d < length; ++d)
      System.out.print(letter);
    System.out.print(" ");
  }

  static void oddBlock(boolean left, boolean right, int length) {
      if (left)
        System.out.print("|");
      else
        System.out.print(" ");

      for (int d = 0; d < length; ++d)
        System.out.print(" ");

      if (right)
        System.out.print("|");
      else
        System.out.print(" ");
  }

  /*
  * MAIN FUNCTIONS
  */
  // this functions reads the input and translates it
  static void readData() throws IOException, InvalidInputException {
    String[] line = in.readLine().split(" ");
    lcdSize = Integer.parseInt(line[0]);
    lcdNumber = line[1];

    if (lcdSize == 0)
      throw new InvalidInputException();
  }

  // this function writes data on the display
  static void processData() {
    int length = lcdNumber.length();
    int[] sequence = new int[length];
    BitSet scheme;
    int number;
    int digit;

    for (int s = 0; s < length; ++s)
      sequence[s] = Integer.parseInt(lcdNumber.substring(s, s+1));

    /* top */
    for (number = 0; number < length; ++number) {
      digit = sequence[number];
      scheme = lcdScheme[digit];

      evenBlock(scheme.get(0), lcdSize);
      System.out.print(" ");
    }
    System.out.println();

    /* top half */
    for (int l = 0; l < lcdSize; ++l) {
      for (number = 0; number < length; ++number) {
        digit = sequence[number];
        scheme = lcdScheme[digit];

        oddBlock(scheme.get(1), scheme.get(2), lcdSize);
        System.out.print(" ");
      }
      System.out.println();
    }

    /* middle */
    for (number = 0; number < length; ++number) {
      digit = sequence[number];
      scheme = lcdScheme[digit];

      evenBlock(scheme.get(3), lcdSize);
      System.out.print(" ");
      /*
      if (number < length - 1)
        System.out.print(" ");
      */
    }
    System.out.println();

    /* bottom half */
    for (int l = 0; l < lcdSize; ++l) {
      for (number = 0; number < length; ++number) {
        digit = sequence[number];
        scheme = lcdScheme[digit];

        oddBlock(scheme.get(4), scheme.get(5), lcdSize);
        System.out.print(" ");

        /*
        if (number != length - 1)
          System.out.print(" ");
        else
          System.out.println();
        */
      }
      System.out.println();
    }

    /* bottom */
    for (number = 0; number < length; ++number) {
      digit = sequence[number];
      scheme = lcdScheme[digit];

      evenBlock(scheme.get(6), lcdSize);
      System.out.print(" ");
    }
    System.out.println("\n");
  }

  // this function calls every other function
  public static final void main (String[] args) {
    createMap();

    while (true) {
      try {
        readData();
        processData();
      }
      catch (Exception bitch) {
        break;
      }
    }
  }
}
