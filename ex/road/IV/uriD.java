import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class uriD {
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(isr);
  static long low, high;

  static boolean readData() throws IOException {
    try {
      String[] line = in.readLine().split(" ");
      low = Long.parseLong(line[0]);
      high = Long.parseLong(line[1]);

      if (low > high) {
        long temp = low;
        low = high;
        high = temp;
      }
    }
    catch (Exception bitch) {
      return false;
    }

    return true;
  }

  public static final void main(String[] args) throws IOException {
    String word;
    long sum;
    long num;

    while (readData()) {
      sum = 0;

      if (low % 2 == 0) ++low;
      for (num = low; num <= high; num += 2) {
        word = num + "";
        for (int i = 0; i < word.length(); ++i)
          sum += Long.parseLong(word.substring(i, i+1));
      }

      System.out.println(sum);
    }
  }
}
