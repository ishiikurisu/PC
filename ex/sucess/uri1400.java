import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class uri1400 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int people, person, clap;
  static int result;

  static boolean readData() {
    boolean flag = true;
    String[] line;

    try {
      line = in.readLine().split(" ");
      people = Integer.parseInt(line[0]);
      person = Integer.parseInt(line[1]);
      clap = Integer.parseInt(line[2]);
    }
    catch (Exception NumberFormatException) {
      people = person = clap = 0;
    }

    if (people == 0 || person == 0 || clap == 0) flag = false;
    return flag;
  }

  static void processData() {
    int count = 0;
    int round = 0;
    int player = 0;
    byte direction = 1;
    result = 0;

    while (result == 0) {
      /* count */
      player += direction;
      round++;

      //System.out.print(player + " ");
      //System.out.println(round);

      /* clap? */
      if (((round % 7 == 0 || (round + "").indexOf('7') > 0)) &&
      player == person) {
        count++;
        if (count == clap) result = round;
      }

      /* change direction? */
      if (player == people) direction = -1;
      else if (player == 1) direction = 1;
    }
  }

  static void writeData() {
    System.out.println(result);
  }

  public static final void main(String[] args) {
    while (readData()) {
      processData();
      writeData();
    }
  }
}
