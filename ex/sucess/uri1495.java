import java.io.*;
import java.util.*;

public class uri1495 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int matches;
  static int goalsToBuy;
  static int[] diff;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      String[] NG = in.readLine().split(" ");
      matches = Integer.parseInt(NG[0]);
      if (matches == 0)
        flag = false;
      else {
        goalsToBuy = Integer.parseInt(NG[1]);
        diff = new int[matches];
        for (int i = 0; i < matches ; ++i) {
          String[] goals = in.readLine().split(" ");
          diff[i] = Integer.parseInt(goals[1]) - Integer.parseInt(goals[0]);
        }
      }
    }
    catch (Exception NumberFormatException) {
      flag = false;
    }

    return flag;
  }

  static void processData() {
    Arrays.sort(diff);

    for (int i = 0; i < matches; ++i) {
      while (diff[i] >= 0 && goalsToBuy > 0) {
        diff[i]--;
        goalsToBuy--;
      }
      if (goalsToBuy == 0)
        break;
    }
  }

  static void writeData() {
    int points = 0;

    for (int i = 0; i < matches; ++i) {
      if (diff[i] == 0)
        points++;
      else if (diff[i] < 0)
        points += 3;
    }

    System.out.println(points);
  }

  public static void main(String[] args) throws IOException {
    boolean flag = true;

    flag = readData();
    while (flag) {
      processData();
      writeData();
      flag = readData();
    }
  }

}
