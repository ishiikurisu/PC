import java.util.*;
import java.io.*;

public class roadB {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int[] dimension = new int[2]; // data
  static boolean[][] city;
  static List positions = new LinkedList<Integer>(); // results
  static int biggestSquare = 1;

  static void readData() throws IOException {
    String[] line;
    String region;
    int i, x, y;

    try {
      line = in.readLine().split(" ");
      for (i = 0; i < 2; ++i) dimension[i] = Integer.parseInt(line[i]);
      city = new boolean[dimension[0]][dimension[1]];

      for (y = 0; y < dimension[0]; ++y) {
        region = in.readLine();
        for (x = 0; x < dimension[1]; ++x) {
          city[y][x] = (region.charAt(x) == '.')? true: false;
        }
      }
    }
    catch (Exception NumberFormatException) {}
  }

  static void processData() {
    positions = new LinkedList<Integer>();
    int x, y, i, j;
    int currentSize;
    biggestSquare = 1;
    boolean flag = true;


    for (y = 0; y < dimension[0] - 1; ++y)
    for (x = 0; x < dimension[1] - 1; ++x)
    if (city[y][x]) {
      currentSize = 1;

      try {
        flag = true;
        for (j = y; j < y + currentSize && flag; ++j) {
          flag = true;
          for (i = x; x < x + currentSize; ++i) {
            if (!city[j][i]) {
              flag = false;
              break;
            }
          }
        }
        if (flag) currentSize++;
      }
      catch (Exception ArrayIndexOutOfBoundsException) {
        currentSize += 0;
      }

      if (currentSize > 1) {
        positions.add(x + 1);
        positions.add(y + 1);
      }
      if (currentSize > biggestSquare) biggestSquare = currentSize;
    }


  }

  static void writeData() {
    System.out.print("The side of the square is " + biggestSquare + " ");
    System.out.println("and the locations are:");
    for (int i = 0; i < positions.size(); ++i) {
      System.out.print(positions.get(i));
      i++;
      System.out.println(positions.get(i));
    }
    System.out.println(positions.size() + " in total");
  }

  public static void main(String[] args) throws IOException {
    int numberCases = Integer.parseInt(in.readLine());

    for (int c = 0; c < numberCases; c++) {
      readData();
      processData();
      writeData();
    }
  }

}
