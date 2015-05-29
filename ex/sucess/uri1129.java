import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uri1129 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static final int NUMBER_ANSWERS = 5;

  public static final void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());
    int answer, numberAnswers, mark;
    String[] line;

    while (numberCases > 0) {
      for (int i = 0; i < numberCases; ++i) {
        line = in.readLine().split(" ");

        numberAnswers = 0;
        answer = 5;
        for (int c = 0; c < NUMBER_ANSWERS; c++) {
          mark = Integer.parseInt(line[c]);
          if (mark <= 127) {
            answer = c;
            numberAnswers++;
          }
        }

        if (numberAnswers > 1 || answer > 4) System.out.println("*");
        else switch (answer) {
          case 0: System.out.println("A"); break;
          case 1: System.out.println("B"); break;
          case 2: System.out.println("C"); break;
          case 3: System.out.println("D"); break;
          case 4: System.out.println("E"); break;
        }
      }
      numberCases = Integer.parseInt(in.readLine());
    }
  }
}
