import java.util.*;
import java.io.*;

public class uri1025 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberCases = 0;
  static int numberMarbles, numberQueries;
  static int[] marbles, queries, results;

  static boolean readData() throws IOException {
    boolean flag = true;
    String[] line;
    int i;

    try {
      line = in.readLine().split(" ");
      numberMarbles = Integer.parseInt(line[0]);
      numberQueries = Integer.parseInt(line[1]);
      marbles = new int[numberMarbles];
      queries = new int[numberQueries];
      results = new int[numberQueries];

      if (numberMarbles != 0 && numberQueries != 0) {
        for (i = 0; i < numberMarbles; ++i)
          marbles[i] = Integer.parseInt(in.readLine());
        for (i = 0; i < numberQueries; ++i)
          queries[i] = Integer.parseInt(in.readLine());
      }
    }
    catch (Exception NumberFormatException) {
      numberMarbles = numberQueries = 0;
    }

    if (numberMarbles == 0 && numberQueries == 0)
      flag = false;
    return flag;
  }

  static int linearSearch(int[] array, int arraySize, int number) {
    int index = 0;

    try {
      while (array[index] < number) index++;
    }
    catch (Exception ArrayIndexOutOfBoundsException) {
      index = 0;
    }

    if (array[index] == number) return index;
    else return -1;
  }

  static void processData() {
    int index;
    Arrays.sort(marbles);

    for (int query = 0; query < numberQueries; ++query) {
      index = Arrays.binarySearch(marbles, queries[query]);
      try { while (marbles[index] == marbles[index-1]) index--; }
      catch (Exception ArrayIndexOutOfBoundsException) {}
      results[query] = index;
    }
  }

  static void writeData() {
    numberCases++;
    System.out.println("CASE# " +  numberCases + ":");

    for (int result = 0; result < numberQueries; ++result) {
      System.out.print(queries[result] + " ");
      if (results[result] < 0)
        System.out.println("not found");
      else
        System.out.println("found at " + ++results[result]);
    }
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
