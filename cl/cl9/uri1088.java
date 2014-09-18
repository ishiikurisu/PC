import java.util.*;
import java.io.*;

public class uri1088 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int size;
  static int[] sequence;
  static String winner;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      String[] info = in.readLine().split(" ");
      size = Integer.parseInt(info[0]);
      if (size != 0) {
        sequence = new int[size];
        for (int i = 0; i < size; ++i) {
          sequence[i] = Integer.parseInt(info[i+1]);
        }
      }
    }
    catch (Exception NumberFormatException) {
      size = 0;
    }

    if (size == 0) flag = false;
    return flag;
  }

  static void processData() {
    int[] sortedSequence = new int[size];
    int count = 0;

    for (int i = 0; i < size; ++i)
      sortedSequence[i] = sequence[i];
    Arrays.sort(sortedSequence);

    

    if (count % 2 == 0) winner = "Carlos";
    else winner = "Marcelo";
  }

  static void writeData() {
    System.out.println(winner);
  }

  public static void main(String[] args) throws IOException {
    while (readData()) {
      processData();
      writeData();
    }
  }

}
