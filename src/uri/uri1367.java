import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

class uri1367 {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);

  static int numberSubs;
  static String[] submissions;
  static int[] duration;
  static boolean[] results;

  static boolean readData() throws IOException {
    boolean flag = true;
    String[] line;
    int sub;

    numberSubs = Integer.parseInt(in.readLine());
    if (numberSubs == 0) flag = false;
    else {
      submissions = new String[numberSubs];
      duration = new int[numberSubs];
      results = new boolean[numberSubs];

      for (sub = 0; sub < numberSubs; ++sub) {
        line = in.readLine().split(" ");
        submissions[sub] = line[0];
        duration[sub] = Integer.parseInt(line[1]);
        if (line[2].equals("correct")) results[sub] = true;
        else results[sub] = false;
      }
    }

    return flag;
  }

  public static final void main (String[] args) throws IOException {
    int totalCorrect;
    int totalTime;
    Map problemStatus;
    Map problemKind;

    while (readData()) {
      problemStatus = new HashMap<String, Boolean>();
      problemKind = new HashMap<String, Integer>();
      totalCorrect = 0;
      totalTime = 0;

      for (int sub = 0; sub < numberSubs; ++sub) {
        if (results[sub] == true) {
          ++totalCorrect;
          totalTime += duration[sub];
          if (problemKind.containsKey(submissions[sub]))
            totalTime += (int) problemKind.get(submissions[sub]);
          problemStatus.put(submissions[sub], true);
        }
        else {
          if (problemKind.containsKey(submissions[sub])) {
            int tempTime = (int) problemKind.get(submissions[sub]);
            problemKind.remove(submissions[sub]);
            problemKind.put(submissions[sub], tempTime + 20);
          }
          else {
            problemKind.put(submissions[sub], 20);
            problemStatus.put(submissions[sub], false);
          }
        }
      }

      System.out.println(totalCorrect + " " + totalTime);
    }
  }
}
