import java.util.*;
import java.io.*;

public class roadA {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int crossings, streets;
  static boolean[][] cityMap;
  static boolean result;

  static void readData() throws IOException {
    String[] line;
    int a, b;

    try {
      line = in.readLine().split(" ");
      crossings = Integer.parseInt(line[0]);
      streets = Integer.parseInt(line[1]);

      cityMap = new boolean[crossings][crossings];
      for (int street = 0; street < streets; ++streets) {
        line = in.readLine().split(" ");
        a = Integer.parseInt(line[0]);
        b = Integer.parseInt(line[1]);

        cityMap[a][b] = true;
        cityMap[b][a] = true;
      }
    }
    catch (Exception NumberFormatException) { }
  }

  static void processData() {
    List path = new LinkedList<Integer>();
    Queue direction;
    boolean[][] marathonMap = new boolean[crossings][crossings];
    int x, y, cross;
    result = false;

    for (x = 0; x < crossings; ++x)
    for (y = 0; y < crossings; ++y)
      marathonMap[x][y] = cityMap[x][y];

    for (x = 0; x < crossings && !result; ++x) {
      for (cross = 0; cross < crossings; ++cross) {
        if (x == cross) ++cross;
        if (cross == crossings) break;

        direction = new PriorityQueue<Integer>();
        path = new LinkedList<Integer>();
        path.add(cross);
        direction.offer(cross);

        while (direction.size() != 0) {
          y = (int) direction.poll();
          if (y == x) break;

          for (int i = 0; i < crossings; ++i) {
            if (marathonMap[y][i] == true) {
              marathonMap[y][i] = false;
              direction.offer(i);
            }
          }
          path.add(y);
        }

        if (path.indexOf(x) < 0) result = true;
      }
    }
  }

  static void writeData() {
    if (result) System.out.println("Yes");
    else System.out.println("No");
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
