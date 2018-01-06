import java.util.*;

public class uri1001 {
  static Scanner input = new Scanner(System.in);
  static int[] numbers = new int[2];
  static int result;

  static boolean readData() {
    boolean flag = true;

    numbers[0] = numbers[1] = 0;

    numbers[0] = input.nextInt();
    if (numbers[0] == 0) return false;
    numbers[1] = input.nextInt();

    if (numbers[0] == 0 || numbers[1] == 0) {
      flag = false;
    }

    return flag;
  }

  static void processData() {
    result = numbers[0] + numbers[1];
  }

  static void writeData() {
    System.out.println("X = " + result);
  }

  public static final void main(String[] args) {
    boolean flag = readData();

    while (flag) {
      processData();
      writeData();
      flag = readData();
    }
  }
}
