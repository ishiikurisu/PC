import java.util.*;
import java.io.*;

public class uri1023 {
  static InputStreamReader ir = new InputStreamReader(System.in);
  static BufferedReader in = new BufferedReader(ir);

  static int amount;
  static int[] consuption;
  static Map residents;
  static int cidade = 0;
  static float medium;

  static boolean readData() throws IOException {
    boolean flag = true;

    try {
      amount = Integer.parseInt(in.readLine());
    }
    catch (Exception NumberFormatException) {
      amount = 0;
    }

    if (amount == 0) flag = false;
    else {
      consuption = new int[amount];
      residents = new HashMap<Integer, Integer>();

      for (int i = 0; i < amount; ++i) {
        String[] number = in.readLine().split(" ");
        int resident = Integer.parseInt(number[0]);

        int consume = Integer.parseInt(number[1]);
        medium += consume;
        consuption[i] = consume/resident;

        residents.put(consuption[i], resident);
      }
    }

    return flag;
  }

  static void processData() {
    medium = 0;
    int resident = 0;

    Arrays.sort(consuption);

    for (int i = 0; i < amount; ++i) {
      resident += (int) residents.get(consuption[i]);
      medium += consuption[i];
    }
    medium /= resident;
  }

  static void writeData() {
    cidade++;
    if (cidade != 1) System.out.println("");

    System.out.println("Cidade# " + cidade + ":");
    for (int i = 0; i < amount; ++i) {
      int resident = (int) residents.get(consuption[i]);
      System.out.printf("%d-%d ", resident, consuption[i]);
    }
    System.out.printf("\nConsumo medio: %.2f m3\n", medium);
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
