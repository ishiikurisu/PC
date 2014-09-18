import java.util.Scanner;

public class uva100 {
  public static int algorithm(long number, int count) {
    if (number == 1)
      return count;
    else if (number % 2 == 0)
      return algorithm(number/2, count + 1);
    else
      return algorithm(3*number+1, count + 1);
  }

  public static final void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int biggestCycle = 0;
    int currentCycle;
    int low;
    int high;
    int number;

    while (true) {
      biggestCycle = currentCycle = 0;
      low = input.nextInt();
      high = input.nextInt();

      for (number = low; number <= high; ++number) {
        currentCycle = algorithm(number, 1);
        if (currentCycle > biggestCycle)
          biggestCycle = currentCycle;
      }

      System.out.println(biggestCycle);
    }
  }
}
