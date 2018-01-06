import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class uva457 {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);

  static int[] rule;
  static int[] present;
  static final int numberRules = 10;
  static final int numberDishes = 40;

  static void updateData() {
    int[] future = new int[numberDishes];
    int sum;

    sum = present[0] + present[1];
    future[0] = rule[sum];
    for (int p = 1; p < numberDishes - 1; ++p) {
      sum = present[p-1] + present[p] + present[p+1];
      future[p] = rule[sum];
    }

    sum = present[numberDishes-2] + present[numberDishes-1];
    future[numberDishes-1] = rule[sum];
    present = future;
  }

  static void readData() throws IOException {
    String[] line = in.readLine().split(" ");
    rule = new int[numberRules];

    present[19] = 1;
    for (int r = 0; r < numberRules; ++r)
      rule[r] = Integer.parseInt(line[r]);
  }

  static void writeData() {
    char letter;

    for (int d = 0; d < numberDishes; ++d) {
      switch (present[d]) {
        case 1: letter = '.'; break;
        case 2: letter = 'x'; break;
        case 3: letter = 'W'; break;
        default: letter = ' ';
      }

      System.out.print(letter);
    }

    System.out.println();
  }

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());

    for (int c = 0; c < numberCases; c++) {
      present = new int[numberDishes];
      readData();
      writeData();

      for (int d = 0; d < 50; ++d) {
        updateData();
        writeData();
      }
      System.out.println();
    }
  }
}
