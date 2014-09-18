import java.util.*;
import java.io.*;

public class uri1618 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static List coordinates;
  static List place;
  static int numberCases;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      numberCases = Integer.parseInt(in.readLine());
    }
    catch (Exception NumberFormatException) {
      numbersCases = 0;
    }

    if (numberCases == 0) {
      flag = false;
    }
    else {
      coordinates = new LinkedList<String>();
      for (int i = 0; i < numberCases; ++i) {
        coordinates.add(in.readLine());
      }
    }

    return flag;
  }

  static void writeData(boolean result) {
    if (result)
      System.out.println(1);
    else
      System.out.println(0);
  }

  static void processData() {
    for (int i = 0; i < numberCases; ++i) {
      String co0rds = (String) coordinates.get(i);
      String[] coords = co0rds.split(" ");
      place = new LinkedList<Integer>();

      // obtaining coordinates
      for (int j = 0; j < 10; ++j) {
        place.add(Integer.parseInt(coords[j]));
      }

      // checking if point is within boundaries
      
      boolean result = true;

      for (int x = 0; x < 6; ++x) {
        if (coords[x] - coords[x+2] < coords[8 + x%2])
          result = false;
        if (!result)
          break;
      }
      x++;
      if (coords[x] - coords[x+2] < coords[8 + x%2])
        result = false;

      writeData(result);
    }
  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      flag = readData();
    }
  }

}
