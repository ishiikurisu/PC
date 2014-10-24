import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

class uva100 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static Map memo = new HashMap<Integer, Integer>();
  static int lowBound, highBound;

  static int cycleLength(int number, int cycle) {
    int offset = cycle;

    if (memo.containsKey(number))
      cycle += (int) memo.get(number);
    else {
      if (number % 2 != 0)
        cycle = cycleLength(number * 3 + 1, ++cycle);
      else
        cycle = cycleLength(number / 2, ++cycle);
      memo.put(number, cycle - offset);
    }

    return cycle;
  }

  static boolean readData() throws IOException {
    boolean flag = true;
    String inlet = in.readLine();

    try {
      String[] line = inlet.split(" ");
      lowBound = Integer.parseInt(line[0]);
      highBound = Integer.parseInt(line[1]);

      if (highBound < lowBound) {
        int temp = highBound;
        highBound = lowBound;
        lowBound = temp;
      }
    }
    catch (Exception NullPointerException) {
      flag = false;
    }

    return flag;
  }

  public static final void main(String[] args) throws IOException {
    int result;
    int biggest;
    memo.put(1, 1);

    while (readData()) {
      biggest = 0;

      for (int n = lowBound; n <= highBound; ++n) {
        result = cycleLength(n, 0);

        if (result > biggest)
          biggest = result;
      }

      System.out.println(lowBound + " " + highBound +  " " + biggest);
    }
  }

}
