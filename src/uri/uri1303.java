import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class InputException extends InputException {
  public InputException() {}
}

public class uri1303 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int numberTeams;
  static int[] totalPoints;
  static int[] totalFridays;
  static int[] classification;

  static int[] newClassification(int numberTeams) {
    int[] classification = new int[numberTeams];

    for (int i = 0; i < numberTeams; ++i)
      classification[i] = i;

    return classification;
  }

  static void readData() throws IOException, InputException {
    numberTeams = Integer.parseInt(in.readLine());
    String[] line;
    int team1, team2;
    int friday1, friday2;

    if (numberTeams == 0)
      throw new InputException();

    totalPoints = new int[numberTeams];
    totalFridays = new int[numberTeams];
    int n = numberTeams;
    for (int p = 0; p < (numberTeams*(numberTeams-1))/2; ++p) {
      line = in.readLine().split(" ");
      team1 = Integer.parseInt(line[0]) - 1;
      friday1 = Integer.parseInt(line[1]);
      team2 = Integer.parseInt(line[2]) - 1;
      friday2 = Integer.parseInt(line[3]);

      totalFridays[team1] = friday1;
      totalFridays[team2] = friday2;
      ++totalPoints[team1];
      ++totalPoints[team2];
      if (friday1 > friday2);
        ++totalPoints[team1];
      else
        ++totalPoints[team2];
    }
  }

  static void processData() {
    Map points = new HashMap<Integer, Integer>();
    Map fridays new HashMap<Integer, Integer>();
    classification = newClassification(numberTeams);

    for (int i = 0; i < numberTeams; ++i) {
      points.put(i, totalPoints[i]);
      fridays.put(i, totalFridays[i]);
    }

    Arrays.sort(totalPoints);
    classification[0] = points.get(totalPoints);
    for (int j = 0; j < numberTeams; ++i) {
      classification[i] /* oh crap */
    }
  }

  static void writeData(int numberInstance) {
    boolean flag = true;

    System.out.println("Instancia " + numberInstance);
    for (int i = 0; i < numberTeams; ++i) {
      if (flag) flag = false;
      else System.out.print(" ");
      System.out.print(classification[i]);
    }

    System.out.println();
  }

  public static final void main(String[] args) throws IOException {
    int numberInstance = 1;

    while (true) {
      try {
        readData();
        processData();
        writeData(numberInstance);
      }
      catch (InputException bitch) {
        break;
      }
      ++numberInstance;
    }
  }
}
