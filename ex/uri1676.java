import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

class uri1676 {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);

  static List participants;
  static Map choosen;
  static final int QUEUE_SIZE = 600;

  static List formQueue(int queueSize) {
    int position;
    int number;

    participants = new ArrayList<Integer>();
    for (position = 0, number = 2; position < queueSize; ++position, ++number)
      participants.add(number);

    return participants;
  }

  static void updateList(int lucky) {
    int n = 2;
    int i = 1;

    if (!choosen.containsKey(lucky))
    for (n = 2; n <= lucky; ++n) {
      for (i = n + 1; i < participants.size(); ++i)
        if (i % n == 0)
          participants.remove(new Integer(i));
      choosen.put(n, participants.get(n-1));
    }
  }

  public static final void main(String[] args) {
    participants = formQueue(QUEUE_SIZE);
    choosen = new HashMap<Integer, Integer>();
    int lucky;

    while (true) {
      try {
        lucky = Integer.parseInt(in.readLine());
        if (lucky == 0) break;
        updateList(lucky);
        System.out.println(participants.get(lucky-1));
      }
      catch (Exception any) {
        break;
      }
    }

    lucky = 1;
    for (Object participant: participants) {
      System.out.println(lucky + " " + (int) participant);
      ++lucky;
    }
  }
}
