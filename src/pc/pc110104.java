import java.util.*;

public class pc110104 {
  static Scanner input = new Scanner(System.in);
  static int size;
  static String sequence;

  static boolean readData() {
    size = input.nextInt();
    sequence = input.next();

    if (size == 0) return false;
    else return true;
  }

  /*
  0
    - -
       |
       |
    - -
       |
       |
    - -

  */

  static void writeData(char number, byte height) {
    switch (height) {
      case 0:
        System.out.print(" ");
        switch (number) {
          case '1':
          case '4':
            for (int i = 0; i < size; ++i)
              System.out.print(" ");
            break;

          default:
          for (int i = 0; i < size; ++i)
            System.out.print("-");
        }
        System.out.print(" ");
        break;
      case 1:
        for (int i = 0; i < ;)

      case 2:

      case 3:

      case 4:
    }
  }

  static void processData() {
    for (byte height = 0; height < 4; ++height) {
      for (int i = 0; i < sequence.length(); ++i) {
        writeData(sequence.charAt(i), height);
      }
    }
  }

  public static final void main(String[] args) {
    boolean flag = false;

    flag = readData();

    while (flag) {
      processData();
      flag = readData();
    }
  }
}
